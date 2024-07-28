<template>
  <div class="flex-seal-liquid">
    <div class="vending_machine">
        <div class="all-orders">
            <h3>All Transactions</h3>
            <div v-for="order in orders" v-bind:key="order.id">Order ID: {{ order.id }} | User ID: {{ order.userId }} | Date: {{ order.date }} | Total: ${{ orderTotal(order.total) }}</div>
        </div>
    </div>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
import OrderService from '../services/OrderService';

export default {
    data() {
        return {
            orders : []
        }
    },
    created() {
        OrderService.getAllOrders().then((response) => {
            if (response.status == 200){
                this.orders = response.data;
            }
        }).catch((error) => {
            console.log("Error getting all orders.")
        })
    },
    methods: {
        orderTotal(total){
            return total / 100;
        }
    }
}
</script>

<style>
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
.all-orders {
    background-color: white;
    border-style: solid;
    border-color: black;
    width: 400px;
    overflow: scroll;
    padding-left: 10px;
}
</style>