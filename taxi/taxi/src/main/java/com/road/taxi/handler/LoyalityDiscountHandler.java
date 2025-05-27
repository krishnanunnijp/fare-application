package com.road.taxi.handler;

import com.road.taxi.enums.LoyalityTiers;

public class LoyalityDiscountHandler {

	public static double getDiscountPercentage(LoyalityTiers tier) {
			return switch(tier) {
			case BRONZE -> 0;
			case SILVER ->5;
			case GOLD ->10;
			case PLATINUM ->20;
			default -> throw new IllegalArgumentException("Unexpected value: " + tier);
			};
	}
}
