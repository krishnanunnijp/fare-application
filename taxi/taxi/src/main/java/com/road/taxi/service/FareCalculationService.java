package com.road.taxi.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.road.taxi.dto.RideRequestDto;
import com.road.taxi.dto.RideResponseDto;
import com.road.taxi.handler.LoyalityDiscountHandler;
import com.road.taxi.handler.SurgePricingHandler;
import com.road.taxi.handler.VehiclePricingHandler;
import com.road.taxi.model.AppliedFactor;
import com.road.taxi.model.Breakdown;

import ch.qos.logback.core.util.StringUtil;

@Service
public class FareCalculationService {
	
	public ResponseEntity<Object> calculateFare(RideRequestDto request) {
		try {
			
			ResponseEntity<Object> validate=validateRequest(request);
			if(validate!=null)
				return validate;
			
			double distanceCharge= request.getDistance()*1.5;
			double durationCharge = request.getDuration()*0.34;
			double baseFare =distanceCharge + durationCharge;
		
			List<AppliedFactor> appliedfactors = new ArrayList<>();
		
			double surgeMultiplier = 	SurgePricingHandler.getMultiplier(request.getTimeOfDay());
			if(surgeMultiplier>1.0) {
				appliedfactors.add(new AppliedFactor("PEAK_HOUR_SURGE",surgeMultiplier));
			}
		
			double vehicleMultiplier = 	VehiclePricingHandler.getMultiplier(request.getVehicleType());
			if(vehicleMultiplier>1.0) {
				appliedfactors.add(new AppliedFactor("PREMIUM_VEHICLE",vehicleMultiplier));
			}
		
			double loyalitydiscount = 	LoyalityDiscountHandler.getDiscountPercentage(request.getPassengerLoyaltyTier());
			if(loyalitydiscount>0) {
				appliedfactors.add(new AppliedFactor("LOYALITY_DISCOUNT",loyalitydiscount));
			}
		
			double surgedFare= baseFare*surgeMultiplier*vehicleMultiplier;
			double discountAmount= surgedFare*(loyalitydiscount/100);
			double finalFare = surgedFare - discountAmount;
		
			Breakdown breakdown =new Breakdown();
			breakdown.setDistanceCharge(distanceCharge);
			breakdown.setDurationCharge(durationCharge);
			breakdown.setDurationCharge(durationCharge);
			breakdown.setLoyaltyDiscount(loyalitydiscount);
		
			RideResponseDto rideResponseDto =new RideResponseDto();
			rideResponseDto.setRideId(request.getRideId());
			rideResponseDto.setBaseFare(baseFare);
			rideResponseDto.setFinalFare(finalFare);
			rideResponseDto.setAppliedFacors(appliedfactors);
			rideResponseDto.setBreakdown(breakdown);
			return new ResponseEntity<Object>(rideResponseDto,null, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(null,null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	private ResponseEntity<Object> validateRequest(RideRequestDto request) {
		if(request==null ) {
			return new ResponseEntity<Object>("request is required",null, HttpStatus.BAD_REQUEST);
		}
		
		if( request.getRideId()==null || request.getRideId().isEmpty() ) {
			return new ResponseEntity<Object>("request id is not there",null, HttpStatus.BAD_REQUEST);
		}
		
		if(! request.getRideId().matches("R\\d{5}") ) {
			return new ResponseEntity<Object>("request id is not in format",null, HttpStatus.BAD_REQUEST);
		}
		
		
		if(request.getDistance()<=0 ) {
			return new ResponseEntity<Object>("Distance must be positive",null, HttpStatus.BAD_REQUEST);
		}
		
		if(request.getDuration()<=0 ) {
			return new ResponseEntity<Object>("Duration must be positive",null, HttpStatus.BAD_REQUEST);
		}
		
		if(request.getVehicleType()==null ) {
			return new ResponseEntity<Object>("vehicle type is required",null, HttpStatus.BAD_REQUEST);
		}
		
		if(request.getTimeOfDay()==null ) {
			return new ResponseEntity<Object>("time of day is required",null, HttpStatus.BAD_REQUEST);
		}
		
		if(request.getPassengerLoyaltyTier()==null ) {
			return new ResponseEntity<Object>("time of day is required",null, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}
