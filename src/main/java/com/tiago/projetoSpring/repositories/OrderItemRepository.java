package com.tiago.projetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.projetoSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
