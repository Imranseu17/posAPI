package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.ProductDao;
import com.example.pos.api.posAPI.dao.ShopDao;
import com.example.pos.api.posAPI.model.Product;
import com.example.pos.api.posAPI.model.Shop;
import com.example.pos.api.posAPI.model.ShopData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping()
public class ShopController {

    @Autowired
    ShopDao shopDao;

    @Autowired
    ProductDao productDao;


   @PostMapping( value = "shop/saveProduct",produces = "application/json")
   public Shop saveProduct(@RequestBody ShopData shopData){

       String shopName = shopData.getShopname();
       String shopOwnerName = shopData.getShopownername();
       String shopOwnerPhoneNumber = shopData.getShopownername();
       String shopAddress = shopData.getShopaddress();

       Set<Product> productSet = shopData.getProduct();


       for (Product product : productSet){

           productDao.save(product);

       }

       Shop shop = new Shop();

       shop.setShopname(shopName);
       shop.setShopownername(shopOwnerName);
       shop.setShopownerphonenumber(shopOwnerPhoneNumber);
       shop.setShopaddress(shopAddress);
       shop.setProduct(productSet);

       return shopDao.save(shop);

   }



    @GetMapping("/findbySearch/{shopname}/{shopaddress}/{shopownername}/{shopownerphonenumber}")
    public Shop findbySearch (@PathVariable("shopname") String shopname,
                              @PathVariable ("shopaddress") String shopaddress,
                              @PathVariable ("shopownername") String shopownername,
                              @PathVariable ("shopownerphonenumber") String shopownerphonenumber)
    {

        return shopDao.findByShopnameAndShopaddressAndShopownernameAndShopownerphonenumber(
                shopname,shopaddress,shopownername,shopownerphonenumber
        );

    }

    @GetMapping("/findByproductName/{productName}")
    public Shop findByProduct(@PathVariable("productName") String productName ){

       return shopDao.findByProduct(productDao.findByProductname(productName));
    }

    @GetMapping("/findAllProduct")
    public List<Shop> findAllProduct(){


       return shopDao.findAllByProduct(productDao.findAll());
    }








}
