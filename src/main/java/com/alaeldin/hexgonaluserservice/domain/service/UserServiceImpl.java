package com.alaeldin.hexgonaluserservice.domain.service;

import com.alaeldin.hexgonaluserservice.domain.model.User;
import com.alaeldin.hexgonaluserservice.domain.port.in.UserService;
import com.alaeldin.hexgonaluserservice.domain.port.out.UserRepositoryPort;


import java.util.List;
import java.util.Optional;


public class UserServiceImpl  implements UserService {

    private  UserRepositoryPort userRepositoryPort;

    public UserServiceImpl(){
    }
    public UserServiceImpl(UserRepositoryPort userRepositoryPort){

        this.userRepositoryPort = userRepositoryPort;
    }
    @Override
    public User createUser(User user) {

        if ((user.getName() == null) &&(user.getEmail()== null))
        {
            throw new IllegalArgumentException("Name and email required");
        }

        return userRepositoryPort.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepositoryPort.findAll();
    }

    @Override
    public User getUserById(long id) {

        return userRepositoryPort.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
}
