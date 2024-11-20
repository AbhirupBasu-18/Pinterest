package com.pinterest.UserMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinterest.UserMS.dto.UserDTO;
import com.pinterest.UserMS.entity.User;
import com.pinterest.UserMS.exception.UserException;
import com.pinterest.UserMS.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<User> findUser(@PathVariable Integer id){
		User ans=userService.findUser(id);
		return new ResponseEntity<User>(ans,HttpStatus.CREATED);
	}
	@GetMapping(value = "/")
	public String d(HttpServletRequest request){
		
		return "done"+request.getSession().getId();
	}
	@PostMapping(value = "/create")
	public ResponseEntity<String> createUser(@RequestBody UserDTO user) throws UserException {
		String ans=userService.createUser(user);
		return new ResponseEntity<String>(ans,HttpStatus.CREATED);
	}
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<UserDTO>> showAllUsers(){
		return null;
	}
	@PostMapping(value = "/register")
	public String register(){
		
		return "done";
	}
	@PostMapping(value = "/loginByPhNo")
	public String loginByPhNo(){
		
		return "done";
	}
	@PostMapping(value = "/loginByEmailId")
	public String loginByEmailId(){
		
		return "done";
	}
	
}
