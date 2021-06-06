<template>
  <div>
    <el-dialog
      title="员工详细信息"
      :visible.sync="CheckdialogVisible"
      width="90%"
      >
        <el-form ref="CheckForm" id="CheckForm" :label-position="CheckForm.labelPosition" :model="CheckForm" label-width="70px" inline>

              <el-form-item label="姓名" prop="empName">
                <el-input v-model="CheckForm.MarkedRow.empName" :disabled="disableFlag"></el-input>
              </el-form-item>

              <el-form-item label="最高学历" prop="eduLevel">

                <el-select v-model="CheckForm.MarkedRow.eduLevel" :disabled="disableFlag">
                  <el-option v-for="item in eduction_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="性别" prop="gender">

                <el-select v-model="CheckForm.MarkedRow.gender" :disabled="disableFlag">
                  <el-option v-for="item in gender_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="名族" prop="nation">

                <el-select v-model="CheckForm.MarkedRow.nation" :disabled="disableFlag">
                  <el-option v-for="item in nation_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="出生日期" prop="birthday;">
                <el-date-picker
                  v-model="CheckForm.MarkedRow.birthday"
                  align="right"
                  type="date"
                  :disabled="disableFlag"
                >
                </el-date-picker>
              </el-form-item>

              <el-form-item label="政治面貌" prop="party">

                <el-select v-model="CheckForm.MarkedRow.party" :disabled="disableFlag">
                  <el-option v-for="item in poli_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="身份证号" prop="idCardCode;">
                <el-input v-model="CheckForm.MarkedRow.idCardCode" :disabled="disableFlag"></el-input>
              </el-form-item>

              <el-form-item label="健康状况" prop="health">

                <el-select v-model="CheckForm.MarkedRow.health" :disabled="disableFlag">
                  <el-option v-for="item in health_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="籍贯" prop="nativePlace;">

                <el-input v-model="CheckForm.MarkedRow.nativePlace" :disabled="disableFlag"></el-input>
              </el-form-item>

              <el-form-item label="户口类型" prop="regType;">

                <el-select v-model="CheckForm.MarkedRow.regType" :disabled="disableFlag">
                  <el-option v-for="item in regType_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>

                </el-select>
              </el-form-item>

              <el-form-item label="部门" prop="deptID">

                <el-select v-model="CheckForm.MarkedRow.deptID" :disabled="disableFlag">
                  <el-option v-for="item in department_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="岗位" prop="postID">

                <el-select v-model="CheckForm.MarkedRow.postID" :disabled="disableFlag">
                  <el-option v-for="item in post_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="职称" prop="titleID">

                <el-select v-model="CheckForm.MarkedRow.titleID" :disabled="disableFlag">
                  <el-option v-for="item in pro_title_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="状态" prop="status">

                <el-select v-model="CheckForm.MarkedRow.status" :disabled="disableFlag">
                  <el-option v-for="item in emp_status_list"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
          <el-form-item style="width: 600px;text-align: center" >
            <el-button type="primary" @click="CloseCheckDialog" style="width: 100px; margin: auto;">确 定</el-button>
          </el-form-item>

      </el-form>

    </el-dialog>

      <el-table
        :data="EmpData"
        style="width: 100%"
        max-height="1000">
        <el-table-column
          fixed
          prop="deptID"
          label="部门"
          width="150"
          :formatter="dept_fmt">
        </el-table-column>
        <el-table-column
          prop="empName"
          label="姓名"
          width="120"
        >
        </el-table-column>
        <el-table-column
          prop="gender"
          label="性别"
          width="120"
        :formatter="gender_fmt">
        </el-table-column>
        <el-table-column
          prop="nativePlace"
          label="籍贯"
          width="120">
        </el-table-column>

        <el-table-column
          prop="idCardCode"
          label="身份证号"
          width="120">
        </el-table-column>

        <el-table-column
          prop="eduLevel"
          label="最高学历"
          width="120"
          :formatter="edu_fmt">
        </el-table-column>

        <el-table-column
          fixed="right"
          label="操作"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="deleteRow(scope.$index, EmpData)"
              type="text"
              size="small">
              移除
            </el-button>
            <el-button
            @click.native.prevent="OpenCheckDialog(scope.$index, 'check')"
            type="text"
            size="small">
            查看
          </el-button>
            <el-button
              @click.native.prevent="OpenCheckDialog(scope.$index, 'update')"
              type="text"
              size="small">
              修改
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    <div style="width: 100px; margin: auto;top: auto;">
      <el-button @click="loadEmpData" style="text-align: center;">刷新</el-button>
    </div>
    </div>
