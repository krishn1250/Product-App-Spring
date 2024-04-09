package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.User;
import com.repo.ProductRepo;
@Service
public class ProductService {
@Autowired
ProductRepo productRepo;
	
public boolean createProductService(Product product) {
	return productRepo.save(product)!=null;
}
//public List<List<Product>> retreiveProductService(User user) {
//    List<List<Product>> productsByUser = new ArrayList<>();
//  
//    return productsByUser;
//}
}
