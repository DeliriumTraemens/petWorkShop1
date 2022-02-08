<template>
  <v-app app id="app">
    <MyScreen/>
  </v-app>
</template>

<script>
import MyScreen from "./components/MyScreen/MyScreen.vue";

export default {
  name: 'App',
  components: {
    MyScreen,

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
