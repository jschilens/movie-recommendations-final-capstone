<template>
      <div class="navbar">
        <div class="container nav-container">
            <input class="checkbox" type="checkbox" />
            <div class="hamburger">
              <span class="line" id="line-one"></span>
              <span class="line" id="line-two"></span>
              <span class="line line3" id="line-three"></span>
            </div>  
          <div class="logo">
          </div>
          <div class="menu-list">
            <li><router-link id="list" v-bind:to="{ name: 'home' }" >Home</router-link></li>
            <li><router-link id="list" v-bind:to="{ name: 'movies' }" >Browse</router-link></li>
            <li><router-link id="list" v-bind:to="{ name: 'my-movies' }" >My Movies</router-link></li>
            <li> <router-link id="list" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link></li>
          </div>
        </div>
      </div>
</template>

<script>

export default {
    // name: 'sidemenu__item',
    
    
};


</script>

<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
 
}

.container {
  /* this messes with the width of the menu */
  max-width: 15%;
  min-width: 10%;
  width: 50%;
}


.navbar {
  width: 100% !important;
  
  /* border: 3px solid red; */
}

.nav-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 64px;
  /* padding: 100px; */
  /* border: 3px solid hotpink; */
}

.menu-list {
  display: flex;
  background: #1B1B1B;
  font-family: 'Allerta Stencil';
  /* position: -webkit-sticky;  */
  position: fixed;
  top: 0;
  /* border: 3px solid hotpink; */
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
  
  /* border: 3px solid hotpink; */
}

/* makes the font bold when hovered over */
.navbar .nav-container #list:hover{
    font-weight: bolder;
    /* border: 3px solid hotpink; */
}

.nav-container {
  display: block;
  position: relative;
  height: 60px;
  /* border: 3px solid hotpink; */
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
  /* border: 3px solid green; */
}

.nav-container .hamburger{
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
  /* position: fixed; */
  padding-top: 120px;
  height: 101vh;
  transform: translate(-150%);
  display: flex;
  flex-direction: column;
  /* how far the box goes to the left (closes out) */
  margin-left: -40px;
  padding-left: 50px;
  transition: transform 0.5s ease-in-out;
  text-align: center;
  /* padding-right:400px; */
}

.menu-list li {
  margin-bottom: 1.2rem;
  font-size: 1.5rem;
}


/* these deals with the hamburger lines turning into X */

/* makes the menu pop in */
.nav-container input[type="checkbox"]:checked ~ .menu-list {
  transform: translateX(0);
}

/* these 3 turns the bars to an X  */
.nav-container input[type="checkbox"]:checked ~ .hamburger #line-one {
  transform: rotate(45deg);
}

.nav-container input[type="checkbox"]:checked ~ .hamburger #line-two {
  transform: scaleY(0);
}

.nav-container input[type="checkbox"]:checked ~ .hamburger #line-three {
  transform: rotate(-45deg);
}
.watch-filled{
  color: aqua;
}


</style>