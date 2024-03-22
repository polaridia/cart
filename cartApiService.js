import axios from 'axios'

export const getProducts = async () => {
    try {
        const response = await axios.get('http://localhost:8080/products');
        console.log(response)
        return response.data;
    } catch (error) {
        console.error('Error fetching selected products: ', error);
        throw error;
    }
};