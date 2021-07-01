<template>
  <v-app id="app" data-app>
    <side-navigation></side-navigation>
    <v-divider></v-divider>
    <v-content>
    <div id="nav">
      <router-link to="/medicine"></router-link>  
      <router-link to="/patient"></router-link> 
      <router-link to="/diagnosis"></router-link> 
      <router-link to="/allPatients"></router-link> 
      <router-link to="/checkin"></router-link> 
    </div>
    <router-view/>
    </v-content>
  </v-app>
</template>

<script>
  import SideNavigation from "./views/SideNavigation";
  export default {
    components:{SideNavigation}
  }
</script>


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
