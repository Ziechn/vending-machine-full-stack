import axios from 'axios';

export default {
    getAllVendingItems(){
        return axios.get('/all-vending-items');
    },
    getVendingItemById(id){
        return axios.get(`/vending-item/${id}`);
    }
}