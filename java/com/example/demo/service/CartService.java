package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AddToCartDto;
import com.example.demo.DTO.CartDto;
import com.example.demo.DTO.CartItemDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	public CartDto listCartItems() {
		List<CartItemDto> cartItems = new ArrayList<>();
		List<Cart> carts = (List<Cart>) cartRepository.findAll();
		for (Cart c : carts) {
			CartItemDto ciDto = convertToDto(c);
			cartItems.add(ciDto);
		}
		
		double totalPrice = 0;
		
		for(CartItemDto cid: cartItems) {
			totalPrice += (cid.getProduct().getPrice() * cid.getQuantity());
		}
		
		return new CartDto(cartItems, totalPrice);
	}
	
	public void addToCart(AddToCartDto addToCartDto, Product product) {
		Cart cart = new Cart(product, addToCartDto.getQuantity());
		cartRepository.save(cart);
	}
	
	public void updateCartItem(AddToCartDto addToCartDto, Product product) {
		Cart cart = cartRepository.findById(addToCartDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Cart", "id", addToCartDto.getId()));
		cart.setQuantity(addToCartDto.getQuantity());
		cartRepository.save(cart);
	}
	
	public void deleteCartItem(Long id) {
		cartRepository.deleteById(id);
	}
	
	public void deleteAllCartItems() {
		cartRepository.deleteAll();
	}
	
	public Optional<Cart> findById(Long id) {
		return cartRepository.findById(id);
	}
	
	public static CartItemDto convertToDto(Cart cart) {
		return new CartItemDto(cart);
	}
	
	public static Cart convertToCart(CartItemDto cartItemDto) {
		Cart cart = new Cart();
		cart.setId(cartItemDto.getId());
		cart.setProduct(cartItemDto.getProduct());
		cart.setQuantity(cartItemDto.getQuantity());
		return cart;
	}
}
