package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findByProductname(String productname);


}
