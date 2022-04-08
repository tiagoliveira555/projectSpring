package com.tiago.projetoSpring.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1, "WAITING_PAYMENT"),
	PAID(2, "PAID"),
	SHIPPED(3, "SHIPPED"),
	DELIVERED(4, "DELIVERED"),
	CANCELED(5, "CANCELED");
	
	private Integer cod;
	private String description;
	
	private OrderStatus(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static OrderStatus toEnum(Integer cod) {
		if (cod == null) {
			
		}
		for (OrderStatus x : OrderStatus.values()) {
			if (x.getCod().equals(cod)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid!");
	}
}
