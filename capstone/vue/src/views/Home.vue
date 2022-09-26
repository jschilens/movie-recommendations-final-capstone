<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
#home {
  background: #667eea;
  background: -webkit-linear-gradient(to right, rgba(102, 126, 234, 0.5), rgba(118, 75, 162, 0.5));
  background: linear-gradient(
    to right,
    rgba(102, 126, 234, 0.5),
    rgba(118, 75, 162, 0.5)
  );
}
</style>
