<template>
  <div id="login-page">
    <div class="name" id="name">
        <h1>ReelDB</h1>
      </div>
    <div id="site-info" class="site-info">
      <div class="information" id="information">
        <p id="description" class="description">
          This project was created by Joseph Schilens, Alain Delgado, Nick Harter and Sean Kunkemoeller as our final project for Tech Elevator.
          Check out the latest movies from our database, favorite and select movies to watch later. Credit to The
          Movie Database for providing our movies and details.
        </p>
      </div>
    </div>

    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login" id="flex">
        <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <!-- username between label>< -->
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <br />
        <!-- Password between label><label/ -->
        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <br />
        <button class="sign-in-button" type="submit">Sign in</button>
        <br />
        <router-link :to="{ name: 'register' }" class="need-account"
          >Need an account?</router-link
        >
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Bungee+Spice&display=swap');

* {

  font-weight: 540;
  margin: 0;
  padding: 0;

}

#login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 96vh;
  
}

#flex {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.name {
  font-family: 'Bungee Spice';
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: -100px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  border: 2px solid white;
  
}

.information {
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  border: 2px solid white;
  

}


#login {
  /* box */
  color: black;
  display: flex;
  justify-content: center;
}

.form-signin {
  /* box that has everything in it */
  width: 450px;
  border-radius: 15px;
  background: #fff;
  padding: 20px;
  margin: 0 auto;
  
  
}

.h3 {
  /* title that has "Please sign in" */
  text-align: center;
  font-size: 35px;
  padding: 20px 20px 0;
  margin: 0;
}

.form-control {
  /* forms to fill out username and password */
  padding: 15px 15px 2px;
  margin: 15px 15px 0;
  border-radius: 3px;
  font-size: 20px;
  background-color: #e0e0e0;
  border: black;
  text-align: center;
  padding-bottom: 20px;
}

input {
  border: 0;
  color: black;
  font: inherit;
  margin: 0;
  outline: 0;
  padding: 0;
}

.form-control[type="text"]:focus {
  outline: none;
  box-shadow: 0 0 0 2px #484848;
}

.form-control[type="password"]:focus {
  outline: none;
  box-shadow: 0 0 0 2px #484848;
}

.sign-in-button {
  display: flex;
  justify-content: center;
  align-content: center;
  padding: 15px 15px 2px;
  margin: 15px 15px 0;
  border-radius: 3px;
  font-size: 20px;
  background-color: #484848;
  color: white;
  padding-bottom: 20px;
}

.need-account {
  font-size: 20px;
  text-align: center;
  color: black;
}
</style>
