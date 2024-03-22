package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin("http://localhost:8080")
public class ProductController {
	@Autowired 
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<ProductDto> products = productService.listProducts();
		return new ResponseEntity<>((products), HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return new ResponseEntity<>(("Product has been added"), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long id) {
		productService.deleteProductById(id);
		return new ResponseEntity<>(("Product has been deleted"), HttpStatus.OK);
	}
}
