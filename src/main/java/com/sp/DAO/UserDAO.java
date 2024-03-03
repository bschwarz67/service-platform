package com.sp.DAO;

import java.util.List;

import com.sp.api.UserDTO;

public interface UserDAO {

	List<UserDTO> loadUsers();
}
