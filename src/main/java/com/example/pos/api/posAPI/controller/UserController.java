package com.example.pos.api.posAPI.controller;

import com.example.pos.api.posAPI.dao.UserDao;
import com.example.pos.api.posAPI.model.JsonData;
import com.example.pos.api.posAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
@RestController
public class UserController {

    @Autowired
    UserDao userDao;





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

        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setConfirmpassword(confirmpassword);
        user.setAddress(address);


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








}
