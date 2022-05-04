<script setup>

import { useRoute, useRouter } from 'vue-router';
defineProps({
  eventId: {
    type: Object,
    require: true
  }
})


let {params} = useRoute()
console.log(params.id)

const appRouter=useRouter()
const goBack =() => appRouter.go(-1)
</script>
 
<template>
    <div>
        <h1>Event Detail</h1>
        <div>
            <li v-for ="(event, index) in eventId" :key="index">
            ss:{{event.bookingName}},
            </li>
        </div>
        
        <div>
            <button @click="goBack">Back</button>
        </div>
    </div>
</template>
 
<style>

</style>