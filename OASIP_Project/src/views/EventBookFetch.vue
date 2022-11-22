<script setup>
import { ref , onBeforeMount } from "vue";
import EventBooking from "../components/EventBooking.vue";

const events = ref([]);
const eventCategory = ref([]);
let token = localStorage.getItem('token')

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

// const createNewSchedule = async (
//   newBookingName,
//   newBookingEmail,
//   newStartTime,
//   newDurations,
//   newCategory,
//   newNote,
//   newAttachment
// ) => {
//   console.log(
//     newBookingName,
//     newBookingEmail,
//     newStartTime,
//     newDurations,
//     newCategory,
//     newNote,
//     newAttachment
//   );

//   const res = await fetch(`http://localhost:8080/api/events`, {
   
//     method: "POST",
//     headers: {
//       "content-type": "application/json;"
//     },
//     body: JSON.stringify({
//       bookingName: newBookingName,
//       bookingEmail: newBookingEmail,
//       startTime: newStartTime,
//       durations: newDurations,
//       categoryId: newCategory,
//       note: newNote,
//       attachment: formData
//     })
//   });
//   if (res.status === 201) {
//     location.reload();
//     alert("Added sucessfully");
//     const addedSchedule = await res.json();
//     events.value.push(addedSchedule);
//   } else if (res.status === 401) {
//     const resfs = await fetch(`https://localhost:8080/api/refresh`, {
//       headers: {
//         'Authorization': `Bearer` + localStorage.getItem('refreshToken')
//       }
//     })
//     if (resfs.status === 200){
//       data = await resfs.json()
//       localStorage.setItem('token', data.accessToken)
//     } else if (resfs.status === 401) {
//       goLogin()
//     } 
//   } 
//   else console.log("error, cannot be added");
// };

const uploadFile = async (newBookingName,
  newBookingEmail,
  newStartTime,
  newDurations,
  newCategory,
  newNote,
  newFile) => { 
    console.log(
    newBookingName,
    newBookingEmail,
    newStartTime,
    newDurations,
    newCategory,
    newNote,
    newFile
  );

    var fileAtt = document.getElementById("fileupload").files[0]
    const formData = new FormData();
    formData.append("bookingName",newBookingName)
    formData.append("bookingEmail",newBookingEmail)
    formData.append("startTime",newStartTime)
    formData.append("durations",newDurations)
    formData.append("categoryId",newCategory)
    formData.append("note",newNote)
    formData.append("file",fileAtt);
  
  const uploadRes = await fetch(`http://localhost:8080/api/events`,{
    method:"POST",
    header: {
      "content-type": 'multipart/form-data'
    },
    body: formData
  })
  if (uploadRes.status === 201) {
    location.reload();
    alert("Added sucessfully");
    const addedSchedule = await res.json();
    events.value.push(addedSchedule);
  } else if (uploadRes.status === 401) {
    const resfs = await fetch(`http://localhost:8080/api/refresh`, {
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
}


</script>
 
<template>

<EventBooking 
    :eventCategory="eventCategory"
    :eventCreate="events"
    @uploadFile="uploadFile"
/>

</template>
 
<style>

</style>