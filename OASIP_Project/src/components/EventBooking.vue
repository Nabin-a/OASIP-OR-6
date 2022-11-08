<script setup>
import { ref, computed } from "vue";
import moment from "moment";
defineEmits(["createSchedule", "updateEvent"]);
const props = defineProps({
  eventCategory: {
    type: Array
  },
  eventCreate: {
    type: Object,
    default: {}
  }
});

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

const eventCategorySelect = ref({});


let email = localStorage.getItem("email");
let token = localStorage.getItem("token");

let role = localStorage.getItem("role");
</script>

<template>
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center">
      <div class="col col-xl-5">
        <div class="card" style="border-radius: 1rem">
          <div class="row g-0">
            <div class="col-md-6 d-none d-md-block"></div>
            <div class="col-md-6 col-lg-12 d-flex">
              <div class="card-body p-4 p-lg-5 text-black">
                <form @submit.prevent="submit">
                  <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                    Reservation Information
                  </h3>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="countChar">Name</label>
                    <input
                      type="text"
                      class="form-control"
                      id="countChar"
                      placeholder="Enter your name"
                      v-model="newSchedule.bookingName"
                      rule:unique
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
                  </div>

                  <label class="form-label" for="form2Example27">Email</label>
                  <div class="form-outline mb-4" v-if="token == null">
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
                  </div>
                  <div class="form-outline mb-4" v-else>
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
                      disabled
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
                  </div>

                  <label class="form-label" for="form2Example27"
                    >startTime</label
                  >
                  <div class="input-group">
                    <input
                      type="datetime-local"
                      class="form-control"
                      v-model="startTime"
                      :min="new Date(isodate).toISOString().slice(0, 16)"
                      required
                    />
                    <div class="invalid-feedback">Date must be future.</div>
                  </div>
                  <br />
                  <div class="pt-1 mb-4">
                    Event Category :
                    <select
                      class="form-select form-select-lg mb-3"
                      v-model="eventCategorySelect"
                      required
                    >
                      <option
                        v-for="eventcat in props.eventCategory"
                        :value="{
                          durations: eventcat.durationMin,
                          id: eventcat.categoryId
                        }"
                      >
                        {{ eventcat.categoryName }}
                      </option>
                    </select>
                    <div class="invalid-feedback">Please select category.</div>
                    <div class="pt-1 mb-4">
                      durations:
                      <input
                        class="form-control"
                        type="number"
                        disabled
                        placeholder="durations"
                        v-model="eventCategorySelect.durations"
                        required
                      />
                      <div class="invalid-feedback">
                        Please select category.
                      </div>
                    </div>
                    <label class="form-label" for="form2Example27">Email</label>
                    <div class="form-outline mb-4">
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
                    </div>
                  </div>

                  <div class="pt-1 mb-4">
                    <button
                      type="submit"
                      class="btn btn-primary col-xl-12"
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
                      Submit
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
