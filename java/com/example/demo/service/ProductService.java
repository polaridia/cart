package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductService() {
	}
	
	public static ProductDto convertToDto(Product product) {
		return new ProductDto(product);
	}
	
	public static Product convertToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setId(product.getId());
		product.setProductName(product.getProductName());
		product.setPrice(product.getPrice());
		product.setImageUrl(product.getImageUrl());
		product.setFeedbackForm(product.getFeedbackForm());
		product.setRating(product.getRating());
		return product;
	}
	
	public List<ProductDto> listProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		List<ProductDto> productDtos = new  ArrayList<>();
		for (Product p : products) {
			ProductDto pDto = convertToDto(p); 
			productDtos.add(pDto);
		}
		
		return productDtos;
	}
	
	public void updateQuantity(int quantity, Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		
		ProductDto productDto = convertToDto(product);
		productDto.setQuantity(quantity);
		product = convertToProduct(productDto);
		productRepository.save(product);
	}
	
	public void addProduct(ProductDto productDto) {
		Product product = convertToProduct(productDto);
		productRepository.save(product);
	}
	
	public void deleteProduct(ProductDto productDto) {
		Product product = convertToProduct(productDto);
		productRepository.delete(product);
	}
	
	public void deleteProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepository.delete(product);
	}
	
	public Product getProductById(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		return product;
	}
}
