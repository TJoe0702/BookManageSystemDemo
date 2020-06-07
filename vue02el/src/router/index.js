import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import PageOne from '../views/BookManage.vue'
import PageTwo from '../views/BookAdd.vue'
import PageFour from '../views/PageFour.vue'
import Index from '../views/Index.vue';
import BookManage from "../views/BookManage";
import BookAdd from "../views/BookAdd";
import BookUpdate from "../views/BookUpdate";

Vue.use(VueRouter)

  const routes = [
    {
      path: "/",
      name: "图书管理",
      show:true,
      component: Index,
      redirect: "/BookManage",
      children: [
        {
          path: "/BookManage",
          name: "查询图书",
          show:true,
          component: BookManage
        },
        {
          path: "/BookAdd",
          name: "添加图书",
          show:true,
          component: BookAdd
        },
        {
          path: "/BookUpdate",
          // name: "修改图书",
          component: BookUpdate
        }
      ]
    },

]

const router = new VueRouter({
  routes
})

export default router
