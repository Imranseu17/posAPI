package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.UserDao;
import com.example.pos.api.posAPI.model.JsonData;
import com.example.pos.api.posAPI.model.User;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RequestMapping()
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    private String UPLOAD_DIR = "/home/imran/Documents/Workspace/posAPI/src/uploadDir/";





    @PostMapping("/auth/login/{username}/{password}")
    public String login(@PathVariable("username")String userName,
                        @PathVariable("password")String password){

        User user = userDao.findByUsernameAndPassword(userName,password);

        if(user != null){

            return "Login Successfully";
        }

        else
            return "username or password is does not matched";


    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody JsonData jsonData){

        String name = jsonData.getName();
        String username = jsonData.getUsername();
        String password = jsonData.getPassword();
        String confirmpassword = jsonData.getConfirmpassword();
        String address = jsonData.getAddress();
        String phonenumber = jsonData.getPhonenumber();
        String occupationnname = jsonData.getOccupationnname();

        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setConfirmpassword(confirmpassword);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setOccupationnname(occupationnname);


        if(user != null){
            if(userDao.findByUsername(user.getUsername())!= null) {
                return "This username already exits";
            }

            else {
                userDao.save(user);
                return "Save Successfully";
            }

        }

        else
            return "Save Failed";


    }

    @GetMapping("/findAllUser")
    public List<User> findALLUSer(){

        return userDao.findAll();


    }


    @GetMapping("/findByUser/{username}")
    public User findByUSer(@PathVariable("username") String username){

        return userDao.findByUsername(username);


    }

    @PutMapping("/updateusers/{id}")
    public User updateUser(@PathVariable(value = "id") int userId,
                           @RequestBody JsonData jsonData) {

      Optional<User> user = userDao.findById(userId);

      boolean response =   user.isPresent();

        if(response){
            user.get().setName(jsonData.getName());
            user.get().setUsername(jsonData.getUsername());
            user.get().setPhonenumber(jsonData.getPhonenumber());
            user.get().setPassword(jsonData.getPassword());
            user.get().setConfirmpassword(jsonData.getConfirmpassword());
            user.get().setAddress(jsonData.getAddress());
            user.get().setOccupationnname(jsonData.getOccupationnname());

            User updatedUser = userDao.save(user.get());
            return updatedUser;
        }

        else return null;

    }



    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") int id) {
        userDao.deleteById(id);
    }

    @PostMapping("/uploadImage/{id}")
    public User uploadImage(@PathVariable(value = "id") int id ,
                            @RequestParam(value = "file")
                                    MultipartFile multipartFile){

        try {
            Optional<User> user = userDao.findById(id);
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOAD_DIR+"Upload File"+multipartFile.getOriginalFilename());
            Files.write(path,bytes);
            user.get().setImage(bytes);
            return userDao.save(user.get());
        } catch (MultipartException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }








}
