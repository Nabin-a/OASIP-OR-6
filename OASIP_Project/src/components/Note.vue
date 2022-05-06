<script setup>

import { useRoute, useRouter } from 'vue-router';

import Mytable from '../views/Mytable.vue';

defineProps({
  eventList: {
    type: Object,
    require: true
  }
})

defineEmits(['getDetailbyid'])

let {params} = useRoute()


const appRouter=useRouter()
const goBack =() => appRouter.go(-1)
</script>
 
<template>
    <div >
        <h1>Event Detail</h1>
        
        
       
        <div v-for="(note,index) in eventList" :key="index">
        {{note.bookingName}}</div>
        <button  @click="$emit('getDetailbyid',$route.params.id)">getDetailbyid</button>
        <div>
          <p>{{this.$route.params.id}}</p>
          <p>{{this.$route.params.bookingName}}/</p>
          <p>{{this.$route.params.duration}}</p>
            <button @click="goBack">Back</button>
        </div>
    </div>
</template>
 
<style>

</style>