<template>
  <div id="OnboardingDiv">
    <h1 align="center">员工入职管理</h1>
    <h5 align="center">基本信息</h5>
    <el-form ref="OnboardingForm" id="OnboardingForm" :label-position="OnboardingForm.labelPosition" :model="emp"
             :rules="rules" label-width="100px" inline>

          <el-form-item label="姓名" prop="empName">
            <el-input v-model="emp.empName" placeholder="请输入2~30个字符"></el-input>
          </el-form-item>

          <el-form-item label="最高学历" prop="eduLevel">

            <el-select v-model="emp.eduLevel">
              <el-option v-for="item in OnboardingForm.eduction_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="性别" prop="gender">

            <el-select v-model="emp.gender">
              <el-option label="男" value="0"></el-option>
              <el-option label="女" value="1"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="名族" prop="nation">

            <el-select v-model="emp.nation">
              <el-option v-for="item in OnboardingForm.nation_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="出生日期" prop="birthday;">
            <el-date-picker
              v-model="emp.birthday"
              align="right"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>

          <el-form-item label="政治面貌" prop="party">

            <el-select v-model="emp.party">
              <el-option v-for="item in OnboardingForm.poli_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="身份证号" prop="idCardCode;">
            <el-input v-model="emp.idCardCode" placeholder="请输入身份证号"></el-input>
          </el-form-item>

          <el-form-item label="健康状况" prop="health">

            <el-select v-model="emp.health">
              <el-option v-for="item in OnboardingForm.health_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="籍贯" prop="nativePlace;">

            <el-input v-model="emp.nativePlace" placeholder="请输入3~30个字符"></el-input>
          </el-form-item>

          <el-form-item label="户口类型" prop="regType;">

            <el-select v-model="emp.regType">
              <el-option label="农村户口" value="0"></el-option>
              <el-option label="城镇户口" value="1"></el-option>
            </el-select>
          </el-form-item>

          <h5 align="center">任职信息</h5>
          <el-form-item label="部门" prop="deptID">

            <el-select v-model="emp.deptID">
              <el-option v-for="item in OnboardingForm.department_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>



          <el-form-item label="岗位" prop="postID">

            <el-select v-model="emp.postID">
              <el-option v-for="item in OnboardingForm.post_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="职称" prop="titleID">

            <el-select v-model="emp.titleID">
              <el-option v-for="item in OnboardingForm.pro_title_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="状态" prop="status">

            <el-select v-model="emp.status">
              <el-option v-for="item in OnboardingForm.emp_status_list"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

      <el-form-item style="text-align: center; width: 100%">
        <el-button type="primary" @click="OnSubmit">提交</el-button>
      </el-form-item>

  </el-form>
  </div>
</template>

