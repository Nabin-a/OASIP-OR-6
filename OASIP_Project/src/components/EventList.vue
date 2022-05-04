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
<div class="container pt-3 pb-5">
<h2>Scheduled Events</h2>
<p v-if="eventList.length < 1">No schedule events</p>
  <table class ="table table-dark table-hover table-bordered table-striped" v-else>
    <thead>
       <tr>
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">Duration</th>
          <th scope="col" style="padding-left:18px">ooo</th>
        </tr>
      </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
    <tr>
      <td scope="col">{{event.bookingName}}</td>
      <td scope="col">{{event.eventCategoryName}}</td>
      <td scope="col">{{moment(event.startTime).format('l')}}</td>
      <td scope="col">{{moment(event.startTime).format('LT')}}</td>
      <td scope="col">{{event.durations}}</td>
      <td>
      <router-link :to="{name: 'Note',
                         params: {id: event.id}}"><button class ="btn btn-primary">Note</button>
                         
        </router-link>
      
        
      </td>
      
      
    </tr>
    </tbody>
  </table>
  </div>
</template>
 
<style>





</style>