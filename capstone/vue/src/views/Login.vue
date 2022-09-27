<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <br>
      <!-- Password between label><label/ -->
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /> <br>
      <button class="sign-in-button" type="submit">Sign in</button>
      <br />
      <router-link :to="{ name: 'register' }" class="need-account">Need an account?</router-link>      
    </form>
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
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
}

#login {
  /* box */
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  /* font-family: 'Times New Roman', Times, serif; */
  color:black;
  background: #fcde67 ;
  
}

.form-signin{
  /* box that has everything in it */
  display: flex;  
  flex-direction: column;
  width:450px;
  border-radius: 15px;
  background: #fff;
  padding: 20px;
}

.h3{
  /* title that has "Please sign in" */
  text-align: center;
  font-size: 35px;
  padding: 20px 20px 0;
  margin: 0;
}

.form-control{
  /* forms to fill out username and password */
  
  padding: 23px 23px 2px;
  margin: 20px 20px 0;	
	border-radius: 3px;
  font-size: 20px;
  background-color: #E0E0E0;
  border: black;
}

input {
  border: 0;
  color: black;
  font: inherit;
  margin: 0;
  outline: 0;
  padding: 0;
}

.form-control[type=text]:focus{
  outline: none;     
  box-shadow: 0 0 0 2px #484848; 
}

.form-control[type=password]:focus{
  outline: none;     
  box-shadow: 0 0 0 2px #484848; 
}

.sign-in-button{
  display: flex;
  justify-content: center;
  align-content: center;
  padding: 23px 23px 0;
  margin: 20px 20px 0;	
	border-radius: 3px;
  font-size: 20px;
  background-color: #484848;
  color: white;
}

.need-account{
  font-size: 20px;
  text-align: center;
  color:black;
}
</style>
