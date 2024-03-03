package com.sp.service;

import java.util.List;

import com.sp.api.TicketDTO;

public interface TicketService {

	List<TicketDTO> loadTickets();
	String saveTicket(TicketDTO ticketDTO);
}
