package com.tiago.projetoSpring.entities.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tiago.projetoSpring.entities.Category;
import com.tiago.projetoSpring.entities.Product;

public class CategoryDTOAll implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private List<Product> products = new ArrayList<>();
	
	public CategoryDTOAll() {
	}

	public CategoryDTOAll(Category obj) {
		id = obj.getId();
		name = obj.getName();
		products = obj.getProducts();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
}
