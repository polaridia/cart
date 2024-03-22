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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AddToCartDto;
import com.example.demo.DTO.CartDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody AddToCartDto addToCartDto) {
		Product product = productService.getProductById(addToCartDto.getProductId());
		System.out.println("adding product " + product.getProductName() + " to cart...");
		cartService.addToCart(addToCartDto, product);
		return new ResponseEntity<>(("Added to cart"), HttpStatus.CREATED);
	}
	
	@GetMapping("/cart")
	public ResponseEntity<CartDto> getCartItems() {
		CartDto cartDto = cartService.listCartItems();
		return new ResponseEntity<>((cartDto), HttpStatus.OK);
	}
	
	@PutMapping("/update/{cartItemId}")
	public ResponseEntity<String> updateCartItem(@RequestBody AddToCartDto addToCartDto) {
		Product product = productService.getProductById(addToCartDto.getId());
		cartService.updateCartItem(addToCartDto, product);
		return new ResponseEntity<String>(("Cart item updated"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<String> deleteCartItem(@PathVariable("cartItemId") Long cartItemId) {
		cartService.deleteCartItem(cartItemId);
		return new ResponseEntity<String>(("Cart item has been deleted"), HttpStatus.OK);
	}
}