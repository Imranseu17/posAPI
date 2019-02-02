package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleDao extends JpaRepository<ProductSale,Integer> {
}
