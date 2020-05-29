package com.learn.busBooking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.learn.busBooking.dto.ResponseDto;
import com.learn.busBooking.exception.BookingDetailsNotFoundException;
import com.learn.busBooking.model.Bus;
import com.learn.busBooking.model.Ticket;
import com.learn.busBooking.model.User;
import com.learn.busBooking.repository.TicketBookingRepository;
import com.learn.busBooking.service.TicketBookingService;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.Silent.class)
public class TicketBookingControllerTest {
	@InjectMocks
	TicketBookingController ticketBookingController;

	@Mock
	TicketBookingService ticketBookingService;
	
	@Test
	public void testSaveTicketForNegitive() throws BookingDetailsNotFoundException{
		Ticket ticket=new Ticket();
		User user=new User();
		Bus bus= new Bus();
		bus.setId(23l);
		bus.setDestination("tpt");
		bus.setSource("chennai");
		user.setId(1l);
		ticket.setId(1l);
		ticket.setUser(user);
		Mockito.when(ticketBookingService.saveTicket(Mockito.any(Ticket.class))).thenReturn((ticket));
		ResponseEntity<ResponseDto> resTicket = ticketBookingController.ticketBooking(ticket);
		Assert.assertNotNull(resTicket);
	}
	
	@Test
	public void testSaveTicketForPositive() throws BookingDetailsNotFoundException  {
		Ticket ticket=new Ticket();
		User user=new User();
		Bus bus= new Bus();
		bus.setId(23l);
		bus.setDestination("tpt");
		bus.setSource("chennai");
		user.setId(1l);
		ticket.setId(1l);
		
		ticket.setUser(user);
		Mockito.when(ticketBookingService.saveTicket(ticket)).thenReturn((ticket));
		ResponseEntity<ResponseDto> resTicket = ticketBookingController.ticketBooking(ticket);
		Assert.assertNotNull(resTicket);
	}

	@Test(expected = NullPointerException.class)
	public void testSaveTicketForException() throws BookingDetailsNotFoundException  {
		Ticket ticket=new Ticket();
		Mockito.when(ticketBookingService.saveTicket(Mockito.any(Ticket.class))).thenThrow(NullPointerException.class);
		ResponseEntity<ResponseDto> resTicket = ticketBookingController.ticketBooking(ticket);
	}
}
