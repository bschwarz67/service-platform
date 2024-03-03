package com.sp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;

import com.sp.DAO.TicketDAO;
import com.sp.api.TicketDTO;
import com.sp.validators.TicketValidator;

@Service
public class TicketServiceImpl implements TicketService {
	
	
	
	
	@Autowired
	TicketDAO ticketDAO;

	@Override
	public List<TicketDTO> loadTickets() {
		List<TicketDTO> ticketList = ticketDAO.loadTickets();
		return ticketList;
	}

	@Override
	public String saveTicket(TicketDTO ticketDTO) {
		/*
		BeanPropertyBindingResult e = new BeanPropertyBindingResult(ticketDTO, "ticket");
		ticketValidator.validate(ticketDTO, e);
		System.out.println("has error: " + e.hasErrors());
		if (e.hasErrors()) return "error";
		else return "";
		*/
		return null;

	}

}
