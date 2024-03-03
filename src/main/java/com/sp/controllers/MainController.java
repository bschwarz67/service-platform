package com.sp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.sp.DAO.TicketDAO;
import com.sp.api.TicketDTO;
import com.sp.config.ServicePlatformConfig;

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
