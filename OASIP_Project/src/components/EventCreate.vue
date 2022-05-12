<script setup>
import { ref, computed } from "vue";
defineEmits(["createSchedule"]);
const props = defineProps({
  eventCreate: {
    type: Object,
    default: {}
  },
  eventCategory: {
    type: Array
  }
});

const newSchedule = computed(() => {
  return {
    id: props.eventCreate.id,
    bookingName: props.eventCreate.bookingName,
    bookingEmail: props.eventCreate.bookingEmail,
    note: props.eventCreate.note
  };
});
console.log(newSchedule.value);

const datetime = computed(() => {
  if (startTime.value) {
    const temp = new Date(startTime.value);
    return temp.toISOString();
  }
});

const eventCategorySelect = ref({});

const startTime = ref();
</script>

<template>
<div class="container">
  <h2>Create Schudule</h2>
  <!-- Button trigger modal -->
  <button
    type="button"
    class="btn btn-success"
    data-bs-toggle="modal"
    data-bs-target="#exampleModal"
  >
    <i class="fa fa-plus"></i>
  </button>

  <!-- Modal -->
  <div
    class="modal fade"
    id="exampleModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Create Schedule</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <form>
            <div>
              <ul>
              <li class="list-group-item">name: <input type="text" class="form-control" v-model="newSchedule.bookingName" /></li>
              <br />
              <li class="list-group-item">email: <input type="text" class="form-control" v-model="newSchedule.bookingEmail" /></li>
              <br />
              <li class="list-group-item">startTime: <input type="datetime-local" class="form-control" v-model="startTime" /></li>
              <br />
              <li class="list-group-item">category: <select class="form-select form-select-lg mb-3" v-model="eventCategorySelect">
                <option
                  v-for="eventcat in props.eventCategory"
                  :value="{
                    durations: eventcat.durationMin,
                    id: eventcat.eventCategoryId
                  }"
                >
                  {{ eventcat.categoryName }}
                </option>
              </select>
              </li>
              <br />
              <li class="list-group-item">
              durations: <input class="form-control"
                type="number"
                disabled
                v-model="eventCategorySelect.durations"
              />
              </li>
              <br/>
              <li class="list-group-item">
              note: <input class="form-control"
                type="text"
                v-model="newSchedule.note"
              />
              </li>
              </ul>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            Close
          </button>
          <button
            type="submit"
            class="btn btn-success"
            @click="
              $emit(
                'createSchedule',
                newSchedule.bookingName,
                newSchedule.bookingEmail,
                datetime,
                eventCategorySelect.durations,
                eventCategorySelect.id,
                newSchedule.note
              )
            "
          >
            Create
          </button>
        </div>
      </div>
    </div>
  </div>
  </div>

  
</template>

<style></style>
