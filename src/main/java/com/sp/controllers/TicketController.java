package com.sp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.DAO.UserDAO;
import com.sp.api.TicketDTO;
import com.sp.service.TicketService;
import com.sp.validators.TicketValidator;

@Controller
public class TicketController {
	
	@Autowired
	private TicketValidator ticketValidator;
	
	@Autowired
	private UserDAO UserDAO;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(ticketValidator);
	}
	
	
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value="/tickets", method = RequestMethod.GET)
	public String showTickets(Model model) {
		
		
		List<TicketDTO> ticketList = ticketService.loadTickets();
		model.addAttribute("tickets", ticketList);
		return "ticket-list";
	}
	
	@RequestMapping(value="/createTicket", method = RequestMethod.GET)
	public String createTicket(Model model) {
		
		TicketDTO ticketDTO = new TicketDTO();
		model.addAttribute("ticketDTO", ticketDTO);
		List<com.sp.api.UserDTO> userList = UserDAO.loadUsers();
		model.addAttribute("users", userList);
				
		return "create-ticket";
	}
	
	@RequestMapping(value="/saveTicket", method = RequestMethod.POST)
	public String createTicket(@Validated TicketDTO ticketDTO, Errors e, Model model) {		
		if(!e.hasErrors()) return "redirect:/tickets";
		else {
			return "create-ticket";
		}
	}
}
