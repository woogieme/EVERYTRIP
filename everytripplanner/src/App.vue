<template>
  <div id="app">
    <the-header-navi></the-header-navi>
    <!-- <router-link></router-link> -->
    <router-view />
  </div>
</template>
<script>
import TheHeaderNavi from "@/components/TheHeaderNavi.vue";
export default {
  name: "App",
  components: {
    TheHeaderNavi,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #3ad18d;
}
</style>
