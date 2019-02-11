package com.example.pos.api.posAPI.dao;



import com.example.pos.api.posAPI.model.Product;
import com.example.pos.api.posAPI.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ShopDao extends JpaRepository<Shop,Integer> {

    Shop findByShopnameAndShopaddressAndShopownernameAndShopownerphonenumber
            (String shopname, String shopaddress, String shopownername,
             String shopownerphonenumber);

     Shop findByProduct(Product product);

     List<Shop> findAllByProduct(List<Product> product);



}
