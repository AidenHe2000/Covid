<template>
  <v-app id="app" data-app>
    <div id="nav">
      <router-link to="/medicine">Medicine</router-link> |
      <router-link to="/test">Test</router-link> |
      <router-link to="/doctor">Doctor</router-link> |
      <router-link to="/patient">Patient</router-link> |
      <router-link to="/debug">debug</router-link> |
      <router-link to="/diagnosis">diagnosis</router-link> |
      <router-link to="/allPatients">AllPatients</router-link> |
    </div>
    <router-view/>
  </v-app>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
