import { createRouter, createWebHashHistory } from "vue-router";
import EventDetail from "../components/EventDetail.vue";
import EventList from "../components/EventList.vue";
import Home from "../views/Home.vue";
import User from "../views/User.vue"
import Event from "../views/Event.vue"
import Login from "../views/Login.vue"
import Register from "../views/Register.vue"
import Accessdenied from "../views/Accessdenied.vue"

const history = createWebHashHistory(import.meta.env.BASE_URL);
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/users",
    name: "User",
    component: User,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/event",
    name: "Event",
    component: Event,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/register",
    name: "Register",
    component: Register
  },
  {
    path: "/access-denied",
    name: "Access denied",
    component: Accessdenied
  }
//   { path: "/event/:id", name: "Detail", component: EventDetail },
];

const router = createRouter({ history, routes });

router.beforeEach((to,from,next) => {
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!localStorage.getItem('token')) {
      next({ name: 'Login' })
    } else if (localStorage.getItem("role")=='ROLE_student'){
      if (to.path==='/users') {
        next('/access-denied')
      } else {
        next()
      }
    } else if (localStorage.getItem("role")=='ROLE_admin') {
      if (to.path==='/users' || to.path==='/event') {
        next()      
    } else {
        next()
    }
  }  else if (localStorage.getItem("role")=='ROLE_lecturer') {
      if (to.path==='/users') {
        next('/access-denied')
      } else {
        next()
      }
  }
} else  {
    next()
  }
})

export default router;
