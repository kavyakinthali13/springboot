package com.learn.busBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.busBooking.dto.BusRouteDto;
import com.learn.busBooking.exception.BusNotFoundException;
import com.learn.busBooking.model.Bus;
import com.learn.busBooking.service.BusSearchService;

public class BusSearchController {
	@Autowired

	BusSearchService busSearchService;
	@PostMapping("/searchbus")

	public ResponseEntity<List<Bus>> viewBuses(BusRouteDto busRouteDto) throws BusNotFoundException {

		List<Bus> buses = busSearchService.findBySourceAndDestinationAndDepatureDate(busRouteDto);

		return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);

	}

}
