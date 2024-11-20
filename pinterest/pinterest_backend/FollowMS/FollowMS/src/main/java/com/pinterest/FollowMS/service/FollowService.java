package com.pinterest.FollowMS.service;

import com.pinterest.FollowMS.exception.FollowException;

public interface FollowService {
	//block user-unfollow him,remove me from his followlist,don't show my post to him & vice versa,don't allow him to chat to me,my
	//my username would not be visible to him but his username will be visible to me
	public String followUser(Integer followerId,Integer followedId) throws FollowException;
}
