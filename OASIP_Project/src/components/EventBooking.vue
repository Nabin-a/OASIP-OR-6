<script setup>
import { ref, computed } from "vue";
defineEmits(["createSchedule", "updateEvent","uploadFile"]);
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
    note: props.eventCreate.note,
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

const fileName = ref("");
const resFiles = ref(false);
const sizeCheck = () => {
  if (document.getElementById("fileupload").files[0].size / 1024 / 1024 > 10) {
    resFiles.value = true;

    alert("file size should be less than 10MB!");
  } else {
    fileName.value = document.getElementById("fileupload").files[0].name;
  }
};

const clearFile = () => {
  document.getElementById("fileupload").value = "";
  fileName.value = "";
};



let email = localStorage.getItem("email");
let token = localStorage.getItem("token");
let role = localStorage.getItem("role");

const emailErr = ref(0);
const ValidateEmail = (email) => {
  return email == ""
    ? (emailErr.value = 0)
    : /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,24}))$/.test(
        email
      )
    ? (emailErr.value = 1)
    : (emailErr.value = 2);
};


</script>

<template>
  <div class="container">
    <div class="row d-flex justify-content-center">
      <div class="col col-xl-6">
        <div class="card" style="border-radius: 2rem">
          <div class="row g-0">
            <div class="col-md-6 d-none d-md-block"></div>
            <div class="col-md-6 col-lg-12 d-flex">
              <div class="container2 card-body p-4 p-lg-5 text-black">
                <form @submit.prevent="submit">
                  <h3 class="fw-normal mb-3 pb-1" style="letter-spacing: 1px">
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
                      @keyup="ValidateEmail(newSchedule.bookingEmail)"
                      minlength="1"
                      maxlength="45"
                      required
                    />
                    <div class="text-danger" v-if="emailErr == 2">
                      Your pattern not correctly.
                    </div>
                  </div>
                  <div
                    class="form-outline mb-4"
                    v-else-if="role === 'ROLE_admin'"
                  >
                    <input
                      type="email"
                      class="form-control"
                      id="countEmail"
                      placeholder="user@example.com"
                      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                      v-model="newSchedule.bookingEmail"
                      @keyup="ValidateEmail(newSchedule.bookingEmail)"
                      minlength="1"
                      maxlength="45"
                      required
                    />
                    <div class="text-danger" v-if="emailErr == 2">
                      Your pattern not correctly.
                    </div>
                  </div>
                  <div class="form-outline mb-4" v-else>
                    <input
                      type="email"
                      class="form-control"
                      id="countEmail"
                      placeholder="user@example.com"
                      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                      v-model="newSchedule.bookingEmail"
                      @keyup="ValidateEmail(newSchedule.bookingEmail)"
                      minlength="1"
                      maxlength="45"
                      required
                      disabled
                    />
                    <div class="text-danger" v-if="emailErr == 2">
                      Your pattern not correctly.
                    </div>
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
                  <div class="row g-4">
                    <div class="form-group col-md-9">
                      <label for="inputCategory">Event Category</label>

                      <select
                        id="inputCategory"
                        class="form-control"
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
                    </div>
                    <div class="invalid-feedback">Please select category.</div>

                    <div class="form-group col-md-3">
                      <label for="inputDuration">Durations</label>
                      <input
                        class="form-control"
                        type="number"
                        disabled
                        v-model="eventCategorySelect.durations"
                        required
                        id="inputDuration"
                      />
                      <div class="invalid-feedback">
                        Please select category.
                      </div>
                    </div>
                  </div>
                  <br />
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
                    ></textarea>
                  </div>
                  <p>Attachment file</p>
                  <hr />

                  <label for="fileupload" class="file-label-area">
                    <input
                      class="file-upload-input"
                      @change="sizeCheck()"
                     
                      id="fileupload"
                      type="file"
                      
                    />
                    <div class="text-file">
                      <p>Drop files here or Browse</p>
                    </div>
                  </label>

                  <div class="row mt-3" v-if="fileName != '' ">
                    <div class="col">
                      
                      <p>{{ fileName }}</p>

                    </div>

                    <div class="col col-lg-1" @click="clearFile()">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="16"
                        height="16"
                        fill="currentColor"
                        class="bi bi-x-square-fill pointer"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"
                        />
                      </svg>
                    </div>
                  </div>
                  <div class="footer">
                    <button
                      type="submit"
                      class="btn btn-primary col-xl-12"
                      @click="
                        $emit(
                          'uploadFile',
                          newSchedule.bookingName,
                          newSchedule.bookingEmail,
                          datetime,
                          eventCategorySelect.durations,
                          eventCategorySelect.id,
                          newSchedule.note,
                          fileName
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

<style>
.form-control {
  outline: none;
  border: none;
  border-bottom: 1px solid blue;
  border-radius: 0%;
}

:focus::-webkit-input-placeholder {
  transition: text-indent 1s 0.1s ease;
  text-indent: -100%;
  opacity: 1;
}

input[type="text"]:disabled {
  background: #f1f1f1;
}

.footer {
  margin-top: 20px;
}

.container2 {
  margin-left: 40px;
  height: 550px;
  display: flex;
  flex-wrap: wrap;
  position: relative;
  overflow: auto;
  border-radius: 50px;
}

.container2::-webkit-scrollbar {
  width: 6px;
}

.container2::-webkit-scrollbar-track {
  background: #fcfcfc;
  margin: 50px;
}

.container2::-webkit-scrollbar-thumb {
  background: #b2d7e1;

  border-radius: 50px;
}

.container2::-webkit-scrollbar-thumb:hover {
  background: #97e1a7;
}

input[type="number"]:disabled {
  background: #ffffff;
}

.file-upload-input {
  position: absolute;
  outline: none;
  opacity: 0;
  cursor: pointer;
}

.pointer {
  cursor: pointer;
}

.file-label-area {
  background-color: #d6d6d6;
  cursor: pointer;
  border-radius: 4px;
  padding-right: 32%;
}

.text-file {
  margin: 10px 0px 0px 125px;
  flex-wrap: nowrap;
  color: rgb(95, 95, 95);
}

.file-label-area:hover {
  background-color: #f8b5f5;
  transition: 0.3s;
}

.file-label-area:hover > .text-file {
  transition: 0.3s;
  color: rgba(255, 0, 0, 0.615);
}
</style>
