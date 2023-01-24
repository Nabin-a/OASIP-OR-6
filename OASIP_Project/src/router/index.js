import { createRouter, createWebHashHistory } from "vue-router";
import EventDetail from "../components/EventDetail.vue";
import EventList from "../components/EventList.vue";
import Home from "../views/Home.vue";
import User from "../views/User.vue"
import Event from "../views/Event.vue"
import Login from "../views/Login.vue"
import Register from "../views/Register.vue"

const history = createWebHashHistory(import.meta.env.BASE_URL);
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/user",
    name: "User",
    component: User
  },
  {
    path: "/event",
    name: "Event",
    component: Event
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
  }
//   { path: "/event/:id", name: "Detail", component: EventDetail },
];

const router = createRouter({ history, routes });
export default router;
