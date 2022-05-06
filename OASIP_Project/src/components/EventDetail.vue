<script setup>

import { useRoute, useRouter } from 'vue-router';
const { params } = useRoute()

const appRouter=useRouter()
const goBack =() => appRouter.go(-1)
</script>
 
<template>
    <div>
        <h1>Event Detail</h1>
        <div>
            <ul>
                <li>{{ this.$route.params.id }}</li>
                <li>{{ this.$route.params.name }}</li>
                <li>{{ this.$route.params.email }}</li>
                <li>{{ this.$route.params.category }}</li>
                <li>{{ this.$route.params.startTime }}</li>
                <li>{{ this.$route.params.duration }} mins</li>
                <li>{{ this.$route.params.note }}</li>
            </ul>
        </div>
        
        <div>
            <button @click="goBack">Back</button>
        </div>
    </div>
</template>
 
<style>

</style>