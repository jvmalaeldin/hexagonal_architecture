package com.alaeldin.hexgonaluserservice.domain.port.out;

import com.alaeldin.hexgonaluserservice.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort
{
    User save(User User);
    List<User> findAll();
    Optional<User> findById(long id);

}
