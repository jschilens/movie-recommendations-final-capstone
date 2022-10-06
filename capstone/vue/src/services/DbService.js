import axios from 'axios';

export default {
    favorite(id) {
        return axios.put(`/movies/favorited/${id}`)
    },

    unFavorite(id) {
        return axios.delete(`/movies/unfavorited/${id}`)
    },

    save(id) {
        return axios.put(`/movies/saved/${id}`)
    },

    unsave(id) {
        return axios.delete(`/movies/unsaved/${id}`)
    },

    getFavoritedMovies() {
        return axios.get(`/favorited`)
    },

    getSavedMovies() {
        return axios.get(`/saved`)
    },




}