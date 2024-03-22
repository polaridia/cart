import React, { useState, useEffect } from "react";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import AccountCircle from "@mui/icons-material/AccountCircle";
import { Link} from "react-router-dom"; 
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../CSS/HomePage.css";
import SearchResults from "./SearchResults.jsx"; 
import { useHistory } from 'react-router-dom';



function HomePage() {
  const [searchTerm, setSearchTerm] = useState('');
  const [productQuantities, setProductQuantities] = useState({});
  const [searchResults, setSearchResults] = useState([]);

  const handleSearchChange = async (e) => {
    const searchTerm = e.target.value.toLowerCase();
    setSearchTerm(searchTerm);

    try {
      const response = await axios.get(`http://localhost:8080/api/all?search=${searchTerm}`);
      setSearchResults(response.data);
    } catch (error) {
      console.error('Error fetching search results:', error);
    }
  };

  return (
    <div>
      <nav className="navbar">
        <button className="cart-button">
        <Link to="/cart">
          <ShoppingCartIcon />
          </Link> 
        </button>

        <button className="account-button">
          <AccountCircle />
        </button>

        {/* NutriFind logo */}
        <div className="navbar-logo">
          <img src="/images/nutrifind.png" alt="nutrifind logo" />
        </div>

      {/* Search bar */}
      <div className="search-bar">
          <input
            style={{
              resize: "none",
              width: "30rem",
              borderColor: "rgb(255, 238, 201)",
              fontSize: "1rem",
              height: "2.5rem",
              borderTopWidth: "0px",
              borderLeftWidth: "0px"
            }}
            placeholder="search"
          value={searchTerm}
          onChange={handleSearchChange}
          />
          {searchResults.length > 0 && <SearchResults results={searchResults} />}
        </div>

      </nav>

     

      <div className="button-container2">
        <button className="home-button">profile</button>
        <button className="home-button">about us</button>
        <button className="home-button">contact us</button>
        <Link to="/NewsLetter">
        <button className="home-button">newsletter</button>
        </Link>
      </div>

      <section>
        <div className="title-container">
         <Link to = "/products"><button className="title-button">Groceries</button></Link> 
          <div className="divider"/>
          <button className="title-button">Packaged</button>
          <div className="divider"/>
          <button className="title-button">Recipes</button>
        </div>

        <div className="video">
          <video className="groceries" loop muted
            onMouseOver={e => e.target.play()}
            onMouseOut={e => e.target.pause()}>
            <source src="home1.mp4" type="video/mp4" />
          </video>

          <video className="packaged-foods" loop muted
            onMouseOver={e => e.target.play()}
            onMouseOut={e => e.target.pause()}>
            <source src="home3.mp4" type="video/mp4" />
          </video>

          <video className="recipes" loop muted
            onMouseOver={e => e.target.play()}
            onMouseOut={e => e.target.pause()}>
            <source src="home2.mp4" type="video/mp4" />
          </video>
        </div>
      </section>
      
    </div>

    
  );
}

export default HomePage;