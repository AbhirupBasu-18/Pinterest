package com.pinterest.FollowMS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	//follow,unfollow,showlist of all follower and following,show follow and unfollow count
	//follow
	@PostMapping(value="/{followerId}/follow/{followedId}")
	public ResponseEntity<String> followUser(@PathVariable Long followerId,@PathVariable Long followedId) throws FollowException{
		String ans=followService.followUser(followerId, followedId);
		return new ResponseEntity<String>(ans,HttpStatus.CREATED);
	}
	//unfollow
	@DeleteMapping(value="/{followerId}/unfollow/{followedId}")
	public ResponseEntity<String> unFollowUser(@PathVariable Long followerId,@PathVariable Long followedId) throws FollowException{
		String ans=followService.unFollowUser(followerId, followedId);
		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}
}
