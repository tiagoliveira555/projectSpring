package com.tiago.projetoSpring.services;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.projetoSpring.entities.Category;
import com.tiago.projetoSpring.entities.Order;
import com.tiago.projetoSpring.entities.OrderItem;
import com.tiago.projetoSpring.entities.Product;
import com.tiago.projetoSpring.entities.User;
import com.tiago.projetoSpring.entities.enums.OrderStatus;
import com.tiago.projetoSpring.repositories.CategoryRepository;
import com.tiago.projetoSpring.repositories.OrderItemRepository;
import com.tiago.projetoSpring.repositories.OrderRepository;
import com.tiago.projetoSpring.repositories.ProductRepository;
import com.tiago.projetoSpring.repositories.UserRepository;

@Service
public class DbService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public void dbInstance() {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Loren ipsum dolor sit amet", 90.5);
		Product p2 = new Product(null, "Smart TV", "Loren ipsum dolor sit amet", 2190.0);
		Product p3 = new Product(null, "MacBook Pro", "Loren ipsum dolor sit amet", 1250.0);
		Product p4 = new Product(null, "PC Gamer", "Loren ipsum dolor sit amet", 1200.0);
		Product p5 = new Product(null, "Rails for Dummes", "Loren ipsum dolor sit amet", 100.99);

		cat1.getProducts().addAll(Arrays.asList(p2));
		cat2.getProducts().addAll(Arrays.asList(p1, p5));
		cat3.getProducts().addAll(Arrays.asList(p2, p3, p4));
		
		p1.getCategories().addAll(Arrays.asList(cat2));
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().addAll(Arrays.asList(cat3));
		p4.getCategories().addAll(Arrays.asList(cat3));
		p5.getCategories().addAll(Arrays.asList(cat2));
		
		User u1 = new User(null, "Maria Brown", "54102352074", "maria@gmail.com", "123");
		User u2 = new User(null, "Alex Green", "49999999000", "alex@gmail.com", "123");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		u1.getOrders().addAll(Arrays.asList(o1, o3));
		u2.getOrders().addAll(Arrays.asList(o2));

		OrderItem oi1 = new OrderItem(p1, o1, 2, 90.5);
		OrderItem oi2 = new OrderItem(p3, o1, 1, 1250.0);
		OrderItem oi3 = new OrderItem(p3, o2, 2, 1250.0);
		OrderItem oi4 = new OrderItem(p5, o3, 2, 100.99);
		
		p1.getOrders().addAll(Arrays.asList(oi1));
		p3.getOrders().addAll(Arrays.asList(oi2, oi3));
		p5.getOrders().addAll(Arrays.asList(oi4));
		
		categoryRepository.saveAll(List.of(cat1, cat2, cat3));
		productRepository.saveAll(List.of(p1, p2, p3, p4, p5));
		userRepository.saveAll(List.of(u1, u2));
		orderRepository.saveAll(List.of(o1, o2, o3));
		orderItemRepository.saveAll(List.of(oi1, oi2, oi3, oi4));
	}
}
