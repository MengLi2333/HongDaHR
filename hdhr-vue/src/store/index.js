import Vue from 'vue'
import Vuex from 'vuex'

import mutationsType from './mutations-type.js'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    emp: {
      isLogin: false,
      empID: 0,
      deptID: 0,
      titleID: 0,
      postID: 0,
      empName: "",
      empCode: "",
      gender: 0,
      idCardCode: "",
      birthday: "",
      nativePlace: "",
      eduLevel: 0,
      nation: 0,
      party: 0,
      health: 0,
      regType: 0,
      status: 0
    }
  },
  mutations: {
    [mutationsType.SET_EMP](state, emp) {
      state.emp.empID = emp.empID
      state.emp.deptID = emp.deptID
      state.emp.titleID = emp.titleID
      state.emp.postID = emp.postID
      state.emp.empName = emp.empName
      state.emp.empCode = emp.empCode
      state.emp.gender = emp.gender
      state.emp.idCardCode = emp.idCardCode
      state.emp.birthday = emp.birthday
      state.emp.nativePlace = emp.nativePlace
      state.emp.eduLevel = emp.eduLevel
      state.emp.nation = emp.nation
      state.emp.party = emp.party
      state.emp.health = emp.health
      state.emp.regType = emp.regType
      state.emp.status = emp.status
      state.emp.isLogin = true
    },
    [mutationsType.DEL_EMP](state) {
      state.emp.empID = 0
      state.emp.deptID = 0
      state.emp.titleID = 0
      state.emp.postID = 0
      state.emp.empName = ""
      state.emp.empCode = ""
      state.emp.gender = 0
      state.emp.idCardCode = ""
      state.emp.birthday = ""
      state.emp.nativePlace = ""
      state.emp.eduLevel = 0
      state.emp.nation = 0
      state.emp.party = 0
      state.emp.health = 0
      state.emp.regType = 0
      state.emp.status = 0
      state.emp.isLogin = false
    }
  },
  actions: {
  },
  modules: {
  }
})
