<template>
  <div id="loginComp">
    <div id="leftDiv">
      <img :src="imgSrc" alt="img" id="leftDivImg">
    </div>
    <div id="rightDiv">
      <div id="loginText" style="">Login</div>
      <el-form ref="frm" :model="frm" id="form" :rules="rules">
        <el-form-item label="员工工号" prop="empCode">
          <el-input v-model="frm.empCode" type="text"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="frm.password" type="password"></el-input>
        </el-form-item>
        <el-form-item style="padding: 30px">
          <el-button type="primary" style="width: 200px; height: 40px" @click="onsubmit('frm')">确定</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {request, handleResult} from '../network/request.js'
  import mutationsType from '../store/mutations-type.js'

  export default {
    name: "LoginComp",
    data() {
      return {
        imgSrc: require('../assets/login01.jpg'),
        rules: {
          empCode: [
            {required: true, message: '请输入员工工号', trigger: 'blur'},
            {min: 12, max: 12, message: '员工工号为12位字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        },
        frm: {
          empCode: "",
          password: ""
        }
      }
    },
    methods: {
      onsubmit(formName) {
        let _this = this
        this.$refs[formName].validate(valid => {
          if (valid) {
            console.log(1); // FIXME
            request({
              url: '/personalInfo/login',
              method: 'post',
              data: _this.frm
            }).then(res => handleResult(res, this, function() {
              console.log(res); // FIXME
              _this.$router.replace('/personalInfo.html')
              _this.$store.commit(mutationsType.SET_EMP, res.data.data) // TODO
            })).catch(err => {
              _this.$message.error('服务器繁忙, 请稍后重试')
            })
          } else {
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>
  #leftDiv {
    width: 400px;
    height: 500px;
    display: inline-block;
    border-radius: 30px 0 0 30px;
    vertical-align: top;
  }

  #rightDiv {
    width: 400px;
    height: 500px;
    border-radius: 0 30px 30px 0;
    display: inline-block;
    vertical-align: top;
    background-color: rgba(197, 225, 255, 0.71);
  }

  #leftDivImg {
    width: 400px;
    height: 500px;
    border-radius: 30px 0 0 30px;
  }

  #form {
    margin: 30px;
  }

  #loginText {
    font-size: 40px;
    margin-top: 50px;
    display: inline-block;
    font-family: 宋体,fantasy;
    user-select: none;
  }
</style>
