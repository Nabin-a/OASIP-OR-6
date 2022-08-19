import { createRouter, createWebHistory } from "vue-router";
import EventDetail from "../components/EventDetail.vue";
import EventList from "../components/EventList.vue";
import Home from "../views/Home.vue";
import User from "../views/User.vue"

const history = createWebHistory(import.meta.env.BASE_URL);
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
  }
//   { path: "/event/:id", name: "Detail", component: EventDetail },
];

const router = createRouter({ history, routes });
export default router;
