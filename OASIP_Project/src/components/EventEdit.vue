<script setup>
import moment from 'moment'
defineProps({
    currentEvent:{
        type: Object,
    }
})
</script>
 
<template>
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <ul class="list-group">
            <li class="list-group-item">Date : {{moment(currentEvent.startTime).format('l')}}</li>
            <li class="list-group-item">Time : {{moment(currentEvent.startTime).format('kk:m')}} PM</li>
            <li class="list-group-item">Durations : {{currentEvent.durations}} mins</li>
            <li class="list-group-item">Category : {{currentEvent.category}}</li>
            <li class="list-group-item">Booker : {{currentEvent.bookingName}}</li>
            <li class="list-group-item">Email : {{currentEvent.bookingEmail}}</li>
            <li class="list-group-item">Note : {{currentEvent.note}}</li>
        </ul>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
</template>
 
<style>

</style>