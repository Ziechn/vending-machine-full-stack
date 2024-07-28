<template>
  <div class="purchase">
    <button v-on:click="purchaseItem">Purchase Item</button>
  </div>
</template>

<script>
import PurchaseService from '../services/PurchaseService';

export default {
    data() {
        return {
            purchase: {
                'vendingItemId' : -1,
                'userId' : 0,
                'walletBalance' : 0,
                'purchasePrice' : 0,
                'date' : ''
            }
        }
    },
    methods: {
        purchaseItem() {
            this.purchase.vendingItemId = this.$store.state.currentItem.id;
            this.purchase.userId = this.$store.state.user.id;
            this.purchase.walletBalance = this.$store.state.wallet.balance;
            this.purchase.purchasePrice = this.$store.state.currentItem.price;

            // Get and formate the current date.
            const date = new Date();

            let day = date.getDate();
            let month = date.getMonth() + 1;

            if (month < 10){
                month = "0" + month;
            }

            let year = date.getFullYear();

            // This arrangement can be altered based on how we want the date's format to appear.
            let currentDate = `${year}-${month}-${day}`;
            // console.log(currentDate); // "17-6-2022"

            this.purchase.date = currentDate;

            PurchaseService.purchaseItem(this.purchase).then((response) => {
                if (response.status == 200){
                    if (this.$store.state.token != ''){
                        this.$store.commit("SET_WALLET_BALANCE", response.data.newWalletBalance);
                    } else {
                        this.$store.commit("SET_WALLET_BALANCE", this.$store.state.wallet.balance - this.$store.state.currentItem.price);
                    }
                    
                    this.$store.commit("SET_CURRENT_ITEM_INVENTORY", response.data.newInventory);
                    window.alert("Purhcase Successful.");
                }
            }).catch((error) => {
                window.alert("Purhcase unsuccessful: " + error.response.data.message);
            })
        }
    }
}
</script>

<style scoped>
button {
    height: 50px;
    width: 100%;
    margin: 0px;
}
.purchase{
    margin-top: 20px;
    margin-left: 20px;
}
</style>