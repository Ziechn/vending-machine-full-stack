import axios from 'axios';

export default {
    getAllOrders(){
        return axios.get('/get-all-orders');
    },
    getMyOrders(){
        return axios.get('/get-my-orders');
    },
    getOrder(orderId){
        return axios.get(`/get-order/${orderId}`);
    }
}