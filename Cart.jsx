import React from 'react';
import { useState, useEffect } from 'react';

import "../CSS/Cart.css";
import "../CSS/fonts.css";
import { useCart } from './CartContext';
import Navbar from "./Navbar";
import { getProducts } from '../cartApiService';
import { deleteProduct } from '../productApiService';

const StarRating = ({ rating }) => (
  <div className="star-rating">
    {[...Array(5)].map((_, index) => (
      <span key={index} className={index < rating ? '' : 'inactive'}>★</span>
    ))}
  </div>
);

const FeedbackForm = () => {
  const [feedback, setFeedback] = React.useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Feedback submitted:', feedback);
    setFeedback('');
  };

  return (
    <form onSubmit={handleSubmit} className="feedback-form">
      <textarea
        value={feedback}
        onChange={(e) => setFeedback(e.target.value)}
        placeholder="Enter your feedback here..."
        className="feedback-textarea"
      ></textarea>
      <button type="submit" className="submit-feedback">Submit Feedback</button>
    </form>
  );
};

const ProductComponent = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await getProducts();
        setProducts(data);
        console.log("all good");
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };
    
  fetchProducts();

  }, []);


  const handleDeleteProduct = (id) => {
    try {
      deleteProduct(id);
    } catch (error) {
      console.error('Error deleting product:', error);
    }
    
  }

  return (
    <div className="cart-item">
      
        {products.map((product) => (
          <div key={product.id} className="product">
            <div className="product-container">
              <h3>{product.productName}</h3>
              <img
                src={product.imageUrl}
                alt={product.productName}
                className="product-image"
              />
              <h3 className="product-name">{product.name}</h3>
              <div className="product-price">Price: £{product.price} x {product.quantity}</div>
              <div className="quantity-control">
                Quantity:
                <input
                  type="number"
                  value={product.quantity}
                  min="1"
                  className="quantity-input"
                />
              </div>
              <StarRating rating={product.rating || 0} />
            </div>
            <button className="add-button">Add to Cart</button>
            <button className="remove-from-selected-button" onClick={() => handleDeleteProduct(product.id)}>
              Remove from selected
              </button>
          </div>
        ))}
    </div>
  )
};

const SelectedItem = ({ product, onQuantityChange }) => {
  return (
    <ProductComponent />
  );
}



const CartItem = ({ item, onQuantityChange, onRemove }) => {
  const [quantity, setQuantity] = useState(item.quantity);

  const handleQuantityChange = (e) => {
    const newQuantity = parseInt(e.target.value, 10);
    setQuantity(newQuantity);
    onQuantityChange(item.id, newQuantity);
  };

  return (
    <div className="cart-item">
      <img src={item.imageUrl} alt={item.name} className="cart-item-image" />
      <div>
        <h3>{item.name}</h3>
        <StarRating rating={item.rating || 0} />
        <p>Price: £{item.price} x {item.quantity}</p>
        <div className="quantity-control">
          Quantity:
          <input
            type="number"
            value={quantity}
            onChange={handleQuantityChange}
            min="1"
            className="quantity-input"
          />
        </div>
        <button className="remove-button">Remove</button>
      </div>
    </div>
  );
};

const CartPage = () => {
  const { cartItems, selectedItems, adjustQuantity } = useCart();
  const totalPrice = cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0);

  return (
    <div className="cart-page">
      <Navbar />
      <SelectedItem />
      <h2>Your Cart</h2>
      {cartItems.length > 0 ? (
        <>
          {cartItems.map((item) => (
            <CartItem
              key={item.id}
              item={item}
              onQuantityChange={adjustQuantity}
            />
          ))}
          <div className="total-price">Total Price: £{totalPrice.toFixed(2)}</div>
          <button className="checkout-button">Checkout</button>
        </>
      ) : <p>Your cart is empty.</p>}
      <FeedbackForm />
    </div>
  );
};

export default CartPage;