import axios from 'axios';

export default {
    favorite(id) {
        return axios.post(`/movies/favorited/${id}`)
    },

    getFavoritedMovies(id) {
        return axios.get(`/movies/favorites/${id}`)
    },

    unFavorite(id) {
        return axios.delete(`/movies/unfavorited/${id}`)
    },
    save(id) {
        return axios.post(`/movies/saved/${id}`)
    },
    unsave(id) {
        return axios.delete(`/movies/unsaved/${id}`)
    },
}