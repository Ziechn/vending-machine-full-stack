<template>
    <div class="flex-seal-liquid">
        <div class="vending_machine">
            <div class="shelf">
                <!-- List of items -->
                 <VendingItem v-for="item in vendingItems" v-bind:key="item.id" v-bind:id="item.id"/>
            </div>
            <div>
                <!-- Wallet -->
                 <Wallet/>
                 <SelectedItem/>
                 <Purchase/>
            </div>
        </div>
    </div>
</template>

<script>
import VendingItem from './VendingItem.vue';
import VendingMachineService from '../services/VendingMachineService';
import Wallet from './Wallet.vue';
import SelectedItem from './SelectedItem.vue';
import Purchase from './Purchase.vue';

export default {
    components: {
        VendingItem,
        Wallet,
        SelectedItem,
        Purchase
    },
    data() {
        return {
            vendingItems: []
        }
    },
    created() {
        VendingMachineService.getAllVendingItems().then((response) => {
            if (response.status == 200){
                this.vendingItems = response.data;
            }
        }).catch((error) => {
            console.log(error);
        })
    }
}
</script>

<style scoped>
.flex-seal-liquid{
    width: 100vw;
    height: 95vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
.vending_machine {
    display: flex;

    height: 600px;
    padding: 20px;

    background-color: #99b3c6;
    border-style: solid;
    border-color: #516a7b;
    border-radius: 5px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}
.shelf {
    width: 600px;
    height: 90%;
    padding: 20px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    background-color: whitesmoke;
    border-style: solid;
    border-color: #516a7b;
    border-radius: 5px;
}
</style>