package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.UserDao;
import com.example.pos.api.posAPI.model.UserData;
import com.example.pos.api.posAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
    public String saveUser(@RequestBody UserData userData){

        String name = userData.getName();
        String username = userData.getUsername();
        String password = userData.getPassword();
        String confirmpassword = userData.getConfirmpassword();
        String address = userData.getAddress();
        String phonenumber = userData.getPhonenumber();
        String occupationnname = userData.getOccupationnname();

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
                           @RequestBody UserData userData) {

      Optional<User> user = userDao.findById(userId);

      boolean response =   user.isPresent();

        if(response){
            user.get().setName(userData.getName());
            user.get().setUsername(userData.getUsername());
            user.get().setPhonenumber(userData.getPhonenumber());
            user.get().setPassword(userData.getPassword());
            user.get().setConfirmpassword(userData.getConfirmpassword());
            user.get().setAddress(userData.getAddress());
            user.get().setOccupationnname(userData.getOccupationnname());

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
