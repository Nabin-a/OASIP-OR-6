<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
const events = ref([])

onBeforeMount(async () => {
  await getEvent()
  console.log(events.value)
})

<<<<<<< HEAD
const getEvent = async () => {
  const res = await fetch('http://localhost:8080/api/event')
=======
const getNotes = async () => {
  const res = await fetch('http://172.20.74.94:8080/api/event')
>>>>>>> d355592f374fe7e1f6038f571c23470bfa9fee1d
  if (res.status === 200) {
    events.value = await res.json()
    console.log(events.value)
    return events.value
  } else console.log('error, cannot get notes')
}

const getEventById = async (id) => {
  const res = await fetch(`http://localhost:8080/api/event/${id}`)
  if (res.status === 200) {
    events.value.id = await res.json()
    console.log(events.value.id)
    return events.value.id
  } else console.log('error, cannot get notes')
}


</script>

<template>
    <EventList
        :eventList="events"
        @showDetail="getEventById"
    />
</template>
 
<style>

</style>
