<template>
  <div class="search-container">
    <form id="search-form">
      <div class="form-element">
        <p class="title-search">Movie Title:</p>
        <input
          class="title-search"
          type="text"
          v-model="filters.original_title"
          placeholder="Search movie titles"
        />
      </div>
      <div class="form-element">
        <p class="genre-search">Movie Genre:</p>
        <input
          class="genre-search"
          type="text"
          v-model="filters.genre"
          placeholder="Search movie genres"
        />
      </div>
      <div class="form-element">
        <p class="min-date-search">
          Minimum Release Date: {{ filters.min_release_date }}
        </p>
        <input
          class="min-date-search"
          type="date"
          v-model="filters.min_release_date"
        />
      </div>
      <div class="form-element">
        <p class="max-date-search">
          Max Release Date: {{ filters.max_release_date }}
        </p>
        <input
          class="max-date=search"
          type="date"
          v-model="filters.max_release_date"
        />
      </div>
    </form>
    <button input="submit" type="submit" v-on:click.prevent="filterMovies()">Submit</button>
  </div>
</template>

<script>
import MovieService from "../services/MovieService";

export default {
  name: "search",
  data() {
    return {
      filteredMovies: [],
      filters: 
        { original_title: "" },
    };
  },

  methods: {
    filterMovies() {
      MovieService.getMoviesWithFilters(this.filters).then(response => {
        this.$store.commit("SET_MOVIES", response.data)
      })
    },
  }
};
</script>

<style scoped>
div.search-container {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  background-color: blanchedalmond;
  width: 30%;
  justify-content: space-between;

}

h1.title-search {
  font-size: smaller;
  color: red;
}
h1.genre-search {
  font-size: smaller;
  color: red;
}
h1.min-date-search {
  font-size: smaller;
  color: red;
}
h1.max-date-search {
  font-size: smaller;
  color: red;
}
</style>