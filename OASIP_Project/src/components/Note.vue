<script setup>

import { useRoute, useRouter } from 'vue-router';
defineProps({
  eventList: {
    type: Array,
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
            <li v-for ="(event, index) in eventList" :key="index">
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