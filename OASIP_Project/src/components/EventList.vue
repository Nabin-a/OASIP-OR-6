<script setup>

import moment from 'moment'
import { ref,computed } from 'vue'

defineProps({
  eventList: {
    type: Array,
    require: true
  }
})
const hiding = ref(false)
const show = () =>{
  hiding.value = true

}



// const Detail = computed(() => {
//     return {
//     id: props.eventList.id,
//     bookingName: props.eventList.bookingName,
//     zzz:props.eventList.bookingEmail}
// })

</script>

<template>
  <div class="container pt-3 pb-5">
    <h2>Scheduled Events</h2>
    <p v-if="eventList.length < 1">No schedule events</p>
    <table
      class="table table-dark table-striped table-hover" 
      v-else
    >
      <thead>
        <tr>
          <th scope="col">Booking Name</th>
          <th scope="col">Catagory</th>
          <th scope="col">Start Date</th>
          <th scope="col">Start Time</th>
          <th scope="col">Duration</th>
          <th scope="col" style="padding-left: 18px">ooo</th>
        </tr>
      </thead>
    <tbody v-for="(event, index) in eventList" :key="index">
    <tr>
      <td scope="col">{{event.bookingName}}</td>
      <td scope="col">{{event.category}}</td>
      <td scope="col">{{moment(event.startTime).format('l')}}</td>
      <td scope="col">{{moment(event.startTime).format('kk:m')}}</td>
      <td scope="col">{{event.durations}} mins</td>
      <td>

        
  <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#Modal" @click="$emit('getEventId', event.id)">
  Detail
</button>


    
      </td>
      </tr>
      </tbody>
      </table>

<div class="container">
  <h2 class="py-2">Datepicker in Bootstrap 5</h2>
  <form class="row">
    <label for="date" class="col-1 col-form-label">Date</label>
    <div class="col-5">
      <div class="input-group date" id="datepicker">
        <input type="text" class="form-control" id="date"/>
        <span class="input-group-append">
          <span class="input-group-text bg-light d-block">
            <i class="fa fa-calendar"></i>

          </span>
        </span>
        
        
      </div>
    </div>
  </form>
</div>

    
  




  </div>
</template>

<style>


</style>
