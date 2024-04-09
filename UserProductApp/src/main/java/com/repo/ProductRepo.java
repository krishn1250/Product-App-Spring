package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
public List<Product> findByUser_Username(String username);
}
