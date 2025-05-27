package com.road.taxi.dto;

import com.road.taxi.enums.LoyalityTiers;
import com.road.taxi.enums.TimeofDay;
import com.road.taxi.enums.VehicleType;

import lombok.Data;

@Data
public class RideRequestDto {
	
		private String rideId; 
		private double distance; 
		private int duration; 
		private TimeofDay timeOfDay; 
		private VehicleType vehicleType;
		private LoyalityTiers passengerLoyaltyTier;
		public String getRideId() {
			return rideId;
		}
		public void setRideId(String rideId) {
			this.rideId = rideId;
		}
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public TimeofDay getTimeOfDay() {
			return timeOfDay;
		}
		public void setTimeOfDay(TimeofDay timeOfDay) {
			this.timeOfDay = timeOfDay;
		}
		public VehicleType getVehicleType() {
			return vehicleType;
		}
		public void setVehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
		}
		public LoyalityTiers getPassengerLoyaltyTier() {
			return passengerLoyaltyTier;
		}
		public void setPassengerLoyaltyTier(LoyalityTiers passengerLoyaltyTier) {
			this.passengerLoyaltyTier = passengerLoyaltyTier;
		}

		
		

}
