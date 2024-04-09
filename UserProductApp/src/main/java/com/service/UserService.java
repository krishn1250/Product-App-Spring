package com.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.entity.Userhashdata;
import com.repo.ProductRepo;
import com.repo.UniqueCodeRepo;
import com.repo.UserRepo;
@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	ProductRepo productRepo;
    @Autowired
	UniqueCodeRepo uniqueCodeRepo;
	

	public String CreateUser(User user) {
		Userhashdata uniqueCode=new Userhashdata();
		uniqueCode.setHashCodeUsername(user.getUsername());
		uniqueCode.setUserhashcode(user.getPassword().hashCode());
	User save = userRepo.save(user);
	if(save!=null) {
		uniqueCodeRepo.save(uniqueCode);
		return "UserCreated";
	}
	return "InvalidData";	
        }
	public User CheckUser(User user) {
	User check_user = userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	System.out.println("user Found");
	
 Userhashdata byUserhashcode = uniqueCodeRepo.findByUserhashcode(user.getPassword().hashCode());
 if(byUserhashcode!=null) {
	 System.out.println("password matched");
	 return check_user;
 }
 else {
	 System.out.println("password not matched");
 }
	
		return null;
	}
	public User getUserByUsername(String username) {
	User byId = userRepo.findByUsername(username);
		return byId;
	}
}
