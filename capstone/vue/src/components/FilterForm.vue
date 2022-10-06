<template>
  <div>
    <img
      src="../assets/pngegg.png"
      v-on:click="showForm = !showForm"
      class="button-dropdown"
      
    />
    <div class="search-container" v-show="showForm === true">
      <form id="search-form">
        <div class="form-element">
          <p class="title-search">Movie Title:</p>
          <input
            class="title-search1"
            type="text"
            v-model="filters.original_title"
            placeholder="Search movie titles"
          />
        </div>
        <div class="form-element">
          <drop-down-menu menu-title="">
            <section class="option" id="action" :style="{'background-image':'url(https://media.tenor.com/K5auNNuuWy4AAAAC/action-light-camera-action.gif)'}">
              <input
                type="checkbox"
                id="action"
                class="action"
                value="28"
                v-model="filters.genre_ids"
              />
              <label id="action" for="action"> Action </label>
            </section>
            <section class="option" id="adventure" :style="{'background-image':'url(https://media.tenor.com/k-LrIqE73LAAAAAC/to-rule.gif)'}">
              <input
                type="checkbox"
                id="adventure"
                class="adventure"
                value="12"
                v-model="filters.genre_ids"
              />
              <label id="adventure" for="adventure"> Adventure </label>
            </section>
            <section class="option" id="animation" :style="{'background-image':'url(https://media.tenor.com/K0HvlMWx0L8AAAAC/toy-story-woody.gif)'}">
              <input
                type="checkbox"
                id="animation"
                class="animation"
                value="16"
                v-model="filters.genre_ids"
              />
              <label id="animation" for="animation"> Animation </label>
            </section>
            <section class="option" id="comedy" :style="{'background-image':'url(https://media.tenor.com/OwIL5ZWvMb4AAAAM/parks-and-rec-andy-dywer.gif)'}">
              <input
                type="checkbox"
                id="comedy"
                class="comedy"
                value="35"
                v-model="filters.genre_ids"
              />
              <label id="comedy" for="comedy"> Comedy </label>
            </section>
            <section class="option" id="family" :style="{'background-image':'url(https://media.tenor.com/YBFq9a-jDI0AAAAd/i-dont-have-friends-i-have-family.gif)'}">
              <input
                type="checkbox"
                id="family"
                class="family"
                value="10751"
                v-model="filters.genre_ids"
              />
              <label id="family" for="family"> Family </label>
            </section>
            <section class="option" id="fantasy" :style="{'background-image':'url(https://media.tenor.com/1afM2qT0HaUAAAAM/in-a-world-of-pure-imagination-willy-wonka-and-the-chocolate-factory.gif)'}">
              
              <input
                type="checkbox"
                id="fantasy"
                class="fantasy"
                value="14"
                v-model="filters.genre_ids"
              />
              <label id="fantasy" for="fantasy"> Fantasy </label>
            
            </section>
            <section class="option" id="horror" :style="{'background-image':'url(https://media.tenor.com/9cNJVhQsby4AAAAC/dancing-spooky.gif)'}">
              <input
                type="checkbox"
                id="horror"
                class="horror"
                value="27"
                v-model="filters.genre_ids"
              />
              <label id="horror" for="horror"> Horror </label>
            </section>
            <section class="option" id="mystery" :style="{'background-image':'url(https://media.tenor.com/_InqREP0TIkAAAAM/steve-urkel-detective.gif)'}">
              <input
                type="checkbox"
                id="mystery"
                class="mystery"
                value="9648"
                v-model="filters.genre_ids"
              />
              <label id="mystery" for="mystery"> Mystery </label>
            </section>
            <section class="option" id="romance" :style="{'background-image':'url(https://media.tenor.com/vN1dLIphWe8AAAAC/the-notebook-notebook.gif)'}">
              <input
                type="checkbox"
                id="romance"
                class="romance"
                value="10749"
                v-model="filters.genre_ids"
              />
              <label id="romance" for="romance"> Romance </label>
              
            </section>
            <section class="option" id="science-fiction" :style="{'background-image':'url(https://media.tenor.com/ang0VzOwbdAAAAAC/the-matrix-reloaded-matrix.gif)'}">
              <input
                type="checkbox"
                id="science-fiction"
                class="science-fiction"
                value="878"
                v-model="filters.genre_ids"
              />
              <label id="science-fiction" for="science-fiction"> Science Fiction </label>
              
            </section>
            <section class="option" id="thriller" :style="{'background-image':'url(https://media.tenor.com/PSYhnv2F6IcAAAAC/moonwalk-michael-jackson.gif)'}" >
              <input
                type="checkbox"
                id="thriller"
                class="thriller"
                value="53"
                v-model="filters.genre_ids"
               
              />
              <label id="thriller" for="thriller"> Thriller </label>
              
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

      <button
        input="submit"
        type="submit"
        v-on:click.prevent="filterMovies()"
        class="submit-button"
      >
        Search
      </button>
    </div>
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
      showForm: false,
      filters: {
        original_title: "",
        genre_ids: [],
        min_release_date: "",
        max_release_date: "",
      },
      
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
          return genre !== parseInt(event.target.id);
        });
      }
    },
    clearSelectedGenres() {
      this.genre_ids = [];
    },
    
  },
};
</script>

