<template>
  <div id="app">
    <el-container id="outContainer">
      <el-header height="70px" style="padding: 0;">
        <HeadComp></HeadComp>
      </el-header>
      <el-container style="height: 100%">
        <el-aside width="170px">
          <aside-menu></aside-menu>
        </el-aside>
        <el-main id="main">
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style>
  html, body, #app, #outContainer, #main {
    width: 100%;
    height: 100%;
    padding: 0;
    margin: 0;
  }
</style>

<script>
  import AsideMenu from './components/AsideMenu'
  import HeadComp from './components/HeadComp'

  export default {
    components: {
      AsideMenu,
      HeadComp
    }
  }
</script>
