package com.example.demo.DTO;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;

import jakarta.validation.constraints.NotNull;

public class CartItemDto {
	private Long id;
	private @NotNull Integer quantity;
	private @NotNull Product product;
	
	public CartItemDto() {
	}
	
	public CartItemDto(Cart cart) {
		this.setId(cart.getId());
		this.setProduct(cart.getProduct());
		this.setQuantity(cart.getQuantity());
	}

	@Override
	public String toString() {
		return "CartItemDto [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
