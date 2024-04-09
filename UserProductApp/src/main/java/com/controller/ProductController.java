package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.Dao.ProductDao;
import com.constants.EndPoints;
import com.entity.Product;
import com.entity.User;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Controller
public class ProductController {
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private UserService userService;

    @PostMapping(EndPoints.CREATE_PRODUCT)
    @Transactional
    public String createProduct(HttpServletRequest req) {
        // Retrieve the user object from the session
        User user = (User) req.getSession().getAttribute("user");

        // Check if the user object is null
        if (user == null) {
            // Redirect to the error page if user is not authenticated
            return "redirect:/error.html";
        }

        // Get user from database to ensure it's managed
        User managedUser = userService.getUserByUsername(user.getUsername());

        // Create a new Product object
        Product product = new Product();
        product.setProduct_name(req.getParameter("productName"));
        product.setBrand(req.getParameter("brand"));
        product.setPrice(req.getParameter("price"));
        product.setUser(managedUser); // Use the managed user

        // Save the product
        boolean productCreated = productDao.ProductCreate(product);
        
        // Redirect based on whether product was created successfully
        if (productCreated) {
            return "redirect:/sucess.html";
        } else {
            return "redirect:/error.html";
        }
    }
}
