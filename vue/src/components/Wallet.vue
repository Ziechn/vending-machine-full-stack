<template>
  Wallet: {{ calculateWalletBalance }}
  <button v-on:click="addOneDollarToWallet">Add $1</button>
  <button v-on:click="addFiveDollarsToWallet">Add $5</button>
  <button v-on:click="addTenDollarsToWallet">Add $10</button>
</template>

<script>
import WalletService from '../services/WalletService'

export default {
    data() {
        return {
            wallet: {
                'balance' : 0
            }
        }
    },
    methods: {
        addOneDollarToWallet() {
            this.wallet.balance += 100;
            if (this.$store.state.token != ''){
                this.updateWalletBalance();
                this.getNewWalletBalance();
            }
        },
        addFiveDollarsToWallet(){
            this.wallet.balance += 500;
            if (this.$store.state.token != ''){
                this.updateWalletBalance();
                this.getNewWalletBalance();
            }
        },
        addTenDollarsToWallet(){
            this.wallet.balance += 1000;
            if (this.$store.state.token != ''){
                this.updateWalletBalance();
                this.getNewWalletBalance();
            }
        },
        updateWalletBalance(){
            WalletService.updateWalletBalance(this.wallet).then((response) => {
                if (response.status == 200){
                    console.log("Wallet updated!");
                }
            }).catch((error) => {
                console.log("Wallet was not updated.");
            })
        },
        getNewWalletBalance(){
            WalletService.getWalletBalance().then((response) => {
                if (response.status == 200) {
                    this.wallet.balance == response.data;
                }
            }).catch((error) => {
                console.log("Cannot get wallet balance.");
            })
        }
    },
    computed: {
        calculateWalletBalance(){
            let newBalance = this.wallet.balance / 100;
            return newBalance;
        }
    },
    created() {
        if (this.$store.state.token != ''){
            WalletService.getWalletBalance().then((response)=> {
                if (response.status == 200) {
                    this.wallet.balance = response.data;
                }
            }).catch ((error) => {
                console.log("Could not get wallet balance.");
            })
        }
    }
}
</script>

<style>

</style>