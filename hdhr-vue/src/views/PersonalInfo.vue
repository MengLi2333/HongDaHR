<template>
  <div id="personalInfo">
    <div id="frmDiv">
      <el-form ref="frm" :model="frmData" :rules="rules" id="frm" label-width="100px" label-position="left" inline>
        <el-form-item label="员工工号" prop="empCode">
          <el-input v-model="frmData.empCode" readonly></el-input>
        </el-form-item>
        <el-form-item label="所在部门编号" prop="deptID">
          <el-input v-model="frmData.deptID" readonly></el-input>
        </el-form-item>
        <el-form-item label="职称编号" prop="titleID">
          <el-input v-model="frmData.titleID" readonly></el-input>
        </el-form-item>
        <el-form-item label="岗位编号" prop="postID">
          <el-input v-model="frmData.postID" readonly></el-input>
        </el-form-item>
        <el-form-item label="员工姓名" prop="empName">
          <el-input v-model="frmData.empName" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="frmData.gender" :disabled="!canChg">
            <el-option label="男" :key="0" :value="0"></el-option>
            <el-option label="女" :key="1" :value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="身份证" prop="idCardCode">
          <el-input v-model="frmData.idCardCode" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker :readonly="!canChg"
            v-model="frmData.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="frmData.nativePlace" :readonly="!canChg"></el-input>
        </el-form-item>
        <el-form-item label="学历" prop="eduLevel">
          <el-select v-model="frmData.eduLevel" :disabled="!canChg">
            <el-option label="高中" :key="1" :value="1" ></el-option>
            <el-option label="专科" :key="2" :value="2"></el-option>
            <el-option label="本科" :key="3" :value="3"></el-option>
            <el-option label="硕士" :key="4" :value="4"></el-option>
            <el-option label="博士" :key="5" :value="5"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="名族" prop="nation">
          <el-select v-model="frmData.nation" :disabled="!canChg">
            <el-option label="汉族" :key="1" :value="1"></el-option>
            <el-option label="蒙古族" :key="2" :value="2"></el-option>
            <el-option label="回族" :key="3" :value="3"></el-option>
            <el-option label="藏族" :key="4" :value="4"></el-option>
            <el-option label="维吾尔族" :key="5" :value="5"></el-option>
            <el-option label="苗族" :key="6" :value="6"></el-option>
            <el-option label="彝族" :key="7" :value="7"></el-option>
            <el-option label="壮族" :key="8" :value="8"></el-option>
            <el-option label="布依族" :key="9" :value="9"></el-option>
            <el-option label="朝鲜族" :key="10" :value="10"></el-option>
            <el-option label="满族" :key="11" :value="11"></el-option>
            <el-option label="侗族" :key="12" :value="12"></el-option>
            <el-option label="瑶族" :key="13" :value="13"></el-option>
            <el-option label="白族" :key="14" :value="14"></el-option>
            <el-option label="土家族" :key="15" :value="15"></el-option>
            <el-option label="哈尼族" :key="16" :value="16"></el-option>
            <el-option label="哈萨克族" :key="17" :value="17"></el-option>
            <el-option label="傣族" :key="18" :value="18"></el-option>
            <el-option label="黎族" :key="19" :value="19"></el-option>
            <el-option label="傈僳族" :key="20" :value="20"></el-option>
            <el-option label="佤族" :key="21" :value="21"></el-option>
            <el-option label="畲族" :key="22" :value="22"></el-option>
            <el-option label="高山族" :key="23" :value="23"></el-option>
            <el-option label="拉祜族" :key="24" :value="24"></el-option>
            <el-option label="水族" :key="25" :value="25"></el-option>
            <el-option label="东乡族" :key="26" :value="26"></el-option>
            <el-option label="纳西族" :key="27" :value="27"></el-option>
            <el-option label="景颇族" :key="28" :value="28"></el-option>
            <el-option label="柯尔克孜族" :key="29" :value="29"></el-option>
            <el-option label="土族" :key="30" :value="30"></el-option>
            <el-option label="达斡尔族" :key="31" :value="31"></el-option>
            <el-option label="仫佬族" :key="32" :value="32"></el-option>
            <el-option label="羌族" :key="33" :value="33"></el-option>
            <el-option label="布朗族" :key="34" :value="34"></el-option>
            <el-option label="撒拉族" :key="35" :value="35"></el-option>
            <el-option label="撒拉族" :key="36" :value="36"></el-option>
            <el-option label="仡佬族" :key="37" :value="37"></el-option>
            <el-option label="锡伯族" :key="38" :value="38"></el-option>
            <el-option label="阿昌族" :key="39" :value="39"></el-option>
            <el-option label="普米族" :key="40" :value="40"></el-option>
            <el-option label="塔吉克族" :key="41" :value="41"></el-option>
            <el-option label="怒族" :key="42" :value="42"></el-option>
            <el-option label="乌孜别克族" :key="43" :value="43"></el-option>
            <el-option label="俄罗斯族" :key="44" :value="44"></el-option>
            <el-option label="鄂温克族" :key="45" :value="45"></el-option>
            <el-option label="德昂族" :key="46" :value="46"></el-option>
            <el-option label="保安族" :key="47" :value="47"></el-option>
            <el-option label="裕固族" :key="48" :value="48"></el-option>
            <el-option label="京族" :key="49" :value="49"></el-option>
            <el-option label="塔塔尔族" :key="50" :value="50"></el-option>
            <el-option label="独龙族" :key="51" :value="51"></el-option>
            <el-option label="鄂伦春族" :key="52" :value="52"></el-option>
            <el-option label="赫哲族" :key="53" :value="53"></el-option>
            <el-option label="门巴族" :key="54" :value="54"></el-option>
            <el-option label="珞巴族" :key="55" :value="55"></el-option>
            <el-option label="基诺族" :key="56" :value="56"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="政治面貌" prop="party">
          <el-select v-model="frmData.party" :disabled="!canChg">
            <el-option label="中共党员" :key="1" :value="1"></el-option>
            <el-option label="中共预备党员" :key="2" :value="2"></el-option>
            <el-option label="共青团员" :key="3" :value="3"></el-option>
            <el-option label="民主党派" :key="4" :value="4"></el-option>
            <el-option label="群众" :key="5" :value="5"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="健康状况" prop="health">
          <el-select v-model="frmData.health" :disabled="!canChg">
            <el-option label="良好" :key="1" :value="1"></el-option>
            <el-option label="健康" :key="2" :value="2"></el-option>
            <el-option label="一般" :key="3" :value="3"></el-option>
            <el-option label="有慢性疾病" :key="4" :value="4"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="户口类型" prop="regType">
          <el-select v-model="frmData.regType" :disabled="!canChg">
            <el-option label="城镇户口" :key="0" :value="0"></el-option>
            <el-option label="农村户口" :key="1" :value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="任职状态" prop="status">
          <el-select v-model="frmData.status" disabled>
            <el-option label="试用" :key="1" :value="1"></el-option>
            <el-option label="转正" :key="2" :value="2"></el-option>
            <el-option label="挂靠" :key="3" :value="3"></el-option>
            <el-option label="自动离职" :key="4" :value="4"></el-option>
            <el-option label="辞退" :key="5" :value="5"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
    <el-dialog title="密码修改" :visible.sync="pwdDialogVisible" width="30%">
      <el-form :model="pwdFrm" id="pwdFrm" ref="pwdFrm" style="margin: 0 auto; width: 300px">
        <el-form-item label="原密码">
          <el-input type="password" v-model="pwdFrm.orgPwd"></el-input>
        </el-form-item>
        <el-form-item label="新密码">
          <el-input type="password" v-model="pwdFrm.newPwd"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="pwdDialogCancel">取消修改</el-button>
    <el-button type="primary" @click="pwdDialogConfirm">确定修改</el-button>
  </span>
    </el-dialog>
    <div id="btnDiv" style="text-align: center; margin-top: 50px">
      <el-button v-show="canChg" @click="resetClick">重置</el-button>
      <el-button type="primary" v-show="canChg" @click="onSubmit('frm')">确认修改</el-button>
      <el-button type="primary" @click="chgClick">{{canChg ? "取消修改" : "修改个人信息"}}</el-button>
      <el-button type="primary" @click="pwdDialogVisible = true">修改密码</el-button>
      <el-button type="danger" @click="logoutClick">注销</el-button>
    </div>
  </div>
