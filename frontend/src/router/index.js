import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Medicine from '../views/Medicine.vue'

import Patient from '../views/Patient.vue'
import Diagnosis from '../views/Diagnosis.vue'
import AllPatients from '../views/AllPatients.vue'
import TemperatureChart from '../charts/TemperatureChart.vue'
import Checkin from '../views/Checkin.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  
  {
    path:'/medicine',
    name: 'Medicine',
    component:Medicine
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
    path:'/checkin',
    name: 'Checkin',
    component:Checkin
  },
  
  {
    path:'/allPatients',
    name: 'AllPatients',
    component:AllPatients
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
