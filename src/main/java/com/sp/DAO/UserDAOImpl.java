package com.sp.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sp.api.UserDTO;
import com.sp.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserDTO> loadUsers() {
		List<UserDTO> userList = new ArrayList<UserDTO>();
		
		String sql = "SELECT * FROM users";
		
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		
		return userList;
	}

}
