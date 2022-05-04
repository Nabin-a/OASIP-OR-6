<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
import Note from '../components/Note.vue';
const events = ref([])

onBeforeMount(async () => {
  await getNotes()
  console.log(events.value)
})

const getNotes = async () => {
  const res = await fetch('http://localhost:8080/api/event')
  if (res.status === 200) {
    events.value = await res.json()
    console.log(events.value)
    return events.value
  } else console.log('error, cannot get notes')
}
const ddd = async () => {
  const res = await fetch(`http://localhost:8080/notes/${id}`)
  if (res.status === 200) {
    notes.value = await res.json()
    console.log(notes.value)
  } else console.log('error, cannot get data')
}


</script>

<template>
    <EventList
        :eventList="events"
    />
    
    
   
</template>
 
<style>

</style>
