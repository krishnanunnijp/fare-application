package com.road.taxi.dto;

import com.road.taxi.enums.LoyalityTiers;
import com.road.taxi.enums.TimeofDay;
import com.road.taxi.enums.VehicleType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RideRequestDto {
	
		@Pattern( message="Invalid rideId format", regexp = "R\\d{5}")
		private String rideId; 
		
		@Positive(message = "Distance must be positive")
		private double distance; 
		@Positive(message = "Duration must be positive")
		private int duration; 
		@NotNull
		private TimeofDay timeOfDay; 
		@NotNull
		private VehicleType vehicleType;
		@NotNull
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
