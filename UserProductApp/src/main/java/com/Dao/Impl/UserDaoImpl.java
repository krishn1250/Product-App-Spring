package com.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;
import com.entity.User;
import com.service.UserService;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserService userService;
	@Override
	public String SignUpUser(User user) {
		return userService.CreateUser(user).toLowerCase();
	}

	@Override
	public User LoginUser(User user) {
		User checkUser = userService.CheckUser(user);
		return checkUser;
	}

}
