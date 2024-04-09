package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.Dao.Impl.UserDaoImpl;
import com.constants.EndPoints;
import com.entity.Product;
import com.entity.User;
import com.repo.ProductRepo;
import com.repo.UserRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	UserDaoImpl userDaoImpl;
	@GetMapping(EndPoints.USER_HOME)
	public String Home() {
		return "Home.html";
	}
	
   	@PostMapping(EndPoints.USER_SIGNUP)
    public String createUser(HttpServletRequest req) {
      User user=new User();
      user.setUsername(req.getParameter("username"));
      user.setPassword(req.getParameter("confirmPassword"));
      user.setFullName(req.getParameter("fullName"));
     userDaoImpl.SignUpUser(user);
	     return "redirect:/login.html";
	
}
	
	@PostMapping(EndPoints.USER_LOGIN)
	public String getUser(HttpServletRequest req) {
		User user=new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		User loginUser = userDaoImpl.LoginUser(user);
		if(loginUser!=null) {
			user=loginUser;
		 req.getSession().setAttribute("user", user);
			return "redirect:/Product.html";
			
		}
		return "redirect:/error.html";
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//@PostMapping("/product/create/{username}")
//public Product CreateProduct(@RequestBody Product product,
//		@PathVariable("username")String username) {
//	User user=userRepo.findByUsername(username);
//	if(user!=null) {
//		product.setUser(user);
//		System.out.println("hello bros");
//		return productRepo.save(product);
//	}
//	else {
//        // Handle the case where user does not exist
//        // For example, you can return an error message
//        throw new IllegalArgumentException("User with username " + username + " does not exist.");
//    }

