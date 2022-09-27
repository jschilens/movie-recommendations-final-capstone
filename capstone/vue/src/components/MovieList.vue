<template>
    <div>
        <movie-card />
    </div>
</template>


<script>
import MovieCard from '@/components/MovieCard'
 export default {
     name: 'movie-list',
     components: {
         MovieCard,
     }
 }
</script>