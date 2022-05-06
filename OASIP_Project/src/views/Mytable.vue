<script setup>
import { ref, onBeforeMount } from 'vue';
import EventList from '../components/EventList.vue';
import Note from '../components/Note.vue';
import Home from './Home.vue';
const events = ref([])
const eventid = ref([])
// function show(data) {
// const nameText = document.querySelector('.fullname');
// const emailText = document.querySelector('.email');
// const duration = document.querySelector('duration');
// const category = document.querySelector('category');
// const note = document.querySelector('note')
// }




const getNotes = async () => {
  const res = await fetch('http://localhost:8080/api/event')
  if (res.status === 200) {
    events.value = await res.json()
    console.log(events.value)
    return events.value
  } else console.log('error, cannot get notes')
}

onBeforeMount(async () => {
  await getNotes()
  console.log(events.value)
})

const getNotebyid = async (id) => {
  console.log(id)
  const res = await fetch(`http://localhost:8080/api/event/${id}`)

  if (res.status === 200) {
    eventid.value = await res.json()
    console.log(eventid.value)
    return eventid.value
    //  const data = await res.json()
    // console.log(JSON.stringify(data))

    // const {id} = data; 

    // document.getElementById('ename').textContent = bookingName;
  } else console.log('error, cannot get data')
}



  // 2
//   .then ((response ) => {
//     return response.json()
//   })
//   .then ((json) => {
//     const user = json.events;
//     nameText.innerHTML = user.nameText
//     emailText.innerTHML = user.bookingEmail
//     duration.innerHTML = user.duration
//     category.innerHTML = user.category
//     note.innerHTML = user.note
// })
// .catch((error) => {
//  console.log(error.message)
// })
// }/
//3

//   const result = fetch(`http://localhost:8080/api/event/${id}`)
//     .then (data => data.json())
//     .then (data => {
//       console.log(data)

//       document.getElementById('name').innerText = data.file
//     })

// console.log('result >' , result);


</script>

<template>
    <EventList
        :eventList="events" @getDetailbyid="getNotebyid"
    />
    <Note
        :eventList="events"  @getDetailbyid="getNotebyid"
      />
   
</template>
 
<style>

</style>
