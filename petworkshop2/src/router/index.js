import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// import MyStart from "../components/MyStart.vue";
import TopicsPage from "../views/TopicsPage";
import ArticlesShelf from "../views/ArticlesShelf.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  {
    path: '/Articles',
    name: 'Articles',
    component: ArticlesShelf
  },
  {
    path: '/Topics',
    name: 'Topics',
    component: TopicsPage
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
