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
    <button @click="goUser" class="btn btn-primary btn-lg active">User</button>
</template>
 
<style>

</style>