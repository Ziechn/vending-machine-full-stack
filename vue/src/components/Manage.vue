<template>
  <div class="flex-seal-liquid">
    <div class="vending_machine">
        <div class="all-orders">
            <h3>All Transactions</h3>
            <div v-for="order in orders" v-bind:key="order.id">Order ID: {{ order.id }} | User ID: {{ order.userId }} | Date: {{ order.date }} | Total: ${{ orderTotal(order.total) }}</div>
        </div>
        <div class="bank">
            <Bank/>
        </div>
    </div>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
import OrderService from '../services/OrderService';
import Bank from '../components/Bank.vue';

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
    },
    components: {
        Bank
    }
}
</script>

<style scoped>
div {
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}
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
    font-size: 0.75em;
    background-color: white;
    border-style: solid;
    border-color: black;
    border-radius: 5px;
    width: 400px;
    overflow: scroll;
    padding-left: 10px;
}
.bank {
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
</style>