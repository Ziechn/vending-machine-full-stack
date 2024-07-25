<template>
  Wallet: {{ getWalletBalance }}
  <button v-on:click="addOneDollarToWallet">Add $1</button>
  <button v-on:click="addFiveDollarsToWallet">Add $5</button>
  <button v-on:click="addTenDollarsToWallet">Add $10</button>
</template>

<script>
export default {
    data() {
        return {
            wallet: 0
        }
    },
    methods: {
        addOneDollarToWallet() {
            this.wallet += 100;
        },
        addFiveDollarsToWallet(){
            this.wallet += 500;
        },
        addTenDollarsToWallet(){
            this.wallet += 1000;
            
        }
    },
    computed: {
        getWalletBalance(){
            let newBalance = this.wallet / 100;
            console.log(newBalance);
            return newBalance;
        }
    }
}
</script>

<style>

</style>