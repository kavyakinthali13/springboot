package com.learn.busBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.busBooking.dto.BusRouteDto;
import com.learn.busBooking.exception.BusNotFoundException;
import com.learn.busBooking.model.Bus;
import com.learn.busBooking.repository.BusSearchRepository;

public class BusSearchService {
	 @Autowired

	 BusSearchRepository busSearchRepository;
	  public List<Bus> findBySourceAndDestinationAndDepatureDate(BusRouteDto busRouteDto) throws BusNotFoundException {
	  List<Bus> buses = busSearchRepository.findBusBySourceAndDestinationAndDepartureDate(busRouteDto.getSource(), busRouteDto.getDestination(),busRouteDto.getDepatureDate());
	  if(buses.isEmpty()) {

	   throw new BusNotFoundException("no bus available");

	  } else

	  {

	   return buses;

	  }

	 }

}
