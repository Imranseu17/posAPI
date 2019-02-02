package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findByProductname(String productname);
}
