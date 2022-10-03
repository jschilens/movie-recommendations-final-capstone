<template>
<div>
<filter-movies />
  <movie-list />
</div>
</template>

<script>
import MovieList from '@/components/MovieList';

import FilterMovies from '../components/FilterMovies.vue';
  export default { 
    name: "browse-movies",
    components: { 
        MovieList,
        FilterMovies
        
    }
  }
</script>

<style scoped>

</style>