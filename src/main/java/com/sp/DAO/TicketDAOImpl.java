package com.sp.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sp.api.TicketDTO;
import com.sp.rowmapper.TicketRowMapper;


@Repository
public class TicketDAOImpl implements TicketDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<TicketDTO> loadTickets() {
		List<TicketDTO> ticketList = new ArrayList<TicketDTO>();
		String sql = "SELECT * FROM tickets";
		ticketList = jdbcTemplate.query(sql, new TicketRowMapper());
		return ticketList;
	}

	@Override
	public String saveTicket(TicketDTO ticketDTO) {
		
		Object [] sqlParameters = {ticketDTO.getEndUser(), ticketDTO.getServiceProvider(), ticketDTO.getTicketSummary()};
		String sql = "INSERT INTO tickets(end_user, service_provider, ticket_summary) VALUES(?,?,?)";
		
		
		try {
			jdbcTemplate.update(sql, sqlParameters);
		} 
		catch (org.springframework.dao.DataIntegrityViolationException e) {
			if(e.getMostSpecificCause().toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`service_platform`.`tickets`, CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`end_user`) REFERENCES `users` (`username`) ON DELETE SET NULL)")) {                
				return "endUserError";
			}
			else if(e.getMostSpecificCause().toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`service_platform`.`tickets`, CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`service_provider`) REFERENCES `users` (`username`) ON DELETE SET NULL)")) {
				return "serviceProviderError";
			}
			else if (e.getCause().getMessage().contains("end_user")) return "endUserFormatError";
			else if (e.getCause().getMessage().contains("service_provider")) return "serviceProviderFormatError";
			else return "ticketSummaryFormatError";
		} 
		catch (Exception e) {
			return e.getCause().getMessage();
		}
		return "";
		
	}
	

}
