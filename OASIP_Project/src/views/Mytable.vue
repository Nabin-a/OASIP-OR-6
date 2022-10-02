<script setup>
import { ref, onBeforeMount } from "vue";
import EventList from "../components/EventList.vue";
import EventDetail from "../components/EventDetail.vue";
import EventCreate from "../components/EventCreate.vue";

const events = ref([]);
const eventDetail = ref({});
const eventCategory = ref([]);

let token = localStorage.getItem('accessToken')

onBeforeMount(async () => {

  await getEvents();
  await getEventCategory();
});

const getEvents = async () => {
  const res = await fetch(`http://localhost:8080/api/events`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    events.value = await res.json();
    console.log(events.value);
    return events.value;
  } else console.log("error, cannot get notes");
};

const getEventCategory = async () => {
  const res = await fetch(`http://localhost:8080/api/category`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    eventCategory.value = await res.json();
    console.log(eventCategory.value);
    return eventCategory.value;
  } else console.log("error, cannot get notes");
};

const getEventid = async (id) => {
  console.log(id);
  const res = await fetch(`http://localhost:8080/api/events/${id}`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`
    }
  })
  if (res.status === 200) {
    eventDetail.value = await res.json();
    console.log(eventDetail.value);
  } else console.log("error, cannot get data");
};

const createNewSchedule = async (
  newBookingName,
  newBookingEmail,
  newStartTime,
  newDurations,
  newCategory,
  newNote
) => {
  console.log(
    newBookingName,
    newBookingEmail,
    newStartTime,
    newDurations,
    newCategory,
    newNote
  );
  const res = await fetch(`http://localhost:8080/api/events/`, {
    method: "POST",
    headers: {
      "content-type": "application/json;",
      'Authorization' : `Bearer ${token}`
    },
    body: JSON.stringify({
      bookingName: newBookingName,
      bookingEmail: newBookingEmail,
      startTime: newStartTime,
      durations: newDurations,
      eventCategoryId: newCategory,
      note: newNote
    })
  });
  if (res.status === 201) {
    location.reload();
    alert("Added sucessfully");
    const addedSchedule = await res.json();
    events.value.push(addedSchedule);
  } else console.log("error, cannot be added");
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
    } else console.log("error, cannot delete data");
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
  } else console.log("error, cannot be edit");
};
</script>

<template>
  <EventCreate
    :eventCategory="eventCategory"
    :eventCreate="events"
    :currentEvent="eventDetail"
    @createSchedule="createNewSchedule"
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
