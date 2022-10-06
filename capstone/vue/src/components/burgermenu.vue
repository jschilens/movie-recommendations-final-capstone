<template>
  <div class="navbar">
    <div class="container nav-container" v-if="$store.state.token != ''">
      <input class="checkbox" type="checkbox" />
      <div class="hamburger">
        <span class="line" id="line-one"></span>
        <span class="line" id="line-two"></span>
        <span class="line line3" id="line-three"></span>
      </div>
      <div class="logo"></div>
      <div class="menu-list">
        <li>
          <router-link id="list" v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
        <li>
          <router-link id="list" v-bind:to="{ name: 'movies' }"
            >Browse</router-link
          >
        </li>
        <li>
          <router-link id="list" v-bind:to="{ name: 'my-movies' }"
            >My Movies</router-link
          >
        </li>
        <li>
          <router-link
            id="list"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </li>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.container {
  max-width: 15%;
  min-width: 10%;
  width: 50%;
}

.navbar {
  width: 100% !important;
}

.nav-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 64px;
}

.menu-list {
  display: flex;
  background: #1b1b1b;
  font-family: "Allerta Stencil";
  position: fixed;
  top: 0;
  width: 250px;
}

.navbar .nav-container li {
  list-style: none;
}

.navbar .nav-container #list {
  text-decoration: none;
  color: white;
  font-weight: 500;
  font-size: 1.2rem;
  padding: 0.7rem;
}

.navbar .nav-container #list:hover {
  font-weight: bolder;
}

.nav-container {
  display: block;
  position: relative;
  height: 60px;
}

.nav-container .checkbox {
  position: fixed;
  display: block;
  height: 32px;
  width: 32px;
  top: 20px;
  left: 20px;
  z-index: 3;
  opacity: 0;
  cursor: pointer;
  padding: 100px;
}

.nav-container .hamburger {
  display: block;
  height: 26px;
  width: 32px;
  position: absolute;
  top: 17px;
  left: 20px;
  z-index: 2;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.nav-container .hamburger .line {
  display: block;
  height: 4px;
  width: 100%;
  border-radius: 10px;
  background: white;
}

#line-one {
  transform-origin: 0% 0%;
  transition: transform 0.4s ease-in-out;
}

#line-two {
  transition: transform 0.2s ease-in-out;
}

#line-three {
  transform-origin: 0% 100%;
  transition: transform 0.4s ease-in-out;
}

.menu-list {
  padding-top: 120px;
  height: 101vh;
  transform: translate(-150%);
  display: flex;
  flex-direction: column;
  margin-left: -40px;
  padding-left: 50px;
  transition: transform 0.5s ease-in-out;
  text-align: center;
}

.menu-list li {
  margin-bottom: 1.2rem;
  font-size: 1.5rem;
}
.nav-container input[type="checkbox"]:checked ~ .menu-list {
  transform: translateX(0);
}

.nav-container input[type="checkbox"]:checked ~ .hamburger #line-one {
  transform: rotate(45deg);
}

.nav-container input[type="checkbox"]:checked ~ .hamburger #line-two {
  transform: scaleY(0);
}

.nav-container input[type="checkbox"]:checked ~ .hamburger #line-three {
  transform: rotate(-45deg);
}
.watch-filled {
  color: aqua;
}
</style>