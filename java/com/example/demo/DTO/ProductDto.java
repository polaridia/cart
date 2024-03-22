package com.example.demo.DTO;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;

public class ProductDto {
	private Long id;
	private String productName;
	private Double price;
	private Integer quantity;
	private String imageUrl;
	private String feedbackForm;
	private Double rating;
	private Cart cart;
	
	public ProductDto(Product product) {
		this.setId(product.getId());
		this.setProductName(product.getProductName());
		this.setPrice(product.getPrice());
		this.setImageUrl(product.getImageUrl());
		this.setFeedbackForm(product.getFeedbackForm());
		this.setRating(product.getRating());
	}
	
	public ProductDto() {
	}
	
	
	public ProductDto(String productName, double price, Integer quantity, String imageUrl, String feedbackForm,
			Double rating) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.feedbackForm = feedbackForm;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ ", imageUrl=" + imageUrl + ", feedbackForm=" + feedbackForm + ", rating=" + rating + ", cart=" + cart
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFeedbackForm() {
		return feedbackForm;
	}

	public void setFeedbackForm(String feedbackForm) {
		this.feedbackForm = feedbackForm;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
