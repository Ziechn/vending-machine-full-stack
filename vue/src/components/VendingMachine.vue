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
            </div>
        </div>
    </div>
</template>

<script>
import VendingItem from './VendingItem.vue';
import VendingMachineService from '../services/VendingMachineService';
import Wallet from './Wallet.vue';

export default {
    components: {
        VendingItem,
        Wallet
    },
    data() {
        return {
            vendingItems: []
        }
    },
    created() {
        VendingMachineService.getAllVendingItems().then((response) => {
            if (response.status == 200){
                console.log(response.data);
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
    display: flex;
    justify-content: center;
    align-items: center;
}
.vending_machine {
    display: flex;
    width: 800px;
    height: 600px;
    background-color: darkgray;
    padding: 20px;
}
.shelf {
    background-color: whitesmoke;
    width: 600px;
    height: 90%;
    padding: 20px;
    display: flex;
    flex-wrap: wrap;
}
</style>