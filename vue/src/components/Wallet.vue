<template>
    <div class="wallet-window">
        Wallet: &dollar;{{ calculateWalletBalance }}
    </div>
    <div class="add-money">
        Add $:<button v-on:click="addOneDollarToWallet">$1</button>
        <button v-on:click="addFiveDollarsToWallet">$5</button>
        <button v-on:click="addTenDollarsToWallet">$10</button>
    </div>
    
</template>

<script>
import WalletService from '../services/WalletService'

export default {
    methods: {
        addOneDollarToWallet() {
            let newBalance = this.$store.state.wallet.balance + 100;
            if (this.$store.state.token != ''){
                this.updateWalletBalance(newBalance);
            } else {
                this.$store.commit("SET_WALLET_BALANCE", newBalance);
            }
        },
        addFiveDollarsToWallet(){
            let newBalance = this.$store.state.wallet.balance + 500;
            if (this.$store.state.token != ''){
                this.updateWalletBalance(newBalance);
            } else {
                this.$store.commit("SET_WALLET_BALANCE", newBalance);
            }
        },
        addTenDollarsToWallet(){
            let newBalance = this.$store.state.wallet.balance + 1000;
            if (this.$store.state.token != ''){
                this.updateWalletBalance(newBalance);
            } else {
                this.$store.commit("SET_WALLET_BALANCE", newBalance);
            }
        },
        updateWalletBalance(newBalance){
            this.$store.commit("SET_WALLET_BALANCE", newBalance)
            WalletService.updateWalletBalance(this.$store.state.wallet).then((response) => {
                if (response.status == 200){
                    console.log("Wallet updated!");
                    this.getNewWalletBalance();
                }
            }).catch((error) => {
                console.log("Wallet was not updated.");
            })
        },
        getNewWalletBalance(){
            WalletService.getWalletBalance().then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_WALLET_BALANCE", response.data);
                }
            }).catch((error) => {
                console.log("Cannot get wallet balance.");
            })
        }
    },
    computed: {
        calculateWalletBalance(){
            let newBalance = this.$store.state.wallet.balance / 100;
            return newBalance;
        }
    },
    created() {
        this.$store.commit("SET_WALLET_BALANCE", 0);
        if (this.$store.state.token != ''){
            WalletService.getWalletBalance().then((response)=> {
                if (response.status == 200) {
                    this.$store.commit("SET_WALLET_BALANCE", response.data);
                }
            }).catch ((error) => {
                console.log("Could not get wallet balance.");
            })
        }
    }
}
</script>

<style scoped>
div {
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 0.8em;
}
button {
    height: 35px;
    width: 35px;
    margin-left: 10px;
}
.wallet-window {
    font-size: 0.8em;
    font-weight: bold;
    background-color:black;
    width: 180px;
    height: 40px;
    margin-top: 10px;
    margin-left: 10px;
    padding-top: 20px;
    padding-left: 20px;
    color: red;
    border-radius: 7px;
    border-style: solid;
    border-color: gray;
}
.add-money {
    text-align: center;
    width: 180px;
    margin-top: 20px;
    margin-left: 15px;
    margin-bottom: 20px;
}
</style>