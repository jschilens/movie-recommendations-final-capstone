<template>
  <movie-list />
</template>

<script>
import MovieList from '@/components/MovieList';
  export default { 
    name: "browse-movies",
    components: { 
        MovieList
    }
  }
</script>

<style >
 #app {
    height: 100% !important;
}
</style>