package com.road.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.road.taxi.dto.RideRequestDto;
import com.road.taxi.dto.RideResponseDto;
import com.road.taxi.service.FareCalculationService;

@Controller
@RequestMapping("/api/rides")
public class FareController {
	
	@Autowired
	private FareCalculationService fareCalculationService;	
	
   @PostMapping(value="/fare-calculation")
    public ResponseEntity<Object> helloGFG(@RequestBody RideRequestDto rideRequestDto)
    {
	   
	   
        return fareCalculationService.calculateFare(rideRequestDto);
    }

}