</template>

    <script>
      import {request, handleResult} from '../network/request.js'
      import mutationsType from '../store/mutations-type.js'
      export default {
        methods: {
          gender_fmt(row)
          {
            for (let i = 0; i < this.gender_list.length; i++) {
              if (row.gender == this.gender_list[i].value)
                return this.gender_list[i].label;
            }
          },
          edu_fmt(row)
          {
            for (let i = 0; i < this.eduction_list.length; i++) {
              if (row.eduLevel == this.eduction_list[i].value)
                return this.eduction_list[i].label;
            }
          },
          dept_fmt(row)
          {
            for (let i = 0; i < this.department_list.length; i++) {
              if (row.deptID == this.department_list[i].value)
                return this.department_list[i].label;
            }
          },
          OpenCheckDialog(index, state)
          {
            this.state = state;
           this.CheckdialogVisible = true;
           this.CheckForm.MarkedRow = this.EmpData[index];
           this.state == "update" ? this.disableFlag = false : this.disableFlag = true;
          },
          CloseCheckDialog()
          {
            if (this.state == "update")
            {
              let _this = this
              request({
                url: '/emp/update',
                method: 'post',
                data: _this.CheckForm.MarkedRow,
              }).then(res => {
                if (res.data.status === 200) {
                  _this.CheckForm.MarkedRow = ''
                  console.log("ok")
                } else {
                  _this.$message.error("服务器繁忙, 员工数据修改失败")
                }
              }).catch(err => {
                _this.$message.error("服务器繁忙, 员工数据修改失败")
              })
            }
            this.CheckdialogVisible = false;
          },
          deleteRow(index, rows) {
            let _this = this
            request({
              url: '/emp/delete',
              method: 'post',
              data: _this.EmpData[index]
            }).then(res => {
              if (res.data.status === 200) {
                rows.splice(index, 1);
                console.log(_this.EmpData)
              } else {
                _this.$message.error("服务器繁忙, 员工数据删除失败")
              }
            }).catch(err => {
              _this.$message.error("服务器繁忙, 员工数据删除失败")
            })
          },
          loadEmpData() {
            let _this = this

            request({
              url: '/emp/get',
            }).then(res => {
              if (res.data.status === 200) {
                _this.EmpData = res.data.data
                console.log(_this.EmpData)
                for (let i = 0; i < _this.EmpData.length; i++) {

                }
              } else {
                _this.$message.error("服务器繁忙, 员工数据加载失败")
              }
            }).catch(err => {
              _this.$message.error("服务器繁忙, 员工数据加载失败")
            })
          },


        },
        mounted() {
          this.loadEmpData()
        },
        data() {
          return {
            EmpData: [],
            CheckForm: {
              MarkedRow: '',
              labelPosition: 'left',
            },
            CheckdialogVisible: false,
            disableFlag: true,
            state: '',
            emp_status_list: [{value: 1, label: '试用',}, {value: 2, label: '转正',}, {value: 3, label: '挂靠',}, {
              value: 4,
              label: '自动离职',
            }, {value: 5, label: '辞退',},],
            pro_title_list: [{value: 1, label: '主管',}, {value: 2, label: '助理工程师',}, {value: 3, label: '董事长',}, {
              value: 4,
              label: '总裁',
            },
              {value: 5, label: '总经理',}, {value: 6, label: '总监',}, {value: 7, label: '经理',}, {value: 8, label: '主管',},],
            post_list: [{value: 1, label: 'CEO',}, {value: 2, label: 'CTO',}, {value: 3, label: '运营',}, {
              value: 4,
              label: '产品经理',
            }, {value: 5, label: '交互设计师',},],
            regType_list: [{
            value: 0, label: '农村户口'},{
            value: 1, label: '城镇户口', }],
            gender_list: [{
              value: 0, label: '男'
            },{value: 1, label: '女'}],
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
          }
        }
      }
    </script>
<style>
  #CheckForm{
    width: 70%;
    margin: auto;
    top: auto;
  }
  .el-date-editor.el-input {
    width: 200px;
  }
</style>