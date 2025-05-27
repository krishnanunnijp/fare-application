package com.road.taxi.model;

public class Breakdown {
	private double distanceCharge; 
	private double durationCharge; 
	private double surgeAmount;
	private double loyaltyDiscount;
	public double getDistanceCharge() {
		return distanceCharge;
	}
	public void setDistanceCharge(double distanceCharge) {
		this.distanceCharge = distanceCharge;
	}
	public double getDurationCharge() {
		return durationCharge;
	}
	public void setDurationCharge(double durationCharge) {
		this.durationCharge = durationCharge;
	}
	public double getSurgeAmount() {
		return surgeAmount;
	}
	public void setSurgeAmount(double surgeAmount) {
		this.surgeAmount = surgeAmount;
	}
	public double getLoyaltyDiscount() {
		return loyaltyDiscount;
	}
	public void setLoyaltyDiscount(double loyaltyDiscount) {
		this.loyaltyDiscount = loyaltyDiscount;
	}

	
	
	
}
