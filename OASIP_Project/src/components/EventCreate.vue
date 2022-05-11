<script setup>
import { ref, computed } from 'vue'
defineEmits(['createSchedule'])
const props = defineProps({
    eventCreate:{
        type: Object,
    }
})

const newSchedule = computed(() => {
  return {
    id: props.eventCreate.id,
    bookingName: props.eventCreate.bookingName,
    bookingEmail: props.eventCreate.bookingEmail,
    startTime: props.eventCreate.startTime,
    note: props.eventCreate.note,
    categoryId: props.eventCreate.categoryId
  }
})
console.log(newSchedule.value)
</script>

<template>
<h2>Create Schudule</h2>
    <!-- Note Detail: <input type="text" v-model="eventCreate.noteDetail" /> -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
 >
  Launch demo modal
</button>
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        name:<input type="text" v-model="newSchedule.id" /> <br/>
        
        <button @click="$emit('createSchedule',newSchedule.id)">Create</button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


  
</template>




<style></style>