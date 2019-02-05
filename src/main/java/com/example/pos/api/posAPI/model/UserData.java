package com.example.pos.api.posAPI.model;



public class UserData {


    public String name;

    private String username;

    private String password;

    private String confirmpassword;

    private String address;

    private String phonenumber;

    private String occupationnname;


    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOccupationnname() {
        return occupationnname;
    }

    public void setOccupationnname(String occupationnname) {
        this.occupationnname = occupationnname;
    }


}
