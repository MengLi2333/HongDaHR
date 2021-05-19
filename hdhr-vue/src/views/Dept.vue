<template>
  <div id="dept">
    <div id="treeDiv">
      <el-tree :data="deptForest" :props="deptProp" node-key="deptID" :expand-on-click-node="false"
               @node-click="handleNodeClick" @node-drop="handleDeptDrag" draggable>
        <span class="custom-tree-node" slot-scope="{node, data}">
          <span>{{node.label}}</span>
          <span>
            <el-button type="text" size="small" @click.stop="createChildClick(data)" style="margin-left: 10px">
              <i class="el-icon-plus"></i>
            </el-button>
            <el-button type="text" size="small" @click.stop="deleteDeptClick(data)" style="color: red;">
              <i class="el-icon-close"></i>
            </el-button>
          </span>
        </span>
      </el-tree>
      <el-button type="text" size="small" style="margin-left: 25px"
                 @click="createDeptClick" v-show="deptForest.length !== 0">
        <i class="el-icon-plus"></i>
      </el-button>
    </div>
    <div id="deptDiv" v-show="curState !== ''">
      <el-form :model="dept" ref="deptFrm" id="deptFrm" :rules="deptRules" label-width="100px" label-position="left"
               inline>
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
          <el-select v-model="dept.isRemoved" disabled>
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
        <el-button type="primary" @click="updateDeptClick"
                   v-show="curState === 'showDept'">修改信息</el-button>
        <el-button type="primary" @click="confirmUpdateDeptClick"
                   v-show="curState === 'updateDept'">确认修改</el-button>
        <el-button type="primary" @click="cancelUpdateDeptClick"
                   v-show="curState === 'updateDept'">取消修改</el-button>
        <el-button type="primary" @click="confirmCreateDeptClick"
                   v-show="curState === 'addDept'">确认添加</el-button>
        <el-button type="danger" @click="removeDeptClick"
                   v-show="curState === 'showDept' && !dept.isRemoved">移除部门</el-button>
        <el-button type="success" @click="rejoinDeptClick"
                   v-show="curState === 'showDept' && dept.isRemoved">恢复部门</el-button>
      </div>
    </div>
  </div>
</template>

<script>
  import {request, handleResult} from "../network/request";

  export default {
    name: "Dept",
    data() {
      return {
        canChg: false,
        curState: "", // 空字符串, showDept, addDept, updateDept
        // newDeptDialogVisible: false,
        deptForest: [],
        deptProp: {
          label: "deptName",
          children: "subDepts"
        },
        dept: {
          deptID: 0,
          deptCode: "",
          deptName: "",
          deptType: 0,
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
        this.curState = "showDept"
        this.canChg = false
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
      createChildClick(data) {
        let _this = this
        this.$confirm("是否为" + data.deptName + "添加子部门?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          this.dept = {
            deptID: 0, deptCode: "", deptName: "", deptType: 0, parentID: data.deptID,
            location: "", postCode: "", telephone: "", fax: "", mail: "", isRemoved: 0, removeDate: ""
          }
          this.curState = 'addDept'
          this.canChg = true
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      createDeptClick() {
        let _this = this
        this.$confirm("是否添加部门?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          this.dept = {
            deptID: 0, deptCode: "", deptName: "", deptType: 0, parentID: 0,
            location: "", postCode: "", telephone: "", fax: "", mail: "", isRemoved: 0, removeDate: ""
          }
          this.curState = 'addDept'
          this.canChg = true
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      confirmCreateDeptClick() {
        let _this = this
        this.$confirm("确认添加部门?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/addDept",
            method: "post",
            data: this.dept
          }).then(res => handleResult(res, _this, () => {
            _this.loadDeptForest()
          })).catch(err => {
            _this.$message.error("服务器繁忙, 部门添加失败")
          })
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      updateDeptClick() {
        this.curState = 'updateDept'
        this.canChg = true
      },
      confirmUpdateDeptClick() {
        let _this = this
        this.$confirm("确认修改" + data.deptName + "?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/updateDept",
            method: "post",
            data: this.dept
          }).then(res => handleResult(res, _this))
            .catch(err => {
              _this.$message.error("服务器繁忙, 部门修改失败")
            })
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      cancelUpdateDeptClick() {
        this.curState = ''
        this.canChg = false
        this.$message.info("操作取消")
      },
      handleDeptDrag(dragNode, aroundNode, position) {
        let _this = this
        let deptID = dragNode.data.deptID
        let parentID = (position === "inner" ? aroundNode.data.deptID : aroundNode.data.parentID)
        if (dragNode.data.parentID === parentID) {
          return
        }
        this.$confirm("确认调整" + dragNode.data.deptName + "?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/resetDept",
            method: "post",
            data: {
              deptID,
              parentID
            }
          }).then(res => handleResult(res, _this, () => {
            if (res.data.status === 200) {
              _this.loadDeptForest()
            }
          })).catch(err => {
            _this.$message.error("服务器繁忙, 部门修改失败")
          })
        }).catch(() => {
          _this.$message.info("操作取消")
          _this.loadDeptForest()
        })
      },
      deleteDeptClick(data) {
        let _this = this
        this.$confirm("确认删除" + data.deptName + "?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/deleteDept",
            method: "post",
            data: {
              deptID: data.deptID
            }
          }).then(res => handleResult(res, _this, () => {
            _this.loadDeptForest()
          })).catch(err => {
            _this.$message.error("服务器繁忙, 部门删除失败")
          })
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      removeDeptClick() {
        let _this = this
        this.$confirm("确认移除" + this.dept.deptName + "?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/removeDept",
            method: "post",
            data: {
              deptID: this.dept.deptID
            }
          }).then(res => handleResult(res, _this))
            .catch(err => {
              _this.$message.error("服务器繁忙, 部门移除失败")
            })
        }).catch(() => {
          _this.$message.info("操作取消")
        })
      },
      rejoinDeptClick() {
        let _this = this
        this.$confirm("确认恢复" + this.dept.deptName + "?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          _this.curState = ''
          _this.canChg = false
          request({
            url: "/dept/rejoinDept",
            method: "post",
            data: {
              deptID: this.dept.deptID
            }
          }).then(res => handleResult(res, _this))
            .catch(err => {
              _this.$message.error("服务器繁忙, 部门恢复失败")
            })
        }).catch(() => {
          _this.$message.info("操作取消")
        })
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

  #btnDiv .el-button {
    margin-left: 10px;
  }

  .custom-tree-node {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

</style>
