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
  <table v-else>
    <thead>
        <tr>
          <th>Booking Name</th>
          <th>Catagory</th>
          <th>Start Date</th>
          <th>Start Time</th>
          <th>Duration</th>
          <th></th>
        </tr>
    </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
      <td>{{event.bookingName}}</td>
      <td>{{event.eventCategoryName}}</td>
      <td>{{moment(event.startTime).format('l')}}</td>
      <td>{{moment(event.startTime).format('LT')}}</td>
      <td>{{event.durations}}</td>
    </tbody>
  </table>
</template>
 
<style>

</style>