package com.road.taxi.handler;

import com.road.taxi.enums.VehicleType;

public class VehiclePricingHandler {
	
	public static double getMultiplier(VehicleType type) {
		return switch(type) {
		case STANDARD -> 1.0;
		case PREMIUM ->1.5;
		case LUXURY ->1.2;
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
		
	}

}
