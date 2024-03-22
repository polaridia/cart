package com.example.demo.DTO;

import java.util.List;

public class CartDto {
	private List<CartItemDto> cartItems;
	private double totalPrice;
	
	public CartDto() {
	}
	
	public CartDto(List<CartItemDto> cartItemDtoList, double totalPrice) {
		this.cartItems = cartItemDtoList;
		this.totalPrice = totalPrice;
	}
	
	public List<CartItemDto> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
