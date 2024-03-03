package com.sp.DAO;

import java.util.List;

import com.sp.api.TicketDTO;

public interface TicketDAO {
	List<TicketDTO> loadTickets();
	String saveTicket(TicketDTO ticketDTO);
}
