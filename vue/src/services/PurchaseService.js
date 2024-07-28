import axios from 'axios';

export default {
    purchaseItem(purchase){
        return axios.post('/order', purchase);
    }
}