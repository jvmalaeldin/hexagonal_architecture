package com.alaeldin.hexgonaluserservice.adapter.out.persistence;

import com.alaeldin.hexgonaluserservice.domain.model.User;
import com.alaeldin.hexgonaluserservice.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceAdapter implements UserRepositoryPort
{
    @Override
    public User save(User User) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }
}
