package com.pinterest.UserMS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinterest.UserMS.entity.User;


public interface UserRepository extends CrudRepository<User, Integer>{

}
