package com.example.pos.api.posAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String productname;
    private int productprice;
    private int productquantity;

    @ManyToOne
    private ProductSale productSale;

    @ManyToOne
    private Shop shop;

    public Product() {
    }

    public Product(String productname, int productprice, int productquantity, ProductSale productSale, Shop shop) {
        this.productname = productname;
        this.productprice = productprice;
        this.productquantity = productquantity;
        this.productSale = productSale;
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    public ProductSale getProductSale() {
        return productSale;
    }

    public void setProductSale(ProductSale productSale) {
        this.productSale = productSale;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", productquantity=" + productquantity +
                ", productSale=" + productSale +
                ", shop=" + shop +
                '}';
    }
}
