package com.learn.busBooking.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.learn.busBooking.exception.BookingDetailsNotFoundException;
import com.learn.busBooking.model.Bus;
import com.learn.busBooking.model.Ticket;
import com.learn.busBooking.model.User;
import com.learn.busBooking.repository.TicketBookingRepository;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.Silent.class)
public class TicketBookingServiceTest {
	
	@InjectMocks
	TicketBookingService ticketBookingService;

	@Mock
	TicketBookingRepository ticketBookingRepository;
	
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
		Mockito.when(ticketBookingRepository.save(Mockito.any(Ticket.class))).thenReturn((ticket));
		Ticket resTicket = ticketBookingService.saveTicket(ticket);;
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
		Mockito.when(ticketBookingRepository.save(ticket)).thenReturn((ticket));
		Ticket resTicket = ticketBookingService.saveTicket(ticket);
		Assert.assertNotNull(resTicket);
		Assert.assertEquals(ticket.getId(), resTicket.getId());
	}

	@Test(expected = NullPointerException.class)
	public void testSaveTicketForException() throws BookingDetailsNotFoundException  {
		Ticket ticket=new Ticket();
		Mockito.when(ticketBookingRepository.save(Mockito.any(Ticket.class))).thenThrow(NullPointerException.class);
		Ticket resTicket = ticketBookingService.saveTicket(ticket);
	}
	
	

}
