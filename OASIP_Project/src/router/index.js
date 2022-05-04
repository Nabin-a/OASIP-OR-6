import {createRouter, createWebHistory} from 'vue-router'
import Note from '../components/Note.vue'
import EventList from '../components/EventList.vue'
import Home from '../views/Home.vue'


const history=createWebHistory()
const routes=[
    {
        path: '/' ,
        name: 'Home',
        component: Home
    },   
    {path: '/note/:id',
    name: 'Note',
    component: Note}

]

const router = createRouter({history, routes})
export default router;