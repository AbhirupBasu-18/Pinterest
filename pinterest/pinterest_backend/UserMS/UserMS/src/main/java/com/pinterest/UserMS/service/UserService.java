package com.pinterest.UserMS.service;

import java.util.List;

import com.pinterest.UserMS.dto.UserDTO;
import com.pinterest.UserMS.entity.User;
import com.pinterest.UserMS.exception.UserException;


public interface UserService{
	public User findUser(Integer id);
	public String createUser(UserDTO user) throws UserException;
	public List<UserDTO> showAllUsers() throws UserException;
}
