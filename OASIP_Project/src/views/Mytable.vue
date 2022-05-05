<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
const events = ref([])

onBeforeMount(async () => {
  await getEvent()
  console.log(events.value)
})

const getEvent = async () => {
  const res = await fetch('http://localhost:8080/api/event')
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