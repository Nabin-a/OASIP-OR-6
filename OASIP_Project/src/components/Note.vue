<script setup>

import { useRoute, useRouter } from 'vue-router';
defineProps({
  eventList: {
    type: Array,
    require: true
  }
})
let {params} = useRoute()

const appRouter=useRouter()
const goBack =() => appRouter.go(-1)
</script>
 
<template>
    <div>
        <h1>Event Detail</h1>
        <div>
            <div v-for ="event in eventList" :key="event.id">
            
            <li>{{event.id}}</li>
            <li>zzz</li>
            <li>{{event.bookingName}}</li>
            </div>
        </div>
        <div>
            <button @click="goBack">Back</button>
        </div>
    </div>
</template>
 
<style>

</style>