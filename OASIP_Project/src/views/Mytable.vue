<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
import EventDetail from '../components/EventDetail.vue';
import EventCreate from '../components/EventCreate.vue';
const events = ref([])
const eventDetail = ref({})
const isShow = ref(false)
// function show(data) {
// const nameText = document.querySelector('.fullname');
// const emailText = document.querySelector('.email');
// const duration = document.querySelector('duration');
// const category = document.querySelector('category');
// const note = document.querySelector('note')
// }




const getEvents = async () => {
  const res = await fetch('http://localhost:8080/api/event')
  if (res.status === 200) {
    events.value = await res.json()
    console.log(events.value)
    return events.value
  } else console.log('error, cannot get notes')
}

onBeforeMount(async () => {
  await getEvents()
  console.log(events.value)
})

const getEventid = async (id) => {
  console.log(id)
  const res = await fetch(`http://localhost:8080/api/event/${id}`)

  if (res.status === 200) {
    eventDetail.value = await res.json()
    console.log(eventDetail.value)
  } else console.log('error, cannot get data')
}

const createNewSchedule = async (newSchedule) => {
  console.log(newSchedule)
  const res = await fetch('http://localhost:8080/api/event', {
    method: 'POST',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify({ BookingName: newSchedule })
  })
  if (res.status === 201) {
    const addedSchedule = await res.json()
    events.value.push(addedSchedule)
    console.log('added sucessfully')
  } else console.log('error, cannot be added')
}



</script>

<template>
    <EventList
        :eventList="events" @getEventId="getEventid"
    />
    <EventDetail
        :eventDetail="eventDetail"  
      />
    <EventCreate />

</template>
 
<style>

</style>
