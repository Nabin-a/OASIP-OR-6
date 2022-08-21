<script setup>
import Mytable from '../views/Mytable.vue'
import {useRouter} from 'vue-router'

const appRouter = useRouter()
const goUser = () => appRouter.push({name: 'User'})
</script>
 
<template>
    <div>
        <Mytable/>
        
    </div>
    <button @click="goUser">User</button>
</template>
 
<style>

</style>