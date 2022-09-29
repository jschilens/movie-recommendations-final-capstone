<template>
  <div class="home">
    <div id="flex"> 
    <h1 class="header">Hello {{$store.state.user.username}}!</h1>
  
    </div>
  </div>
</template>



<script>
export default {
  name: "home",
};
</script>

<style scoped>

* {
  font-family: 'Courier New', Courier, monospace;
  margin: 0;
  padding: 0;
}


#flex {
  display: flex;
  flex-direction: column;
  align-content: stretch;
  height: 96vh;
}

.header{
  color: black;
  text-align: center;
  margin: 1% ;
}
</style>