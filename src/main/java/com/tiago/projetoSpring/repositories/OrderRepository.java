package com.tiago.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.projetoSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
