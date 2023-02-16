import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import SendNewCorr from './views/SendMessage/SendNewCorr.vue'
import AddAttachment from './views/SendMessage/AddAttachment.vue'
import NewCorrespondence from './views/SendMessage/NewCorrespondence'
import LoginPage from './views/LoginPage'
import vuetify from './plugins/vuetify'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
import MessageCard from './components/MessageCard';


Vue.use(VueRouter)
Vue.config.productionTip = false
const routes = [
 
  {path: '/correspondence', component: NewCorrespondence},
  {path: '/attachment', component : AddAttachment},
  {path: '/login', component: LoginPage},
  {path: '/new', component: SendNewCorr},
  {path: '/', component: MessageCard}



]
const router = new VueRouter({mode: 'history',routes: routes})
new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
