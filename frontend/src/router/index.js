import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Medicine from '../views/Medicine.vue'
import About from '../views/About.vue'
import Test from '../views/Test.vue'
import Doctor from '../views/Doctor.vue'
import Patient from '../views/Patient.vue'
import Debug from '../views/debug.vue'
import Diagnosis from '../views/Diagnosis.vue'
import AllPatients from '../views/AllPatients.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    component:About
  },
  {
    path:'/medicine',
    name: 'Medicine',
    component:Medicine
  },
  {
    path:'/doctor',
    name: 'Doctor',
    component:Doctor
  },
  {
    path:'/debug',
    name: 'Debug',
    component:Debug
  },
  {
    path:'/patient',
    name: 'Patient',
    component:Patient
  },
  {
    path:'/diagnosis',
    name: 'Diagnosis',
    component:Diagnosis
  },
  {
    path:'/allPatients',
    name: 'AllPatients',
    component:AllPatients
  },
  {
    path:'/test',
    name:'Test',
    component: Test
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
