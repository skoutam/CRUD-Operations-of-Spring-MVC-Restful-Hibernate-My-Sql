package com.sk.java.ProductManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.java.ProductManager.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
