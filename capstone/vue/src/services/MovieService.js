import axios from 'axios';

export default {

    getAllMovies() {
        return axios.get('/movies')
    },

    getMovie(id) {
        return axios.get(`/movies/${id}`)
    },

    getNowPlaying() {
        return axios.get('/movies/now-playing')
    }
    
}