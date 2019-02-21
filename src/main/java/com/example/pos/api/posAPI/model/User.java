package com.example.pos.api.posAPI.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    private String name;

    private String username;

    private String password;

    private String confirmpassword;

    private String address;

    private String phonenumber;

    private String occupationnname;

    @Lob
    private byte[] image;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roleSet = new HashSet<>();




    public User() {
    }


    public User(String name, String username, String password, String confirmpassword, String address, String phonenumber, String occupationnname, byte[] image, Set<Role> roleSet) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.address = address;
        this.phonenumber = phonenumber;
        this.occupationnname = occupationnname;
        this.image = image;
        this.roleSet = roleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", occupationnname='" + occupationnname + '\'' +
                ", image=" + Arrays.toString(image) +
                ", roleSet=" + roleSet +
                '}';
    }
}


