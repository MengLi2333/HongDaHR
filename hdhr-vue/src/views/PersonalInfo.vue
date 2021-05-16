<template>
  <div id="personalInfo">
    <div id="frmDiv">
      <el-form ref="frm" :model="frm" id="frm" label-width="100px" label-position="left" inline>
        <el-form-item label="员工工号">
          <el-input v-model="$store.state.emp.empCode" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="所在部门编号">
          <el-input v-model="$store.state.emp.deptID" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="职称编号">
          <el-input v-model="$store.state.emp.titleID" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="岗位编号">
          <el-input v-model="$store.state.emp.postID" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="员工姓名">
          <el-input v-model="$store.state.emp.empName" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="$store.state.emp.gender" :label="0" :disabled="canChg">男</el-radio>
          <el-radio v-model="$store.state.emp.gender" :label="1" :disabled="canChg">女</el-radio>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input v-model="$store.state.emp.idCardCode" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="生日">
          <el-input v-model="$store.state.emp.birthday" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="籍贯">
          <el-input v-model="$store.state.emp.nativePlace" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="学历">
          <el-input v-model="$store.state.emp.eduLevel" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="名族">
          <el-input v-model="$store.state.emp.nation" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="政治面貌">
          <el-input v-model="$store.state.emp.party" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="健康状况">
          <el-input v-model="$store.state.emp.eduLevel" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="户口类型">
          <el-input v-model="$store.state.emp.regType" :disabled="canChg"></el-input>
        </el-form-item>
        <el-form-item label="工作状态">
          <el-input v-model="$store.state.emp.status" :disabled="canChg"></el-input>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PersonalInfo",
    data() {
      return {
        canChg: true
      }
    }
  }
</script>

<style scoped>
  #frmDiv {
    margin-top: 50px;
  }

  #frm {
    width: 700px;
    margin: 0 auto;
  }
</style>
