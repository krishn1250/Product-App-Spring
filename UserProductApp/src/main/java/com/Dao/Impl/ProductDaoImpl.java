package com.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.ProductDao;
import com.entity.Product;
import com.entity.User;
import com.service.ProductService;
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	ProductService productService;

	@Override
	public boolean ProductCreate(Product product) {
	boolean check_create=productService.createProductService(product);
		return check_create;
	}


//
//	@Override
//	public List<Product> ProductRetreive(User user) {
//		   return productService.retreiveProductService(user);
//		
//	}
	

}
