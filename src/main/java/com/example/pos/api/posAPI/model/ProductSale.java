package com.example.pos.api.posAPI.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_sale")
public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String shopname;
    private int paymentid;
    private double paymentcharge;
    private double totalamount;
    private String paymentmethod;

    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date salesdate;

    @OneToMany
    private Set<Product> product = new HashSet<>();

    public ProductSale() {
    }

    public ProductSale(String shopname, int paymentid, double paymentcharge, double totalamount, String paymentmethod, Date salesdate, Set<Product> product) {
        this.shopname = shopname;
        this.paymentid = paymentid;
        this.paymentcharge = paymentcharge;
        this.totalamount = totalamount;
        this.paymentmethod = paymentmethod;
        this.salesdate = salesdate;
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

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public double getPaymentcharge() {
        return paymentcharge;
    }

    public void setPaymentcharge(double paymentcharge) {
        this.paymentcharge = paymentcharge;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public Date getSalesdate() {
        return salesdate;
    }

    public void setSalesdate(Date salesdate) {
        this.salesdate = salesdate;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", shopname='" + shopname + '\'' +
                ", paymentid=" + paymentid +
                ", paymentcharge=" + paymentcharge +
                ", totalamount=" + totalamount +
                ", paymentmethod='" + paymentmethod + '\'' +
                ", salesdate=" + salesdate +
                ", product=" + product +
                '}';
    }
}
