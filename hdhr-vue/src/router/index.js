import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index.html'
  },
  {
    path: '/index.html',
    name: 'Index',
    component: Index
  },
  {
    path: '/personalInfo.html',
    name: 'PersonalInfo',
    component: () => import('../views/PersonalInfo.vue')
  },
  {
    path: '/login.html',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/dept.html',
    name: 'Dept',
    component: () => import('../views/Dept.vue')
  },{
    path: '/Onboarding.html',
    name: 'Onboarding',
    component: () => import('../views/Onboarding.vue')
  },
  {
    path: '/EmpInfo.html',
    name: 'EmpInfo',
    component: () => import('../views/EmpInfo.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
