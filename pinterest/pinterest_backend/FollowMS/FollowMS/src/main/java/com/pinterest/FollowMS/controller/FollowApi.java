package com.pinterest.FollowMS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinterest.FollowMS.exception.FollowException;
import com.pinterest.FollowMS.service.FollowService;
@CrossOrigin
@RestController
@RequestMapping(value = "/follow")
public class FollowApi {
	@Autowired
	private FollowService followService;
	@PostMapping(value="/{followerId}/followed/{followedId}")
	public ResponseEntity<String> followUser(@PathVariable Integer followerId,@PathVariable Integer followedId) throws FollowException{
		String ans=followService.followUser(followerId, followedId);
		return new ResponseEntity<String>(ans,HttpStatus.CREATED);
	}
}