<style scoped>
.button-dropdown {
  height: 50px;
  filter: invert(100%);
  margin-left: 49%;
  /* display: flex; */
  /* background: white; */
  /* font-size: 20px; */
  /* justify-content: center; */
  /* align-content: center; */
  /* margin-inline: auto; */
  /* text-align: center; */
  /* transform: left 50%; */
}

div.search-container {
  /* width: 100%; */
  width: 65% !important;
  white-space: normal;
  display: flex;
  margin-inline: auto;
  background-color: #1b1b1b;
  width: 30%;
  justify-content: center;
  justify-content: space-evenly;
  border: 3px solid black;
  height: 50px;
  color: white;
}

form#search-form {
  display: flex;
  justify-content: space-between;
  width: 95%;
  color: white;
  border-radius: 10px;
}

p.title-search {
  font-size: smaller;
  font-weight: bold;
  color: white;
  margin-top: 3px;

  /* border: 3px solid hotpink; */
}

.title-search1 {
  font-size: smaller;
  font-weight: bold;
  border: 1px solid white;
}

input.title-search1 {
  color: white;
}

p.genre-search {
  font-size: smaller;
  font-weight: bold;

  /* border: 3px solid hotpink; */
}
p.min-date-search {
  font-size: smaller;
  font-weight: bold;
  margin-top: 3px;

  /* border: 3px solid hotpink; */
}
p.max-date-search {
  font-size: smaller;
  font-weight: bold;
  margin-top: 3px;

  /* border: 3px solid hotpink; */
}
input.title-search {
  font-size: smaller;
  font-weight: bold;
  color: white;
  /* border: 3px solid hotpink; */
}
input.genre-search {
  font-size: smaller;
  font-weight: bold;
  /* border: 3px solid hotpink; */
}
input.min-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 1px solid white;
  color: white;
  color-scheme: dark;
}
input.max-date-search {
  font-size: smaller;
  font-weight: bold;
  border: 1px solid white;
  color: white;
  color-scheme: dark;
}

.submit-button {
  margin-left: 80px;
  border: 1px solid white;
}
section#thriller.option { 
 background-size: 100% 95%;
}

section#science-fiction.option { 
 background-size: 100% 95%;
 font-weight: bolder;
}

section#romance.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}

section#family.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}

section#horror.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}

section#mystery.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}
section#fantasy.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}
section#adventure.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}
section#comedy.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}

section#action.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}

section#animation.option { 
 background-size: 100% 95%;
 font-weight: bolder;
 
}


</style>