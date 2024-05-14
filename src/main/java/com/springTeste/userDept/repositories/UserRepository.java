package com.springTeste.userDept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springTeste.userDept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
