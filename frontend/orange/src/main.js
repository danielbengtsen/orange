import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import './styles/styles.scss'
import VueRouter from 'vue-router'
import IndexComponent from './components/IndexComponent';
import LoginComponent from './components/guest/LoginComponent';
import store from './store';
import axios from 'axios';
import HomeComponent from './components/user/HomeComponent';

axios.defaults.withCredentials = true
axios.defaults.baseURL = 'https://BASE_URL_HERE/';

Vue.config.productionTip = false
Vue.use(VueRouter)

const routes = [
  { 
    path: '/',
    name: 'Index', 
    component: IndexComponent,
  },
  { 
    path: '/login',
    name: 'Login', 
    component: LoginComponent,
    meta: { guest: true }, 
  },
  { 
    path: '/home',
    name: 'Home', 
    component: HomeComponent,
    meta: { requiresAuth: true }, 
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.baseURL,
  routes
})

router.beforeEach((to, from, next) => {
  if(to.matched.some(record => record.meta.requiresAuth))
  {
    if(store.getters.isAuthenticated)
    {
      next();
      return;
    }
    next('/login');
  }
  else
  {
    next();
  }
});

router.beforeEach((to, from, next) => {
  if(to.matched.some((record) => record.meta.guest))
  {
    if(store.getters.isAuthenticated)
    {
      next('/home');
      return;
    }
    next();
  }
  else
  {
    next();
  }
});

new Vue({
  vuetify,
  store,
  router,
  render: h => h(App)
}).$mount('#app')
