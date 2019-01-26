package com.example.pos.api.posAPI.dao;

import com.example.pos.api.posAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username, String password);

}
