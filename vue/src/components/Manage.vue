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
    background-color: #c0daee;
    width: 600px;
    height: 90%;
    padding: 20px;
    display: flex;
    flex-wrap: wrap;
}
.all-orders {
    font-size: 0.75em;
    background-color: whitesmoke;
    border-style: solid;
    border-color: #2f4858;
    border-radius: 5px;
    width: 400px;
    overflow: scroll;
    padding-left: 10px;
    color: #2f4858;
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
    color: #ee005f;
    border-radius: 7px;
    border-style: solid;
    border-color: #2f4858;
}
</style>