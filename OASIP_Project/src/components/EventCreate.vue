<script setup>
import { ref, computed } from 'vue'
defineEmits(['createSchedule'])
// const props = defineProps({
//   currentNote: {
//     type: Object,
//     default: {}
//   }
// })
// console.log(props.currentNote)
// const newNote = ref({
//   id: props.currentNote.id,
//   noteDetail: props.currentNote.noteDetail
// })
const newSchedule = computed(() => {
  return {
   
  }
})
console.log(newSchedule.value)
</script>

<template>
  <div>
    <h2>Create Schudule</h2>
    <!-- Note Detail: <input type="text" v-model="eventCreate.noteDetail" /> -->
    <button @click="$emit('createSchedule', newNote.noteDetail)">
      Create
    </button>
  </div>
</template>

<style></style>