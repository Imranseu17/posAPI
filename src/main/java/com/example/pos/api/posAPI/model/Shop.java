package com.example.pos.api.posAPI.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shopname;
    private String shopaddress;
    private String shopownername;
    private String shopownerphonenumber;

    @OneToMany
    private Set<Product> product = new HashSet<>();


    public Shop() {
    }

    public Shop(String shopname, String shopaddress, String shopownername, String shopownerphonenumber, Set<Product> product) {
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.shopownername = shopownername;
        this.shopownerphonenumber = shopownerphonenumber;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopname='" + shopname + '\'' +
                ", shopaddress='" + shopaddress + '\'' +
                ", shopownername='" + shopownername + '\'' +
                ", shopownerphonenumber='" + shopownerphonenumber + '\'' +
                ", product=" + product +
                '}';
    }
}
