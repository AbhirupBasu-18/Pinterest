package com.pinterest.FollowMS.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinterest.FollowMS.entity.Follow;
import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Integer> {
	//find if this row exists
	public Follow findByFollowerIdAndFollowedId(Integer followerId,Integer followedId);
	//who follows this person
	public List<Follow> findByFollowedId(Integer followedId);
	//the person follows which people
	public List<Follow> findByFollowerId(Integer followerId);
	
}
