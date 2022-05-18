<script setup>
import moment from 'moment'

import { ref ,computed } from "vue"
defineEmits(['updateEvent'])
defineProps({
    eventDetail:{
        type: Object,
    }
})

</script>
 
<template>
    <div>
        <div class="modal fade" id="Modal" tabindex="-1" aria-labelledby="ModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                     <h4 class="modal-title" id="ModalLabel">Detail of {{eventDetail.bookingName}}</h4>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
      <div class="modal-body">
        <ul class="list-group">
            <li class="list-group-item">Date : {{moment(eventDetail.startTime).format('l')}}</li>
            <li class="list-group-item">Time : {{moment(eventDetail.startTime).format('kk:m')}} PM</li>
            <li class="list-group-item">Durations : {{eventDetail.durations}} mins</li>
            <li class="list-group-item">Category : {{eventDetail.category}}</li>
            <li class="list-group-item">Booker : {{eventDetail.bookingName}}</li>
            <li class="list-group-item">Email : {{eventDetail.bookingEmail}}</li>
            <li class="list-group-item">Note : {{eventDetail.note}}</li>
        </ul>
      </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
  <i class="fa fa-info-circle"></i>
          </button>
          </div>
      </div>
    </div>
  </div>
</div>

              <!-- <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel2">Edit Event</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <ul class="list-group">
            <li class="list-group-item">startTime: <input type="datetime-local" class="form-control" v-model="startTime" /></li>
              <br /> 
            <li class="list-group-item">Durations : {{eventDetail.durations}} mins</li>
            <li class="list-group-item">Category : {{eventDetail.category}}</li>
            <li class="list-group-item">Booker : {{eventDetail.bookingName}}</li>
            <li class="list-group-item">Email : {{eventDetail.bookingEmail}}</li>
            <li class="list-group-item">Note : <textarea class="form-control" v-model="eventDetail.note"></textarea></li>
        </ul>
      </div>
      <div class="modal-footer">
        <button
            type="submit"
            class="btn btn-success"
            @click="
              $emit(
                'updateEvent',
                datetime,
                eventDetail.note
              )
            "
          >
            Create
          </button>
          <a class="btn btn-danger" data-bs-toggle="modal" href="#Modal" role="button">Back</a> -->
      <!-- </div>
    </div>
  </div>
</div> -->


        





    
</template>
 
<style>
.modal-header {
  background-color: #6666FF;
  color: white;
}

li {
    font-size:20px
}
</style>