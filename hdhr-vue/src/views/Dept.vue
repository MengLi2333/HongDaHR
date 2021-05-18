<template>
  <div id="dept">
    <div id="treeDiv">
      <el-tree :data="deptForest" :props="deptProp" @node-click="handleNodeClick"
               node-key="deptID" :expand-on-click-node="false"></el-tree>
    </div>
    <div id="deptDiv">
      <el-form :model="dept" ref="deptFrm" id="deptFrm" :rules="deptRules" label-width="100px" label-position="left" inline>
        <el-form-item label="部门编号" prop="deptCode">
          <el-input v-model="dept.deptCode" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="部门名称" prop="deptName">
          <el-input v-model="dept.deptName" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="部门类型" prop="deptType">
          <el-select v-model="dept.deptType" :disabled="!canChg">
            <el-option :value="0" :key="0" label="管理部门"></el-option>
            <el-option :value="1" :key="1" label="生产部门"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="部门地址" prop="location">
          <el-input v-model="dept.location" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="邮政编码" prop="postCode">
          <el-input v-model="dept.postCode" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="telephone">
          <el-input v-model="dept.telephone" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="传真" prop="fax">
          <el-input v-model="dept.fax" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="mail">
          <el-input v-model="dept.mail" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="是否已被移除" prop="isRemoved">
          <el-select v-model="dept.isRemoved" :disabled="!canChg">
            <el-option :value="0" :key="0" label="未被移除"></el-option>
            <el-option :value="1" :key="1" label="已被移除"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="移除日期" v-show="dept.isRemoved === 1" prop="removeDate">
          <el-date-picker v-model="dept.removeDate" readonly
              type="date" value-format="yyyy-MM-dd" placeholder="日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div id="btnDiv">
        <el-button type="primary">修改信息</el-button>
        <el-button-group>
          <el-button type="primary" @click="createChildClick">创建子部门</el-button>
          <el-button type="primary" @click="resetDeptClick">调整部门</el-button>
          <el-button type="danger" @click="removeDeptClick" v-if="!dept.isRemoved">移除部门</el-button>
          <el-button type="success" @click="rejoinDeptClick" v-else>恢复部门</el-button>
        </el-button-group>
      </div>
    </div>
  </div>
</template>

<script>
  import {request} from "../network/request";

  export default {
    name: "Dept",
    data() {
      return {
        canChg: false,
        deptForest: [],
        deptProp: {
          label: "deptName",
          children: "subDepts"
        },
        dept: {
          deptID: 0,
          deptCode: "",
          deptName: "",
          deptType: "",
          parentID: 0,
          location: "",
          postCode: "",
          telephone: "",
          fax: "",
          mail: "",
          isRemoved: 0,
          removeDate: ""
        },
        deptRules: {
          deptCode: [
            {required: true, message: "部门编号不能为空", trigger: "blur"}
          ],
          deptName: [
            {required: true, message: "部门名称不能为空", trigger: "blur"}
          ]
        }
      }
    },
    methods: {
      loadDeptForest() {
        let _this = this
        request({
          url: "/dept/deptForest"
        }).then(res => {
          if (res.data.status === 200) {
            _this.deptForest = res.data.data
          } else {
            _this.$message.error("服务器繁忙, 部门数据加载失败")
          }
        }).catch(err => {
          _this.$message.error("服务器繁忙, 部门数据加载失败")
        })
      },
      handleNodeClick(node) {
        let _this = this
        request({
          url: "/dept/detail",
          method: "get",
          params: {
            deptID: node.deptID
          }
        }).then(res => {
          if (res.data.status === 200) {
            _this.dept = res.data.data
          } else {
            _this.$message.error("服务器繁忙, 部门数据加载失败")
          }
        }).catch(err => {
          _this.$message.error("服务器繁忙, 部门数据加载失败")
        })
      },
      createChildClick() {
        console.log("createChildClick") // TODO
      },
      resetDeptClick() {
        console.log("resetDeptClick") // TODO
      },
      removeDeptClick() {
        console.log("removeDeptClick") // TODO
      },
      rejoinDeptClick() {
        console.log("rejoinDeptClick") // TODO
      }
    },
    mounted() {
      this.loadDeptForest()
    }
  }
</script>

<style scoped>
  #dept {
  }

  #treeDiv {
    margin-top: 30px;
    margin-left: 10px;
    display: inline-block;
    float: left;
    vertical-align: top;
  }

  #deptDiv {
    width: 70%;
    padding-top: 100px;
    display: inline-block;
    float: right;
    vertical-align: top;
  }

  #deptDiv .el-form {
    width: 700px;
  }

  .el-input {
    width: 200px;
  }

  .el-select {
    width: 200px;
  }

  #btnDiv {
    margin-top: 50px;
    padding-left: 100px;
  }

  #btnDiv .el-button-group {
    margin-left: 10px;
  }
</style>
