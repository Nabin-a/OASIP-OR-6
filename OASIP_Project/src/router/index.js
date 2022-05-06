import { createRouter, createWebHistory } from "vue-router";
import EventDetail from "../components/EventDetail.vue";
import EventList from "../components/EventList.vue";
import Home from "../views/Home.vue";

const history = createWebHistory();
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  { path: "/event/:id", name: "Detail", component: EventDetail },
];

const router = createRouter({ history, routes });
export default router;
