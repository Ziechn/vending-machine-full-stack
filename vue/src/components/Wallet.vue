<template>
  Wallet: {{ wallet }}
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
            this.wallet++;
            console.log(this.wallet);
        },
        addFiveDollarsToWallet(){
            this.wallet += 5;
            console.log(this.wallet);
        },
        addTenDollarsToWallet(){
            this.wallet += 10;
            console.log(this.wallet);
        }
    }
}
</script>

<style>

</style>