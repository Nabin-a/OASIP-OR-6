<script setup>
defineProps({
  eventList: {
    type: Array,
    require: true
  }
})
</script>
 
<template>
<h2>Event List</h2>
<p v-if="eventList.length < 1">No schedule events</p>
    <ul v-else>
      <li v-for="(event, index) in eventList" :key="index">
        Name: {{ event.bookName }}, 
        Start Time: {{ event.startTime }},
        Note: {{event.note}} ,Catagoty: {{ event.catagoty }} 
      </li>
    </ul>
</template>
 
<style>

</style>