<script>
  import {request, handleResult} from '../network/request.js'
  import mutationsType from '../store/mutations-type.js'

  export default {
    data() {
      return {
        OnboardingForm: {
          labelPosition: 'left',
          emp_status_list: [{value: 1, label: '试用',}, {value: 2, label: '转正',}, {value: 3, label: '挂靠',}, {
            value: 4,
            label: '自动离职',
          }, {value: 5, label: '辞退',},],
          pro_title_list: [{value: 1, label: '主管',}, {value: 2, label: '助理工程师',}, {value: 3, label: '董事长',}, {
            value: 4,
            label: '总裁',
          }, {value: 5, label: '总经理',}, {value: 6, label: '总监',}, {value: 7, label: '经理',}, {value: 8, label: '主管',},],
          post_list: [{value: 1, label: 'CEO',}, {value: 2, label: 'CTO',}, {value: 3, label: '运营',}, {
            value: 4,
            label: '产品经理',
          }, {value: 5, label: '交互设计师',},],
          department_list: [{value: 1, label: '总务部',}, {value: 2, label: '财务部',}, {value: 3, label: '市场部',}, {
            value: 4,
            label: '采购部',
          }, {value: 5, label: '技术部',}, {value: 6, label: '生产部',}, {value: 7, label: '质检部',}, {
            value: 8,
            label: '工程部',
          }, {value: 9, label: '项目部',},],
          health_list: [{value: 1, label: '良好',}, {value: 2, label: '健康',}, {value: 3, label: '一般',}, {
            value: 4,
            label: '有慢性病',
          },],
          poli_list: [{value: 1, label: '中共党员',}, {value: 2, label: '中共预备党员',}, {value: 3, label: '共青团员',}, {
            value: 4,
            label: '民主党派',
          }, {value: 5, label: '群众',},],
          eduction_list: [{value: 1, label: '博士',}, {value: 2, label: '硕士',}, {value: 3, label: '本科',}, {
            value: 4,
            label: '专科',
          }, {value: 5, label: '高中及以下',},],
          nation_list: [{value: 1, label: '汉族',}, {value: 2, label: '满族',}, {value: 3, label: '蒙古族',}, {
            value: 4,
            label: '回族',
          }, {value: 5, label: '藏族',}, {value: 6, label: '维吾尔族',}, {value: 7, label: '苗族',}, {
            value: 8,
            label: '彝族',
          }, {value: 9, label: '壮族',}, {value: 10, label: '布依族',}, {value: 11, label: '侗族',}, {
            value: 12,
            label: '瑶族',
          }, {value: 13, label: '白族',}, {value: 14, label: '土家族',}, {value: 15, label: '哈尼族',}, {
            value: 16,
            label: '哈萨克族',
          }, {value: 17, label: '傣族',}, {value: 18, label: '黎族',}, {value: 19, label: '傈僳族',}, {
            value: 20,
            label: '佤族',
          }, {value: 21, label: '畲族',}, {value: 22, label: '高山族',}, {value: 23, label: '拉祜族',}, {
            value: 24,
            label: '水族',
          }, {value: 25, label: '东乡族',}, {value: 26, label: '纳西族',}, {value: 27, label: '景颇族',}, {
            value: 28,
            label: '柯尔克孜族',
          }, {value: 29, label: '土族',}, {value: 30, label: '达斡尔族',}, {value: 31, label: '仫佬族',}, {
            value: 32,
            label: '羌族',
          }, {value: 33, label: '布朗族',}, {value: 34, label: '撒拉族',}, {value: 35, label: '毛南族',}, {
            value: 36,
            label: '仡佬族',
          }, {value: 37, label: '锡伯族',}, {value: 38, label: '阿昌族',}, {value: 39, label: '普米族',}, {
            value: 40,
            label: '朝鲜族',
          }, {value: 41, label: '塔吉克族',}, {value: 42, label: '怒族',}, {value: 43, label: '乌孜别克族',}, {
            value: 44,
            label: '俄罗斯族',
          }, {value: 45, label: '鄂温克族',}, {value: 46, label: '德昂族',}, {value: 47, label: '保安族',}, {
            value: 48,
            label: '裕固族',
          }, {value: 49, label: '京族',}, {value: 50, label: '塔塔尔族',}, {value: 51, label: '独龙族',}, {
            value: 52,
            label: '鄂伦春族',
          }, {value: 53, label: '赫哲族',}, {value: 54, label: '门巴族',}, {value: 55, label: '珞巴族',}, {
            value: 56,
            label: '基诺族',
          },]
        },
        rules: {
          empName: [
            {required: true, message: '请输入活动名称', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          education: [
            {required: true}
          ],
          sex: [
            {required: true}
          ],
          sex: [
            {required: true}
          ],
          title: [
            {required: true}
          ],
          post: [
            {required: true}
          ],
          ID_number: [
            {required: true}
          ],
          native_place: [
            {required: true}
          ],
          hukou: [
            {required: true}
          ],
          department: [
            {required: true}
          ],
          health: [
            {required: true}
          ],
          status: [
            {required: true}
          ],
          poli: [
            {required: true}
          ],
          nation: [
            {required: true}
          ],
          birth: [
            {required: true}
          ],
        },
        emp: {
          empID: 5,
          deptID: '',
          titleID: '',
          postID: '',
          empName: '',
          empCode: '',
          gender: '',
          idCardCode: '',
          birthday: '',
          nativePlace: '',
          eduLevel: '',
          nation: '',
          party: '',
          health: '',
          regType: '',
          status: '',
          password: '',
        }
      }
    },
    methods: {
      OnSubmit(formName) {

        request({
          url: '/emp/save',
          method: 'post',
          data: this.emp
        })
      },
    }
  }
</script>

<style>
  #OnboardingDiv {

  }

  #OnboardingForm {
    margin: auto;
    top: auto;
  }

  #OnboardingForm {
    width: 70%;
    text-align: center;
  }

  .el-date-editor.el-input {
    width: 200px;
  }

  .el-input {
    width: 200px;
  }

  .el-select {
    width: 200px;
  }
</style>