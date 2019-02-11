package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.ProductDao;
import com.example.pos.api.posAPI.dao.ProductSaleDao;
import com.example.pos.api.posAPI.model.Product;
import com.example.pos.api.posAPI.model.ProductSale;
import com.example.pos.api.posAPI.model.ProductSaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RequestMapping()
@RestController
public class ProductSaleController {

    @Autowired
    ProductSaleDao productSaleDao;


    @Autowired
    ProductDao productDao;

    @PostMapping("/save/saleProduct")
    public ProductSale  saleProduct(@RequestBody ProductSaleData productSaleData){

            String shopname = productSaleData.getShopname();
            int paymentid = productSaleData.getPaymentid();
            double paymentcharge = productSaleData.getPaymentcharge();
            double totalamount = productSaleData.getTotalamount();
            String paymentmethod = productSaleData.getPaymentmethod();
            Date paymentDate = productSaleData.getSalesdate();

       Set<Product> productSet = productSaleData.getProduct();

       for (Product product : productSet){

           productDao.save(product);
       }

      return productSaleDao.save(new ProductSale(shopname,paymentid,
               paymentcharge,totalamount,paymentmethod,paymentDate,productSet));




    }

    @GetMapping("/findbySearch/{shopname}/{paymentId}/{salesDate}")
    public ProductSale findbySearch (@PathVariable("shopname") String shopname,
                              @PathVariable ("paymentID") int paymentID,
                              @PathVariable ("salesDate") Date salesDate)
    {

        return productSaleDao.save(productSaleDao.findByShopnameAndPaymentidAndSalesdate(
            shopname,paymentID,salesDate
        ));

    }

    @GetMapping("/findByProductName/{productName}")
    public ProductSale findByProductName(@PathVariable("productName") String productName ){

        return productSaleDao.findByProduct(productDao.findByProductname(productName));
    }

    @GetMapping("/findAllSalesProduct")
    public List<ProductSale> findAllSalesProduct(){


        return productSaleDao.findAllByProduct(productDao.findAll());
    }





}
