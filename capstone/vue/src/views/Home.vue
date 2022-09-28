<template>
  <div class="home">
    <div id="flex"> 
    
    <h1 class="header">Hello 'USERNAME'</h1>
    
    <div class="information">
      <h4> Watch Later </h4>
      <h4> Favorited movies </h4>
    </div>
    
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
  margin: 0;
  padding: 0;
}

#flex {
  display: flex;
  flex-direction: column;
  align-content: stretch;
}

.header{
  color: black;
  text-align: center;
  margin: 1% ;
}

.information {
  text-align: center;
  font-size: 30px;
  color: black;
}

</style>