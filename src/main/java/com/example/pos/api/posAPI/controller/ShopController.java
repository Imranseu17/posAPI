package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ShopController {

    @Autowired
    ShopDao shopDao;







}
