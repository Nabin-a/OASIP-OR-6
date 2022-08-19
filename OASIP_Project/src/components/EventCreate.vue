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

const checkValidation = (e)=>{
  e.target.classList.add("was-validated");
}

const newSchedule = computed(() => {
  return {
    id: props.eventCreate.id,
    bookingName: props.eventCreate.bookingName,
    bookingEmail: props.eventCreate.bookingEmail,
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

const eventCategorySelect = ref({});

const eventStartTimeEdit = computed(() => {
  if (props.currentEvent.startTime != null) {
    return moment(props.currentEvent.startTime).format("YYYY-MM-DDTHH:mm");
  }
});




</script>

<template>
  <div class="container pt-3 pb-5">
    <h2 style="color: white">Create Schudule</h2>
    <br/>
    <button
      type="button"
      class="btn btn-success"
      data-bs-toggle="modal"
      data-bs-target="#CreateModal"
    >
      <i class="fa fa-plus"></i>
    </button>

    <div
      class="modal fade"
      id="CreateModal"
      tabindex="-1"
      aria-labelledby="CreateModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header bg-dark">
            <h5 class="modal-title" id="CreateModalLabel">Create Schedule</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <form class="needs-validation" novalidate>
              <div>
                <ul>
                  <li class="list-group-item">
                    <label for="countChar" class="form-label">Name:</label>
                    <input
                      type="text"
                      class="form-control"
                      id="countChar"
                      placeholder="Enter your name"
                      v-model="newSchedule.bookingName"
                      minlength="1"
                      maxlength="100"
                      required
                    />
                    <div class="invalid-feedback">Name must not be blank.</div>
                    <small>
                      <div class="form-text">
                        <span id="current_count">0</span>
                        <span id="maximum_count">/ 100</span>
                      </div>
                    </small>
                  </li>
                  <br />
                  <li class="list-group-item">
                    Email:
                    <input
                      type="email"
                      class="form-control"
                      id="countEmail"
                      placeholder="user@example.com"
                      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                      v-model="newSchedule.bookingEmail"
                      minlength="1"
                      maxlength="45"
                      required
                    />
                    <div class="invalid-feedback">
                      Your pattern not correctly.
                    </div>
                    <small>
                      <div class="form-text">
                        <span id="current_email">0</span>
                        <span id="maximum_email">/ 45</span>
                      </div>
                    </small>
                  </li>
                  <br />
                  <li class="list-group-item">
                    startTime:
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
                    Choose event category:
                    <select
                      class="form-select form-select-lg mb-3"
                      v-model="eventCategorySelect"
                      required
                    >
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
                    <div class="invalid-feedback">Please select category.</div>
                  </li>
                  <br />
                  <li class="list-group-item">
                    durations:
                    <input
                      class="form-control"
                      type="number"
                      disabled
                      placeholder="durations"
                      v-model="eventCategorySelect.durations"
                      required
                    />
                  </li>
                  <br />
                  <li class="list-group-item">
                    note:
                    <textarea
                      class="form-control"
                      type="text"
                      id="countNote"
                      placeholder="detail..."
                      v-model="newSchedule.note"
                      minLength="0"
                      maxlength="500"
                      required
                    ></textarea>
                    <small>
                      <div class="form-text">
                        <span id="current_note">0</span>
                        <span id="maximum_note">/ 500</span>
                      </div>
                    </small>
                  </li>
                </ul>
                <div style="margin-left:66%">
                 <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              Close
            </button>
             &nbsp
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
                  newSchedule.note,
                )
              "
            >
              Create
            </button>
            </div>
              </div>
            </form> 
          </div>
        </div>
      </div>
    </div>
  </div>

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
          <form class="was-validated">
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
