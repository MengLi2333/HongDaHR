<template>
  <div id="headComp">
    <div id="leftDiv">
      <img :src="logoSrc" alt="logo" style="line-height: 70;">
      <span id="logoText">HongDaHR</span>
    </div>
    <div id="rightDiv">
      <label for="empBtn">
        <span style="user-select: none">{{$store.state.emp.isLogin ? $store.state.emp.empName : "未登录"}}</span>
        <el-button type="primary" circle style="margin-left: 20px" id="empBtn" @click="empBtnClick">
          <i class="el-icon-user-solid"></i>
        </el-button>
      </label>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Header",
    data() {
      return {
        logoSrc: require('../assets/HDLogo.svg')
      }
    },
    methods: {
      empBtnClick() {
        if (this.$store.state.emp.isLogin) {
          this.$router.replace("/personalInfo.html")
        } else {
          this.$router.replace("/login.html")
        }
      }
    }
  }
</script>

<style scoped>
  #headComp {
    width: 100%;
    height: 100%;
    background-color: #ECF5FF;
  }

  #leftDiv, #rightDiv {
    display: flex;
    align-items: center;
    height: 100%;
  }

  #leftDiv {
    margin-left: 30px;
    float: left;
  }

  #rightDiv {
    margin-right: 30px;
    float: right;
  }

  #logoText {
    padding-left: 30px;
    font-family: "Microsoft JhengHei",fantasy;
    font-size: 15px;
  }
</style>
