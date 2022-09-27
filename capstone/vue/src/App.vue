<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" class="home">Home </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style>
*{
  margin: 0;
  padding: 0;
}

#nav {
  background: #484848;
  font-size: 25px;
  text-align: center;
  height: 35px
}

.home{
  color: white;
}

</style>