import axios from 'axios';

export default {
    getWalletBalance(){
        return axios.get('/get-wallet-balance');
    },
    updateWalletBalance(wallet){
        return axios.post('/update-wallet-balance', wallet);
    }
}