package com.road.taxi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.road.taxi.dto.RideRequestDto;
import com.road.taxi.dto.RideResponseDto;
import com.road.taxi.enums.LoyalityTiers;
import com.road.taxi.enums.TimeofDay;
import com.road.taxi.enums.VehicleType;
import com.road.taxi.service.FareCalculationService;

@SpringBootTest
class TaxiApplicationTests {

	private final FareCalculationService service = new FareCalculationService();
	@Test
	void TESTCalsulateFare() {
		
		RideRequestDto requestDto = new RideRequestDto();
		requestDto.setRideId(null);
		requestDto.setDistance(8.5);
		requestDto.setDuration(25);
		requestDto.setTimeOfDay(TimeofDay.PEAK_HOURS);
		requestDto.setVehicleType(VehicleType.PREMIUM);
		requestDto.setPassengerLoyaltyTier(LoyalityTiers.GOLD);
//		ResponseEntity<Object> response =service.calculateFare(requestDto);
		Exception exception= assertThrows(IllegalArgumentException.class,()-> service.calculateFare(requestDto));
		assertEquals ("Duration mustbe positive", exception.getMessage());
	}

}
