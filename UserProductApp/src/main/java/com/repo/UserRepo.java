package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUsernameAndPassword(String name,String password);
	public User findByUsername(String name);
	

}
