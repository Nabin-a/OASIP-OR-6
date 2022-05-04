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
<<<<<<< HEAD
<div class="container pt-3 pb-5">
<h2>Scheduled Events</h2>
<p v-if="eventList.length < 1">No schedule events</p>
  <table class ="table table-dark table-hover table-bordered table-striped" v-else>
    <thead>
       <tr>
=======
<h2>Event List</h2>
<h1 v-if="eventList.length < 1">No schedule events</h1>
  <table v-else class="table table-dark table-hover">
    <thead>
        <tr>
          <th scope="row"></th>
>>>>>>> f21dbc83c0999dc0f95e39ca7f2a095cb56e0b1c
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
<<<<<<< HEAD
          <th scope="col">Duration</th>
          <th scope="col" style="padding-left:18px">ooo</th>
=======
          <th scope="col">Duration</th>c
>>>>>>> f21dbc83c0999dc0f95e39ca7f2a095cb56e0b1c
        </tr>
      </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
<<<<<<< HEAD
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
=======
      <tr>
        <th scope="row"></th>
        <td>{{event.bookingName}}</td>
        <td>{{event.category}}</td>
        <td>{{moment(event.startTime).format('l')}}</td>
        <td>{{moment(event.startTime).format('LT')}}</td>
        <td>{{event.durations}}</td>
      </tr>
>>>>>>> f21dbc83c0999dc0f95e39ca7f2a095cb56e0b1c
    </tbody>
  </table>
  </div>
</template>
 
<style>





</style>