package com.example.pos.api.posAPI.model;


import java.util.HashSet;
import java.util.Set;

public class ShopData {

    private String shopname;
    private String shopaddress;
    private String shopownername;
    private String shopownerphonenumber;

    private Set<Product> product = new HashSet<>();

    public ShopData() {
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public String getShopownername() {
        return shopownername;
    }

    public void setShopownername(String shopownername) {
        this.shopownername = shopownername;
    }

    public String getShopownerphonenumber() {
        return shopownerphonenumber;
    }

    public void setShopownerphonenumber(String shopownerphonenumber) {
        this.shopownerphonenumber = shopownerphonenumber;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