</template>

<script>
  import utils from '../utils/utils.js'
  import {request, handleResult} from "../network/request";
  import mutationsType from '../store/mutations-type.js'

  export default {
    name: "PersonalInfo",
    data() {
      return {
        canChg: false,
        pwdDialogVisible: false,
        frmData: utils.copyAttributes(this.$store.state.emp),
        orgFrmData: utils.copyAttributes(this.$store.state.emp),
        pwdFrm: {
          orgPwd: "",
          newPwd: ""
        },
        rules: {
          empName: [
            {required: true, message: "姓名不能为空", trigger: "blur"}
          ],
          idCardCode: [
            {required: true, message: "姓名不能为空", trigger: "blur"}
          ],
          nativePlace: [
            {required: true, message: "姓名不能为空", trigger: "blur"}
          ]
        }
      }
    },
    methods: {
      chgClick() {
        if (this.canChg) {
          this.frmData = utils.copyAttributes(this.orgFrmData)
        }
        this.canChg = !this.canChg
      },
      resetClick() {
        this.frmData = utils.copyAttributes(this.orgFrmData)
      },
      onSubmit(formName) {
        let _this = this
        this.$refs[formName].validate(valid => {
          if (valid) {
            // TODO 待测试
            this.$confirm('确认提交修改申请吗?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'info'
            }).then(() => {
              request({
                url: "/personalInfo/updInfo",
                method: "post",
                data: this.frmData
              }).then(res => handleResult(res, _this, () => {
                _this.canChg = false
                request({
                  url: "/personalInfo/getInfo",
                }).then(res => {
                  _this.$store.commit(mutationsType.SET_EMP, res.data.data)
                  _this.frmData = utils.copyAttributes(res.data.data)
                  _this.orgFrmData = utils.copyAttributes(res.data.data)
                }).catch(err => {
                  _this.$message.error("服务器繁忙, 请稍后重试")
                })
              }))
            }).catch(() => {
              _this.$message.info("操作取消")
            })
          } else {
            return false
          }
        })
      },
      logoutClick() {
        let _this = this
        this.$confirm("确认注销吗?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          request({
            url: "/personalInfo/logout",
            method: "post"
          }).then(res => handleResult(res, _this, () => {
            _this.$store.commit(mutationsType.DEL_EMP)
            _this.$router.replace("/login.html")
          })).catch(err => {
            _this.$message.error("服务器繁忙, 请稍后重试")
          })
        }).catch(err => {
          _this.$message.info("操作取消")
        })
      },
      pwdDialogCancel() {
        this.pwdDialogVisible = false
        this.$message.info("操作取消")
        this.pwdFrm = {
          orgPwd: "",
          newPwd: ""
        }
      },
      pwdDialogConfirm() {
        let _this = this
        this.$confirm("确认修改密码吗?", "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          request({
            url: "/personalInfo/chgPwd",
            method: "post",
            data: {
              empID: _this.$store.state.emp.empID,
              orgPassword: _this.pwdFrm.orgPwd,
              newPassword: _this.pwdFrm.newPwd
            }
          }).then(res => handleResult(res, _this, () => {
            request({
              url: "/personalInfo/logout",
              method: "post"
            }).then().catch()
            _this.$store.commit(mutationsType.DEL_EMP)
            _this.$router.replace("/login.html")
          })).catch(err => {
            _this.$message.error("服务器繁忙, 请稍后重试")
          })
        }).catch()
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

  .el-input {
    width: 200px;
  }

  .el-select {
    width: 200px;
  }

</style>
