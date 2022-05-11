<script setup>
import { ref, computed } from 'vue'
defineEmits(['createSchedule'])
const props = defineProps({
    eventCreate:{
        type: Object,
        default :{}
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

const datetime = computed(() => {
  if (newSchedule.startTime) {
    const temp = new Date(newSchedule.startTime);
    return temp.toISOString();
  }
})


</script>

<template>
<h2>Create Schudule</h2>
    <!-- Note Detail: <input type="text" v-model="eventCreate.noteDetail" /> -->
<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
 > -->
  <!-- Launch demo modal -->
<!-- </button>
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
<<<<<<< HEAD
        name:<input type="text" v-model="newSchedule.bookingName" /> <br/>
        email:<input type="text" v-model="newSchedule.bookingEmail" /> <br/>
        startTime:<input type="date" v-model="newSchedule.startTime" /> <br/>
        durations:<input type="text" v-model="newSchedule.durations" /> <br/>
        category:<input type="text" v-model="newSchedule.categoryId" /> <br/>
        
        <button @click="$emit('createSchedule',
            newSchedule.bookingName,
            newSchedule.bookingEmail,
            newSchedule.startTime,
            newSchedule.durations,
            newSchedule.categoryId
        )">Create</button>
=======
        name:<input type="text" v-model="newSchedule.BookingName" /> <br/>
        email:<input type="text" v-model="newSchedule.BookingEmail" /> <br/>
        start:<input type="text" v-model="newSchedule.startTime" /> <br/>
        note:<input type="text" v-model="newSchedule.note" /> <br/>
        <button @click="$emit('createNewSchedule', newSchedule)">Create</button>
>>>>>>> 297c06ba9a1d45f92586aa0211ab0381561031a4
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div> -->

<div>
        name:<input type="text" v-model="newSchedule.bookingName" /> <br/>
        email:<input type="text" v-model="newSchedule.bookingEmail" /> <br/>
        startTime:<input type="datetime-local" v-model="newSchedule.startTime" /> <br/>
        durations:<input type="text" v-model="newSchedule.durations" /> <br/>
        category:<input type="number" v-model="newSchedule.categoryId" />
        <!-- <option value="{{newSchedule.categoryId}}"></option>
        </select> <br/> -->
        <button type="submit" @click="$emit('createSchedule',
            newSchedule.bookingName ,
            newSchedule.bookingEmail ,
            datetime,
            newSchedule.durations ,
            newSchedule.categoryId
        )">Create</button>
</div>
      
  
</template>




<style></style>