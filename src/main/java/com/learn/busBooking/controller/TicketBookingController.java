package com.learn.busBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.busBooking.dto.ResponseDto;
import com.learn.busBooking.exception.BookingDetailsNotFoundException;
import com.learn.busBooking.model.Ticket;
import com.learn.busBooking.service.TicketBookingService;

@RestController
public class TicketBookingController {
	
	@Autowired
	TicketBookingService ticketBookingService;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<ResponseDto> ticketBooking(@RequestBody Ticket ticket) throws BookingDetailsNotFoundException {
		ResponseDto ticketResponseDto=new ResponseDto();
		ticketBookingService.saveTicket(ticket);
		ticketResponseDto.setMessage("tickets booked successfully");
		return new ResponseEntity<ResponseDto>(ticketResponseDto, HttpStatus.OK);
		
	
		
	}
	

}
