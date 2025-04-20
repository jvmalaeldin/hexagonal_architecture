package com.alaeldin.hexgonaluserservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<JpaUserEntity,Long>
{

}
