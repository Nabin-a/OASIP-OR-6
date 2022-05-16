<script setup>
import { ref, onBeforeMount } from "vue";
import EventList from "../components/EventList.vue";
import EventDetail from "../components/EventDetail.vue";
import EventCreate from "../components/EventCreate.vue";
const events = ref([]);
const eventDetail = ref({});
const eventCategory = ref([]);
const isShow = ref(false);

const getEvents = async () => {
<<<<<<< HEAD
  const res = await fetch("http://localhost:8080/api/event");
=======
  const res = await fetch(import.meta.env.BASE_URL+"api/event");
>>>>>>> 745800e94a815574f6ee0ed46f738d1c65561d53
  if (res.status === 200) {
    events.value = await res.json();
    console.log(events.value);
    return events.value;
  } else console.log("error, cannot get notes");
};

onBeforeMount(async () => {
  await getEvents();
  console.log(events.value);
});

const getEventCategory = async () => {
<<<<<<< HEAD
  const res = await fetch("http://localhost:8080/api/category");
=======
  const res = await fetch(import.meta.env.BASE_URL+"api/category");
>>>>>>> 745800e94a815574f6ee0ed46f738d1c65561d53
  if (res.status === 200) {
    eventCategory.value = await res.json();
    console.log(eventCategory.value);
    return eventCategory.value;
  } else console.log("error, cannot get notes");
};

onBeforeMount(async () => {
  await getEventCategory();
  console.log(eventCategory.value);
});

const getEventid = async (id) => {
  console.log(id);
<<<<<<< HEAD
  const res = await fetch(`http://localhost:8080/api/event/${id}`);
=======
  const res = await fetch(import.meta.env.BASE_URL+`api/event/${id}`);
>>>>>>> 745800e94a815574f6ee0ed46f738d1c65561d53

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
<<<<<<< HEAD
  const res = await fetch("http://localhost:8080/api/event", {
=======
  const res = await fetch(import.meta.env.BASE_URL+"api/event", {
>>>>>>> 745800e94a815574f6ee0ed46f738d1c65561d53
    method: "POST",
    headers: {
      "content-type": "application/json;"
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
    alert('Added sucessfully')
    const addedSchedule = await res.json();
    events.value.push(addedSchedule);
    
  } else console.log("error, cannot be added");
};

const removeEvent = async (id) => {
  if (confirm("Delete this column?") == true) {
    console.log(id);
<<<<<<< HEAD
    const res = await fetch(`http://localhost:8080/api/event/${id}`, {
=======
    const res = await fetch(import.meta.env.BASE_URL+`api/event/${id}`, {
>>>>>>> 745800e94a815574f6ee0ed46f738d1c65561d53
      method: "DELETE"
    });
    if (res.status === 200) {
      events.value = events.value.filter((event) => event.id !== id);
      console.log("deleted successfully");
    } else console.log("error, cannot delete data");
  }
};
</script>

<template>
  <EventList
    :eventList="events"
    @getEventId="getEventid"
    @removeEvent="removeEvent"
  />
  <EventDetail :eventDetail="eventDetail" />
  <EventCreate
    :eventCreate="events"
    :eventCategory="eventCategory"
    @createSchedule="createNewSchedule"
  />
</template>

<style></style>
