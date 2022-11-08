<script setup>
import moment from "moment";
import { ref, computed } from "vue";
defineEmits(["removeEvent", "getEventId", "editEvent"]);
defineProps({
  eventList: {
    type: Array,
    require: true
  }
});

</script>

<template>
  <div class="container pt-3 pb-5">
    <h2 style="color: white">Scheduled Events</h2>
    &nbsp
    <h4 v-if="eventList.length < 1" style="color:rgb(227, 70, 106) " >No schedule events</h4>
    <table class="table table-light table-striped table-hover" v-else>
      <thead>
        <tr>
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">Duration</th>
          <th scope="col" style="padding-left: 8.5%">ooo</th>
        </tr>
      </thead>
      <tbody v-for="(event, index) in eventList" :key="index">
        <tr>
          <td scope="col">{{ event.bookingName }}</td>
          <td scope="col">{{ event.categoryName }}</td>
          <td scope="col">{{ moment(event.startTime).format("D/MM/YYYY") }}</td>
          <td scope="col">{{ moment(event.startTime).format("HH:mm") }}</td>
          <td scope="col">{{ event.durations }} mins</td>
          <td style="padding-left: 2%">
            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#DetailModal"
              @click="$emit('getEventId', event.id)"
            >
              <i class="fa fa-info-circle"></i>
            </button>
            &nbsp
            <button
              class="btn btn-success"
              data-bs-target="#EditModal"
              data-bs-toggle="modal"
              @click="$emit('getEventId', event.id)"
            >
              <i class="fa fa-edit"></i>
            </button>
            &nbsp
            <button
              type="button"
              class="btn btn-danger"
              @click="$emit('removeEvent', event.id)"
            >
              <i class="fa fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style></style>
