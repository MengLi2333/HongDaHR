<template>
  <div id="login">
    <div style="text-align: center; margin-top: 50px">
      <login-comp></login-comp>
    </div>
  </div>
</template>

<script>
  import LoginComp from '../components/LoginComp.vue'

  export default {
    name: "Login",
    data() {
      return {

      }
    },
    components: {
      LoginComp
    }
  }
</script>

<style scoped>

</style>
