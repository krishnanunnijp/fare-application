package com.road.taxi.handler;

import com.road.taxi.enums.TimeofDay;

public class SurgePricingHandler {
	
	public static double getMultiplier(TimeofDay timeOfDay) {
		return switch(timeOfDay) {
		case STANDARD -> 1.0;
		case PEAK_HOURS ->1.5;
		case NIGHT ->1.2;
		default -> throw new IllegalArgumentException("Unexpected value: " + timeOfDay);
		};
		
	}

}
