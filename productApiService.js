import axios from 'axios'

export const deleteProduct = async (id) => {
    try {
        const response = await axios.delete(`http://localhost:8080/deleteProduct/${id}`);
        console.log(response)
        return response.data;
    } catch (error) {
        console.error('Error deleting selected products: ', error);
        throw error;
    }
};