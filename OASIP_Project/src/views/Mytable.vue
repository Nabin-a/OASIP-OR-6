<script setup>
import { ref, onBeforeMount } from "vue";
import EventList from "../components/EventList.vue";
import EventDetail from "../components/EventDetail.vue";
import EventCreate from "../components/EventCreate.vue";
const events = ref([]);
const eventDetail = ref({});
const eventCategory = ref([]);

const getEvents = async () => {
  const res = await fetch("http://localhost:8080/api/event");
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
  const res = await fetch("http://localhost:8080/api/category");
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
  const res = await fetch(`http://localhost:8080/api/event/${id}`);

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
  const res = await fetch("http://localhost:8080/api/event", {
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
    const res = await fetch(`http://localhost:8080/api/event/${id}`, {
      method: "DELETE"
    });
    if (res.status === 200) {
      events.value = events.value.filter((event) => event.id !== id);
      console.log("deleted successfully");
    } else console.log("error, cannot delete data");
  }
};

// PUT
const updateEvent = async (id,CuBookingName,CuBookingEmail,CuCatetgory,CuDurations,editTime,editNote,) => {
  console.log(id,editTime,editNote)
  const res = await fetch(`http://localhost:8080/api/event/${id}`, {
    method: 'PUT',
    headers: {
      'content-type': 'application/json;'
    },
    body: JSON.stringify({
      bookingName: CuBookingName,
      bookingEmail: CuBookingEmail,
      durations: CuDurations,
      category: CuCatetgory,
      startTime: editTime,
      note: editNote
    })
  })
  if (res.status === 200) {
    const editedEvent = await res.json()
    events.value = events.value.map((event) =>
      event.bookingId === editedEvent.bookingId
        ? { ...event, note: editedEvent.note ,
                      startTme: editedEvent.startTime }
        : event
    )
    console.log('edited successfully')
  } else console.log('error, cannot be edit')
}



</script>

<template>
  <EventList
    :eventList="events"
    @getEventId="getEventid"
    @removeEvent="removeEvent"
  />
  <EventDetail :eventDetail="eventDetail"/>
   <!-- :eventCreate="events" -->
  <EventCreate
    :eventCategory="eventCategory"
    :eventCreate="events"
    :currentEvent="eventDetail"
    @createSchedule="createNewSchedule"
    @updateEvent="updateEvent"
  />

  

</template>

<style></style>
