<script setup>
import { ref , onBeforeMount } from "vue";
import EventBooking from "../components/EventBooking.vue";

const events = ref([]);
const eventCategory = ref([]);

onBeforeMount(async () => {

await getEventCategory();
});

const getEventCategory = async () => {
  const res = await fetch(`http://localhost:8080/api/category`, {
    method: "GET",

  });
  if (res.status === 200) {
    eventCategory.value = await res.json();
    console.log(eventCategory.value);
    return eventCategory.value;
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/refresh`, {
      headers: {
        'Authorization': `Bearer` + localStorage.getItem('refreshToken')
      }
    })
    if (resfs.status === 200){
      data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } else console.log("cannot get category")
};

const createNewSchedule = async (
  newBookingName,
  newBookingEmail,
  newStartTime,
  newDurations,
  newCategory,
  newNote,
  newAttachment
) => {
  console.log(
    newBookingName,
    newBookingEmail,
    newStartTime,
    newDurations,
    newCategory,
    newNote,
    newAttachment
  );
  const res = await fetch(`http://localhost:8080/api/events`, {
    method: "POST",
    headers: {
      "content-type": "application/json;",
    },
    body: JSON.stringify({
      bookingName: newBookingName,
      bookingEmail: newBookingEmail,
      startTime: newStartTime,
      durations: newDurations,
      categoryId: newCategory,
      note: newNote,
      attachment: newAttachment
    })
  });
  if (res.status === 201) {
    location.reload();
    alert("Added sucessfully");
    const addedSchedule = await res.json();
    events.value.push(addedSchedule);
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/refresh`, {
      headers: {
        'Authorization': `Bearer` + localStorage.getItem('refreshToken')
      }
    })
    if (resfs.status === 200){
      data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } 
  else console.log("error, cannot be added");
};

</script>
 
<template>

<EventBooking 
    :eventCategory="eventCategory"
    :eventCreate="events"
    @createSchedule="createNewSchedule"
/>

</template>
 
<style>

</style>