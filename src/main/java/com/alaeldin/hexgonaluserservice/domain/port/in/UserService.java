package com.alaeldin.hexgonaluserservice.domain.port.in;

import com.alaeldin.hexgonaluserservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
}
