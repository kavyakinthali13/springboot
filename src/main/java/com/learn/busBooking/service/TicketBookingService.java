package com.learn.busBooking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.busBooking.exception.BookingDetailsNotFoundException;
import com.learn.busBooking.model.Ticket;
import com.learn.busBooking.repository.TicketBookingRepository;

@Service
public class TicketBookingService {
	@Autowired
	TicketBookingRepository busBookingRepository;
	
	public Ticket saveTicket(Ticket ticket) throws BookingDetailsNotFoundException {
    	if(ticket!=null) {
			
			return busBookingRepository.save(ticket);
		}
		else {
			throw new BookingDetailsNotFoundException("enter your booking details");
		}

	}

}
