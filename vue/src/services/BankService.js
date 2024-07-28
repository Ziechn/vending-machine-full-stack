import axios from 'axios';

export default {
    getBankBalance(){
        return axios.get('/get-bank-balance');
    }
}