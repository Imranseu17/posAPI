package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopDao extends JpaRepository<Shop,Integer> {

    Shop findByShopnameAndShopaddressAndShopownernameAndShopownerphonenumber
            (String shopname,String shopaddress,String shopownername,
             String shopownerphonenumber);

}
