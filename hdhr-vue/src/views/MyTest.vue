<template>
  <div id="myTest">
    <el-button @click="f()">aa</el-button>
  </div>
</template>

<script>
  export default {
    name: "MyTest",
    data() {
      return {

      }
    },
    methods: {
      func(a, b) {
        if (a !== undefined) {
          a()
        }
        if (b !== undefined) {
          b()
        }
      },
      f() {
        this.func(function () {
          console.log(233);
        }, function () {
          console.log(332);
        })
      }
    }
  }
</script>

<style scoped>

</style>
