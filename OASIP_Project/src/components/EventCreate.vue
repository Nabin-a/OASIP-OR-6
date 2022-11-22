<script setup>
import { ref, computed } from "vue";
import moment from "moment";
defineEmits(["createSchedule", "updateEvent"]);
const props = defineProps({
  currentEvent: {
    type: Object,
    default: {}
  },
  eventCategory: {
    type: Array
  },
  eventCreate: {
    type: Object,
    default: {}
  }
})


const newSchedule = computed(() => {
  return {
    eventId: props.eventCreate.eventId,
    bookingName: props.eventCreate.bookingName,
    bookingEmail: email,
    note: props.eventCreate.note
  };
});

const theDate = new Date();
theDate.setHours(theDate.getHours() + 7);
theDate.setMinutes(theDate.getMinutes() + 1);
const isodate = theDate.toISOString();

const datetime = computed(() => {
  if (startTime.value) {
    const temp = new Date(startTime.value);
    return temp.toISOString();
  }
});

const startTime = ref();

const eventStartTimeEdit = computed(() => {
  if (props.currentEvent.startTime != null) {
    return moment(props.currentEvent.startTime).format("YYYY-MM-DDTHH:mm");
  }
});

let email = localStorage.getItem("email")

let role = localStorage.getItem("role");



</script>

<template>

  <div
    class="modal fade"
    id="EditModal"
    aria-hidden="true"
    aria-labelledby="EditModalLabel"
    tabindex="-1"
  >
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header bg-dark">
          <h5 class="modal-title" id="EditModalLabel">Edit Event</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <form class="was-validated" @submit.prevent="submit">
            <ul class="list-group">
              <li class="list-group-item">
                Booker:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentEvent.bookingName"
                />
              </li>
              <br />
              <li class="list-group-item">
                Booker Email:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentEvent.bookingEmail"
                />
              </li>
              <br />
              <li class="list-group-item">
                Current Time:
                <input
                  type="datetime-local"
                  class="form-control"
                  disabled
                  v-model="eventStartTimeEdit"
                />
              </li>
              <br />
              <li class="list-group-item">
                Edit Time:
                <input
                  type="datetime-local"
                  class="form-control"
                  v-model="startTime"
                  :min="new Date(isodate).toISOString().slice(0, 16)"
                  required
                />
                <div class="invalid-feedback">Date must be future.</div>
              </li>
              <br />
              <li class="list-group-item">
                Current Category:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentEvent.categoryName"
                />
              </li>
              <br />
              <li class="list-group-item">
                Durations:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentEvent.durations"
                />
              </li>
              <br />
              <li class="list-group-item">
                Note:
                <textarea
                  class="form-control"
                  type="text"
                  id="countCurNote"
                  placeholder="detail..."
                  v-model="currentEvent.note"
                  minLength="1"
                  maxlength="500"
                ></textarea>
                <small>
                  <div class="form-text">
                    <span id="current_CurNote">0</span>
                    <span id="maximum_CurNote">/ 500</span>
                  </div>
                </small>
              </li>
            </ul>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="submit"
            value="submit"
            class="btn btn-success"
            @click="
              $emit('updateEvent', currentEvent.id, datetime, currentEvent.note)
            "
          >
            Edit
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
