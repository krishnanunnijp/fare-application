package com.road.taxi.dto;

import java.util.List;

import com.road.taxi.model.AppliedFactor;
import com.road.taxi.model.Breakdown;

public class RideResponseDto {
		private String rideId;
		double baseFare; 
		double finalFare; 
		private List<AppliedFactor> appliedFacors;
		private Breakdown breakdown;
		public String getRideId() {
			return rideId;
		}
		public void setRideId(String rideId) {
			this.rideId = rideId;
		}
		public double getBaseFare() {
			return baseFare;
		}
		public void setBaseFare(double baseFare) {
			this.baseFare = baseFare;
		}
		public double getFinalFare() {
			return finalFare;
		}
		public void setFinalFare(double finalFare) {
			this.finalFare = finalFare;
		}
		public List<AppliedFactor> getAppliedFacors() {
			return appliedFacors;
		}
		public void setAppliedFacors(List<AppliedFactor> appliedFacors) {
			this.appliedFacors = appliedFacors;
		}
		public Breakdown getBreakdown() {
			return breakdown;
		}
		public void setBreakdown(Breakdown breakdown) {
			this.breakdown = breakdown;
		}
		

}
