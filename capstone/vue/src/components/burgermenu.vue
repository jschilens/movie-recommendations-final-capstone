<template>
  <div id="sidemenu">
      <button class="sidemenu-button" v-on:click="showNav = !showNav" >
      <div class="first-line"></div>
      <div class="sec-line"></div>
      <div class="third-line"></div>
      </button>
      <transition>
      <nav v-show="showNav">
        <div class="sidemenu-box">
          <ul class="sidemenu-list">
            <router-link id="list" v-bind:to="{ name: 'home' }" >Home</router-link>
            <router-link id="list" v-bind:to="{ name: 'movies' }" >Browse</router-link>
            <router-link id="list" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
          </ul>
        </div>
      </nav>
    </transition>


  </div>
</template>

<script>

export default {
    name: 'sidemenu__item',
    data() {
        return {
            showNav: false,
        }
    }
}
</script>

<style>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}


nav{
    /* box */
    width: 300px;
    height: 100px;
    background: white;
}

.sidemenu-button {
    background-color: #484848;
    border: 0;
}

button div {
    /* button display */
    width: 35px;
    height: 5px;
    background-color: white;
    margin: 6px 0;
}

#list{
    display: flex;
    flex-direction: column;
}

#list{
    text-decoration: none;
    text-align: center;
    font-size: 25px;
    
}

</style>