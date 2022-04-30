<script setup>
defineProps({
  eventList: {
    type: Array,
    require: true
  }
})
</script>
 
<template>
<h2>Event List</h2>
<p v-if="eventList.length < 1">No schedule events</p>
  <table v-else>
    <thead>
        <tr>
          <th>Booking Name</th>
          <th>Catagory</th>
          <th>Start Up Time</th>
          <th>Duration</th>
          <th></th>
        </tr>
    </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
      <td>{{event.bookingName}}</td>
      <td>{{event.eventCategoryName}}</td>
      <td>{{event.startTime}}</td>
      <td>{{event.durations}}</td>
    </tbody>
  </table>
    <!-- <ul v-else>
      <li v-for="(event, index) in eventList" :key="index">
        Name: {{ event.bookName }}, 
        Note: {{event.note}} ,Catagoty: {{ event.eventCatagoryName }} 
        Start Time: {{ event.startTime }},
      </li>
    </ul> -->
</template>
 
<style>

</style>