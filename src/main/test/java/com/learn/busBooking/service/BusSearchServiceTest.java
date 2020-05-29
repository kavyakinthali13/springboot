package com.learn.busBooking.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import com.learn.busBooking.dto.BusRouteDto;
import com.learn.busBooking.exception.BusNotFoundException;
import com.learn.busBooking.model.Bus;
import com.learn.busBooking.repository.BusSearchRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class BusSearchServiceTest {

	@InjectMocks

	BusSearchService busSearchService;

	@Mock

	BusSearchRepository busSearchRepository;

	@Test

	public void tesfindBySourceAndDestinationAndDepatureDate() {

		List<Bus> buses = new ArrayList<>();

		Bus bus = new Bus();

		bus.setId(1L);

		bus.setSource("srikakulam");

		bus.setDestination("pune");

		bus.setArrivalDate("2020-05-14");

		bus.setDepartureDate("2020-05-12");

		buses.add(bus);

		bus.setId(2L);

		bus.setSource("srikakulam");

		bus.setDestination("pune");

		bus.setArrivalDate("2020-05-14");

		bus.setDepartureDate("2020-05-12");

		buses.add(bus);

		busSearchRepository.saveAll(buses);

		BusRouteDto busRouteDto = new BusRouteDto();

		busRouteDto.setSource("srikakulam");

		busRouteDto.setDestination("pune");

		busRouteDto.setDepatureDate("2020-05-12");

		OngoingStubbing<List<Bus>> buses1 = Mockito
				.when(busSearchRepository.findBusBySourceAndDestinationAndDepartureDate(busRouteDto.getSource(),
						busRouteDto.getDestination(), busRouteDto.getDepatureDate()))
				.thenReturn(buses);

		Assert.assertNotNull(buses1);

	}

}