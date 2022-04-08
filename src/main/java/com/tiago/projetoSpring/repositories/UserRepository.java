package com.tiago.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.projetoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
