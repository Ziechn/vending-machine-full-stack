<template>
  <div class="vending-item" v-on:click="setCurrentItem">
    <h3>{{ item.name }}</h3>
  </div>
</template>

<script>
import VendingMachineService from '../services/VendingMachineService';

export default {
    props: {id: {type : Number}},
    data() {
        return {
            item: {}
        }
    },
    created() {
        VendingMachineService.getVendingItemById(this.id).then((response) => {
            if (response.status == 200){
                this.item = response.data;
            }
        }).catch((error) => {
            console.log(error)
        })
    },
    methods: {
        setCurrentItem(){
            this.$store.commit("SET_CURRENT_ITEM", this.item);
        }
    }
}
</script>

<style scoped>
.vending-item{
    width: 100px;
    height: 100px;
    background-color: #cd0047;
    color: #ffffff;
    border-style: solid;
    border-color: #cd0047;
    border-radius: 5px;
    margin: 5px;
    padding: 10px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 0.8em;
}
.vending-item:hover {
    background-color: #ff87b3;
    border-style: solid;
    border-color: #cd0047;
}
.vending-item:active {
    background-color: #ff87b3;
    border-style: solid;
    border-color: #ff87b3;
}
h3 {
    margin: 2px;
}
h2 {
    margin: 2px;
}
p {
    margin: 2px;
}
</style>