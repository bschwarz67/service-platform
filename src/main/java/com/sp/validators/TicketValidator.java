package com.sp.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sp.DAO.TicketDAO;
import com.sp.api.TicketDTO;

public class TicketValidator implements Validator {
	
	@Autowired
	private TicketDAO ticketDAO;
	
	
	public TicketValidator() {
		System.out.println("system message");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return TicketDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		TicketDTO t = (TicketDTO) target;
		String result;
		result = ticketDAO.saveTicket(t);
		System.out.println(result);
		if(result.equals("endUserError") ) {
			e.rejectValue("endUser", "endUserNotFoundError", "endUser not found, please enter a valid endUser");
		}
		else if(result.equals("serviceProviderError") ) {
			e.rejectValue("serviceProvider", "serviceProviderNotFoundError", "serviceProvider not found, please enter a valid serviceProvider");

		}
		else if(result.equals("endUserFormatError") ) {
			e.rejectValue("endUser", "endUserFormatError", "endUserFormatError");
		}
		else if(result.equals("serviceProviderFormatError") ) {
			e.rejectValue("serviceProvider", "serviceProviderFormatError", "serviceProviderFormatError");

		}
		else if(result.equals("ticketSummaryFormatError") ) {
			e.rejectValue("ticketSummary", "ticketSummaryFormatError", "ticketSummaryFormatError");

		}
		else if(!result.equals("")) e.reject("unknown error",result); // catch all 
		//e.reject("unknown error",result);

	}

}
