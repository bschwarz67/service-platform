package com.sp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sp.DAO.TicketDAO;
import com.sp.api.TicketDTO;

@Controller
public class MainController {
	
	
	
	@Autowired
	private TicketDAO TicketDAO;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showHomepage(Model model) {
		
		List<TicketDTO> ticketList = TicketDAO.loadTickets();
		model.addAttribute("tickets", ticketList);
		for(TicketDTO ticket : ticketList) {
			System.out.println(":0 keep going");
			System.out.println(ticket);
		}
		
		return "ticket-list";
	}
	
	
}
