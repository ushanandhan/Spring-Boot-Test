package com.ushan.repository;

import org.springframework.data.repository.CrudRepository;

import com.ushan.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUserId(int userId);
}
