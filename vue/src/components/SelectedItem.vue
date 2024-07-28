<template>
  <div class="selection-window">
    <div v-if="this.$store.state.currentItem.name != null">
      Name: {{ this.$store.state.currentItem.name }}<br>
      Type: {{ this.$store.state.currentItem.type }} <br>
      Price: &dollar;{{ itemPrice }} <br>
      In Stock: {{ this.$store.state.currentItem.inventory }}
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    itemPrice(){
      return this.$store.state.currentItem.price / 100;
    }
  }
}
</script>

<style>
.selection-window {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  font-size: 0.8em;
  background-color:black;
  width: 180px;
  height: 100px;
  margin-top: 20px;
  margin-left: 20px;
  padding-top: 20px;
  padding-left: 20px;
  color: #ee005f;
  border-radius: 7px;
  border-style: solid;
  border-color: #516a7b;
}
</style>