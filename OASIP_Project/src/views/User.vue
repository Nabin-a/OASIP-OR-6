<script setup>
import UserTable from './UserTable.vue';
import {useRouter} from 'vue-router'

const appRouter = useRouter()
const goHome = () => appRouter.push({name: 'Home'})
</script>
 
<template>
    <div>
        <UserTable/>
        
    </div>
        <button @click="goHome" class="btn btn-primary btn-lg active">Home</button>
</template>
 
<style>

</style>