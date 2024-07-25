<template>
  <div class="vending-item">
    <h3>{{ item.type }}</h3>
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
    }
}
</script>

<style scoped>
.vending-item{
    width: 100px;
    height: 100px;
    background-color: darkgrey;
    color: whitesmoke;
    border-style: solid;
    border-color: black;
    border-radius: 5px;
    border-width: 1px;
    margin: 5px;
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