package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.Product;
import com.example.pos.api.posAPI.model.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductSaleDao extends JpaRepository<ProductSale,Integer> {

    ProductSale findByShopnameAndPaymentidAndSalesdate(String shopname, int paymentId, Date salesDated);

    ProductSale findByProduct(Product product);

    List<ProductSale> findAllByProduct(List<Product> product);
}
