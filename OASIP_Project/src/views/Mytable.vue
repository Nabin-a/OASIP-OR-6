<script setup>
import { ref, onBeforeMount } from "vue";
import { useRouter } from "vue-router";
import EventList from "../components/EventList.vue";
import EventDetail from "../components/EventDetail.vue";
import EventCreate from "../components/EventCreate.vue";

const events = ref([]);
const eventDetail = ref({});
const eventCategory = ref([]);

const appRouter = useRouter();
const goLogin = () => appRouter.push({ name: "Login" });

let token = localStorage.getItem('token')
let retoken = localStorage.getItem('refreshToken')

onBeforeMount(async () => {

  await getEvents();
  await getEventCategory();
});

const getEvents = async () => {
  const res = await fetch(`http://localhost:8080/api/events`, {
    method: "GET",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    events.value = await res.json();
    console.log(events.value);
    return events.value;
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}` 
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } else console.log("cannot get events")
};

const getEventCategory = async () => {
  const res = await fetch(`http://localhost:8080/api/category`, {
    method: "GET",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    eventCategory.value = await res.json();
    console.log(eventCategory.value);
    return eventCategory.value;
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}`
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } else console.log("cannot get category")
};

const getEventid = async (id) => {
  console.log(id);
  const res = await fetch(`http://localhost:8080/api/events/${id}`, {
    method: "GET",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
  if (res.status === 200) {
    eventDetail.value = await res.json();
    console.log(eventDetail.value);
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}`
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } 
  else console.log("error, cannot get data");
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
      'Authorization': `Bearer ${token}`
    },
    body: JSON.stringify({
      bookingName: newBookingName,
      bookingEmail: newBookingEmail,
      startTime: newStartTime,
      durations: newDurations,
      categoryId: newCategory,
      note: newNote,
      attachment: fileName.value.length > 0 ? fileName.value : null,
    })
  });
  if (res.status === 201) {
    location.reload();
    alert("Added sucessfully");
    const addedSchedule = await res.json();
    events.value.push(addedSchedule);
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}`
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } 
  else console.log("error, cannot be added");
};

const removeEvent = async (id) => {
  if (confirm("Delete this column?") == true) {
    console.log(id);
    const res = await fetch(`http://localhost:8080/api/events/${id}`, {
      method: "DELETE",
      headers: {
        'Authorization': `Bearer ${token}`
      }
    });
    if (res.status === 200) {
      events.value = events.value.filter((event) => event.id !== id);
      console.log("deleted successfully");
    } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}`
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } 
    else console.log("error, cannot delete data");
  }
};

// PUT
const updateEvent = async (id, editTime, editNote) => {
  console.log(id, editTime, editNote);
  const res = await fetch(`http://localhost:8080/api/events/${id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json;",
      'Authorization': `Bearer ${token}`
    },
    body: JSON.stringify({
      startTime: editTime,
      note: editNote
    })
  });
  if (res.status === 200) {
    location.reload();
    alert("Edit Success");
    console.log("edited successfully");
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/users/refresh`, {
      headers: {
        'Authorization': `Bearer ${retoken}`
      }
    })
    if (resfs.status === 200){
      const data = await resfs.json()
      localStorage.setItem('token', data.accessToken)
    } else if (resfs.status === 401) {
      goLogin()
    } 
  } 
  else console.log("error, cannot be edit");
};
</script>

<template>
  <EventCreate
    :eventCategory="eventCategory"
    :eventCreate="events"
    :currentEvent="eventDetail"
    @updateEvent="updateEvent"
  />

  <EventList
    :eventList="events"
    @getEventId="getEventid"
    @removeEvent="removeEvent"
  />
  <EventDetail :eventDetail="eventDetail" />
</template>

<style></style>
