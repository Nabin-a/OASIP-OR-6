<script setup>
import moment from "moment";
import { ref, computed } from "vue";
defineEmits(["removeEvent", "getEventId", "editEvent"]);
defineProps({
  eventList: {
    type: Array,
    require: true,
  },
});
</script>

<template>
  <div class="container pt-3 pb-5">
    <h2>Scheduled Events</h2>
    <p v-if="eventList.length < 1">No schedule events</p>
    <table class="table table-dark table-striped table-hover" v-else>
      <thead>
        <tr>
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">Duration</th>
          <th scope="col" style="padding-left: 4.2%">ooo</th>
        </tr>
      </thead>
      <tbody v-for="(event, index) in eventList" :key="index">
        <tr>
          <td scope="col">{{ event.bookingName }}</td>
          <td scope="col">{{ event.categoryName }}</td>
          <td scope="col">{{ moment(event.startTime).format("l") }}</td>
          <td scope="col">{{ moment(event.startTime).format("kk:m") }}</td>
          <td scope="col">{{ event.durations }} mins</td>
          <td>
            <!-- Button trigger modal -->
            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#Modal"
              @click="$emit('getEventId', event.id)"
            >
              <i class="fa fa-info-circle"></i>
            </button>
            &nbsp
            <button
              type="button"
              class="btn btn-danger"
              @click="$emit('removeEvent', event.id)"
            >
              <i class="fa fa-trash"></i>
            </button>
            <button
              class="btn btn-primary"
              data-bs-target="#exampleModalToggle2"
              data-bs-toggle="modal"
              @click="$emit('getEventId', event.id)"
            >
              Edit
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style></style>
