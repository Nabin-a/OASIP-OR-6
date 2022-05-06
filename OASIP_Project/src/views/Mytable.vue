<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
import EventDetail from '../components/EventDetail.vue';

const events = ref([])
const eventDetail = ref({})
const notes = ref([])
const isShow = ref(false)

onBeforeMount(async () => {
  await getEvents()
  console.log(events.value)
})

const getEvents = async () => {
  const res = await fetch('http://localhost:8080/api/event')
  if (res.status === 200) {
    events.value = await res.json()
    console.log(events.value)
    return events.value
  } else console.log('error, cannot get notes')
}

const getEventId = async (id) => {
  const res = await fetch(`http://localhost:8080/api/event/${id}`)
  if (res.status === 200) {
   eventDetail.value = await res.json()
    console.log(eventDetail.value)
  } else console.log('error, cannot get this event id')
}




</script>

<template>
    <EventList
        :eventList="events"
        @getEventId="getEventId"        
    />
    <EventDetail
        :eventDetail="eventDetail"
    />
    
</template>
 
<style>

</style>
