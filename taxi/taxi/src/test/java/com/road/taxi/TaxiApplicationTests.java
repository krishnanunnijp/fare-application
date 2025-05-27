package com.road.taxi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
	public void testCalculateFare() {
	    RideRequestDto request = new RideRequestDto();
	    request.setRideId("R12345");
	    request.setDistance(8.5);
	    request.setDuration(25);
	    request.setTimeOfDay(TimeofDay.PEAK_HOURS);
	    request.setVehicleType(VehicleType.PREMIUM);
	    request.setPassengerLoyaltyTier(LoyalityTiers.GOLD);

	    RideResponseDto response = (RideResponseDto) service.calculateFare(request).getBody();
	    assertNotNull(response);
	    assertEquals("R12345", response.getRideId());
	    assertTrue(response.getFinalFare() > 0);
	}


}
