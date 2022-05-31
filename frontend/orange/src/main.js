import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import './styles/styles.scss'
import VueRouter from 'vue-router'
import MainComponent from './components/MainComponent';
import LoginComponent from './components/guest/LoginComponent';

Vue.config.productionTip = false
Vue.use(VueRouter)

const routes = [
  { path: '/', component: MainComponent },
  { path: '/login', component: LoginComponent },
]

const router = new VueRouter({
  routes
})

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
