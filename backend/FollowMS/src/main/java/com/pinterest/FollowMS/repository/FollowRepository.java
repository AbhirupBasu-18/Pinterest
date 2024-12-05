package com.pinterest.FollowMS.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinterest.FollowMS.entity.Follow;
import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Long> {
	//find if this row exists
	public Follow findByFollowerIdAndFollowedId(Long followerId,Long followedId);
	//who follows this person
	public List<Follow> findByFollowedId(Long followedId);
	//the person follows which people
	public List<Follow> findByFollowerId(Long followerId);
	
}
