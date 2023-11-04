<template>
  <main_header/>
  <HoMe/>
  <FooTer/>
 
</template>

<script>
import main_header from "./components/header.vue"
import HoMe from "./components/Home.vue"
import FooTer from "./components/footer.vue"
export default {
  name: 'App',
  components: {
    main_header,
    HoMe,
    FooTer,
    
    
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin:0;
}
</style>
