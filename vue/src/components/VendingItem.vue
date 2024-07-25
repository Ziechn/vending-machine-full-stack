<template>
  <div class="vending-item">
    <h2>{{ item.name }}</h2>
    <h3>{{ item.type }}</h3>
    <h2>{{ item.price }}</h2>
    <p>{{ item.inventory }}</p>
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
                console.log(response.data);
                this.item = response.data;
            }
        }).catch((error) => {
            console.log(error)
        })
    }
}
</script>

<style scoped>
.vending-item{
    width: 170px;
    height: 170px;
    background-color: darkgrey;
    color: whitesmoke;
    border-style: solid;
    border-color: black;
    border-radius: 5px;
    border-width: 1px;
    margin: 10px;
    padding: 10px;
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