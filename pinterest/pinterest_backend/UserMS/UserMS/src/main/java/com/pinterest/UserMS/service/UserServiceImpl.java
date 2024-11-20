package com.pinterest.UserMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinterest.UserMS.dto.UserDTO;
import com.pinterest.UserMS.entity.User;
import com.pinterest.UserMS.exception.UserException;
import com.pinterest.UserMS.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;
	@Override
	public User findUser(Integer id) {
	
		User us=repo.findById(id).get();
		System.out.println(us.getPassword());
		return us;
	}
	@Override
	public String createUser(UserDTO user) throws UserException{
		try {
			User newUser=new User();
			newUser.setEmail(user.getEmail());
			newUser.setPhoneNumber(user.getPhoneNumber());
			newUser.setUsername(user.getUsername());
			User xUser=repo.save(newUser);
			return "New user has been created with id: "+xUser.getUserId();
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new UserException("User could not be created") ;
		}
		
	}
	@Override
	public List<UserDTO> showAllUsers() throws UserException{
		return null;
	}
}
