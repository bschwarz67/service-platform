package com.sp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sp.api.TicketDTO;


public class TicketRowMapper implements RowMapper<TicketDTO> {

	@Override
	public TicketDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TicketDTO ticket = new TicketDTO();
		ticket.setTicketID(rs.getInt("ticket_id"));
		ticket.setEndUser(rs.getString("end_user"));
		ticket.setServiceProvider(rs.getString("service_provider"));
		ticket.setTicketSummary(rs.getString("ticket_summary"));
		return ticket;
	}

}
