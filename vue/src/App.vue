<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <span v-if="$store.state.user.title == 'vendor'">&nbsp;|&nbsp; <router-link v-bind:to="{ name: 'manage' }">Manage Machine</router-link></span>
    </div>
    <router-view />
  </div>
</template>

<style>
body {
  background-color: #516a7b;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  color: #2f4858;
}
a {
  color: #fff7d6;
}
a:visited {
  color: #00c6af;
}
</style>