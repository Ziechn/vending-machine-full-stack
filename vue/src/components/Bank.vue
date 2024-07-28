<template>
  <div>
    Bank Balance: ${{ calculateBankBalance }}
  </div>
</template>

<script>
import BankService from '../services/BankService';

export default {
    data() {
        return {
            'bankBalance' : 0
        }
    },
    created() {
        BankService.getBankBalance().then((response) => {
            if (response.status == 200){
                this.bankBalance = response.data;
            }
        }).catch((error) => {
            console.log("Error getting bank balance.");
        })
    },
    computed: {
        calculateBankBalance(){
            return this.bankBalance / 100;
        }
    }
}
</script>

<style>

</style>