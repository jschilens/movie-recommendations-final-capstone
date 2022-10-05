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
        <drop-down-menu menu-title="">
          <section class="option">
            <input type="checkbox" id="action" class="action" value="28" v-model="filters.genre_ids" />
            <label for="action"> Action </label>
          </section>
          <section class="option">
            <input type="checkbox" id="adventure" class="adventure" value="12" v-model="filters.genre_ids" />
            <label for="adventure"> Adventure </label>
          </section>
          <section class="option">
            <input type="checkbox" id="animation" class="animation" value="16" v-model="filters.genre_ids" />
            <label for="animation"> Animation </label>
          </section>
          <section class="option">
            <input type="checkbox" id="comedy" class="comedy" value="35" v-model="filters.genre_ids" />
            <label for="comedy"> Comedy </label>
          </section>
          <section class="option">
            <input type="checkbox" id="family" class="family" value="10751" v-model="filters.genre_ids" />
            <label for="family"> Family </label>
          </section>
          <section class="option">
            <input type="checkbox" id="fantasy" class="fantasy" value="14" v-model="filters.genre_ids" />
            <label for="fantasy"> Fantasy </label>
          </section>
          <section class="option">
            <input type="checkbox" id="horror" class="horror" value="27" v-model="filters.genre_ids" />
            <label for="horror"> Horror </label>
          </section>
          <section class="option">
            <input type="checkbox" id="mystery" class="mystery" value="9648" v-model="filters.genre_ids" />
            <label for="mystery"> Mystery </label>
          </section>
          <section class="option">
            <input type="checkbox" id="romance" class="romance" value="10749" v-model="filters.genre_ids" />
            <label for="romance"> Romance </label>
          </section>
          <section class="option">
            <input type="checkbox" id="science-fiction" class="science-fiction" value="878" v-model="filters.genre_ids" />
            <label for="science-fiction"> Science Fiction </label>
          </section>
          <section class="option">
            <input type="checkbox" id="thriller" class="thriller" value="53" v-model="filters.genre_ids" />
            <label for="thriller"> Thriller </label>
          </section>
        </drop-down-menu>
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
          class="max-date-search"
          type="date"
          v-model="filters.max_release_date"
        />
      </div>
    </form>
    <button input="submit" type="submit" v-on:click.prevent="filterMovies()">
      Submit
    </button>
  </div>
</template>

<script>
import MovieService from "../services/MovieService";
import DropDownMenu from "../components/DropDownMenu.vue";

export default {
  name: "search",
  components: {
    DropDownMenu,
  },
  data() {
    return {
      
      filters: {
        original_title: "",
        genre_ids: [],
        min_release_date: "",
        max_release_date: ""
      },
      // genres: [
      // {
      //   genre_id: 12,
      //   genre_name: "Adventure"
      // },
      // {
      //   genre_id: 14,
      //   genre_name: "Fantasy"
      // },
      // {
      //   genre_id: 16,
      //   genre_name: "Animation"
      // },
      // {
      //   genre_id: 27,
      //   genre_name: "Horror"
      // },
      // {
      //   genre_id: 28,
      //   genre_name: "Action"
      // },
      // {
      //   genre_id: 35,
      //   genre_name: "Comedy"
      // },
      // {
      //   genre_id: 53,
      //   genre_name: "Thriller"
      // },
      // {
      //   genre_id: 878,
      //   genre_name: "Science Fiction"
      // },
      // {
      //   genre_id: 9648,
      //   genre_name: "Mystery"
      // },
      // {
      //   genre_id: 10749,
      //   genre_name: "Romance"
      // },
      // {
      //   genre_id: 10751,
      //   genre_name: "Family"
      // } ]
    };
  },

  methods: {
    filterMovies() {
      MovieService.getMoviesWithFilters(this.filters).then((response) => {
        this.$store.commit("SET_MOVIES", response.data);
      });
    },
    selectGenre(event) {
      if (event.target.id) {
        this.genre_ids.push(parseInt(event.target.id));
      } else {
        this.genre_ids = this.genre_ids.filter((genre) => {
          return genre !== parseInt(event.target.id)
        })
      }
    },
    clearSelectedGenres() {
      this.genre_ids = [];
    },
  
  },
};
</script>

<style scoped>
div.search-container {
  width: 50% !important;
  white-space: normal;
  display: flex;
  margin-inline: auto;
  background-color: grey;
  width: 30%;
  justify-content: center;
  justify-content: space-evenly;
  border: 3px solid hotpink;
}

form#search-form {
  display: flex;
  justify-content: space-between;
}

p.title-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
p.genre-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
p.min-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
p.max-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
input.title-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
input.genre-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
input.min-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
input.max-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 3px solid hotpink;
}
</style>