import {createRouter, createWebHistory} from 'vue-router'
import Note from '../components/Note.vue'
import EventList from '../components/EventList.vue'


const history=createWebHistory()
const routes=[
    
    {path: '/note/:id',
    name: 'Note',
    component: Note}

]

const router = createRouter({history, routes})
export default router;