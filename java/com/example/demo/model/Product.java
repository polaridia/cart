package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.DTO.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_SWHK")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "image_url")
	private String imageUrl;

	private String feedbackForm;

	@Column(name = "rating")
	private Double rating;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Cart> carts;

	public Product() {
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Product(String productName, Double price, Integer quantity, String imageUrl, String feedbackForm,
			Double rating) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.feedbackForm = feedbackForm;
		this.rating = rating;
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

	@Override
	public String toString() {
		return "CartItem{" + "id=" + id + // Include productId in toString
				", productName='" + productName + '\'' + ", price=" + price + ", quantity=" + quantity + ", imageUrl='"
				+ imageUrl + '\'' + ", feedbackForm='" + feedbackForm + '\'' + ", rating=" + rating + '}';
	}

}
