package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.ProductSaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()
@RestController
public class ProductSaleController {

    @Autowired
    ProductSaleDao productSaleDao;


}
