package com.pinterest.FollowMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinterest.FollowMS.entity.Follow;
import com.pinterest.FollowMS.exception.FollowException;
import com.pinterest.FollowMS.repository.FollowRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class FollowServiceImpl  implements FollowService {
	@Autowired
	private FollowRepository repo;
	@Override
	public String followUser(Integer followerId, Integer followedId) throws FollowException {
		Follow res=repo.findByFollowerIdAndFollowedId(followerId, followedId);
		if(res!=null) {
			throw new FollowException("This following has already been done");
		}
		Follow user=new Follow();
		user.setFollowerId(followerId);
		user.setFollowedId(followedId);
		repo.save(user);
		return "Following action has been done";
	}

}
