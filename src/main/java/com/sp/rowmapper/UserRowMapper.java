package com.sp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sp.api.UserDTO;

public class UserRowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();
		user.setUsername(rs.getString("username"));
		user.setJobTitle(rs.getString("job_title"));
		user.setEnabled(rs.getBoolean("enabled"));
		return user;
	}

}
