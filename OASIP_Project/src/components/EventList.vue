<script setup>
import moment from "moment"
defineProps({
  eventList: {
    type: Array,
    require: true
  }
})

</script>
 
<template>
<h2>Event List</h2>
<h1 v-if="eventList.length < 1">No schedule events</h1>
  <table v-else class="table table-dark table-hover">
    <thead>
        <tr>
          <th scope="row"></th>
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">Duration</th>c
        </tr>
    </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
      <tr>
        <th scope="row"></th>
        <td>{{event.bookingName}}</td>
        <td>{{event.category}}</td>
        <td>{{moment(event.startTime).format('l')}}</td>
        <td>{{moment(event.startTime).format('LT')}}</td>
        <td>{{event.durations}}</td>
      </tr>
    </tbody>
  </table>
</template>
 
<style>

</style>