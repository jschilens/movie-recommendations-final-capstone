<template>
  <div id="sidemenu">
      <button class="sidemenu-button" v-on:click="showNav = !showNav" v-bind:class="{active:showNav}">
      <span class="top">1</span>
      <span class="mid">2</span>
      <span class="bottom">3</span>
      </button>
      <transition>
      <nav v-show="showNav">
        <div class="sidemenu__wrapper">
          <ul class="sidemenu__list">
            <li class="sidemenu__item"><a href="">test</a></li>
            <li class="sidemenu__item"><a href="">test</a></li>
            <li class="sidemenu__item"><a href="">test</a></li>
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



</style>