package com.example.pos.api.posAPI.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductSaleData {

    private String shopname;
    private int paymentid;
    private double paymentcharge;
    private double totalamount;
    private String paymentmethod;
    private Date salesdate;
    private Set<Product> product = new HashSet<>();

    public ProductSaleData() {
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
}
