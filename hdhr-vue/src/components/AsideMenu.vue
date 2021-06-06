<template>
  <div id="asideMenu">
    <el-menu style="height: 100%" router>
      <el-menu-item :index="$store.state.emp.isLogin ? 'personalInfo.html' : 'login.html'">
        <span>个人信息管理</span>
      </el-menu-item>
      <el-menu-item>
        <span>职称信息管理</span>
      </el-menu-item>
      <el-menu-item>
        <span>岗位信息管理</span>
      </el-menu-item>
      <el-submenu index="sub">
        <template slot="title">
          <span >员工信息管理</span>
        </template>
        <el-menu-item index="Onboarding.html">
          <span>员工入职管理</span>
        </el-menu-item>
        <el-menu-item index="EmpInfo.html">
          <span>员工信息维护</span>
        </el-menu-item>
        <el-menu-item>
          <span>员工任职变更</span>
        </el-menu-item>
        <el-menu-item>
          <span>员工信息查询</span>
        </el-menu-item>
        <el-menu-item>
          <span>员工信息统计</span>
        </el-menu-item>
      </el-submenu>
      <el-menu-item index="dept.html">
        <span>组织机构管理</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: "AsiderMenu"
  }
</script>

<style scoped>
  #asideMenu {
    height: 100%;
  }
</style>
