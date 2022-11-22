<script setup>
import { ref, computed } from "vue";
import moment from "moment";
defineEmits(["updateUser"]);
const props = defineProps({
  userCreate: {
    type: Object,
    default: {}
  },
  currentUser: {
    type: Object,
    default: {}
  },
  validateUnique: {
    type: Boolean,
    default: false
  }
});

const roles = ref(["student", "admin", "lecturer"]);

const editUser = computed(() => {
  return {
    userId: props.userCreate.userId,
    name: props.userCreate.name,
    email: props.userCreate.email
  };
});



const checkNameMatch = ref(true);
const validateName = () => {
  if (props.currentUser.name == editUser.value.name.trim()) {
    checkNameMatch.value = false;
  } else checkNameMatch.value = true;
};

const checkEmailMatch = ref(true);
const validateEmail = () => {
  if (props.currentUser.email == editUser.value.email.trim()) {
    checkEmailMatch.value = false;
  } else checkEmailMatch.value = true;
};

const emailErr = ref(0);
const ValidateEmailPat = (email) => {
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
          <h5 class="modal-title" id="EditModalLabel">Edit User</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <form @submit.prevent="submit">
            <ul class="list-group">
              <li class="list-group-item">
                Name:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentUser.name"
                  v-on:input="validateName()"
                />
              </li>
              <br />
              <li class="list-group-item">
                Name:
                <input
                  type="text"
                  class="form-control"
                  minlength="1"
                  maxlength="100"
                  v-model="editUser.name"
                  required
                  v-on:input="validateName()"
                />
                <p class="text-danger" v-show="validateUnique">
                  Name must be unique
                </p>
              </li>

              <br />
              <li class="list-group-item">
                User Email:
                <input
                  type="email"
                  class="form-control"
                  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                  disabled
                  v-model="currentUser.email"
                  v-on:input="validateEmail()"
                />
              </li>
              <br />
              <li class="list-group-item">
                User Email:
                <input
                  type="email"
                  class="form-control"
                  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                  v-model="editUser.email"
                  minlength="1"
                  maxlength="50"
                  required
                  v-on:input="validateEmail()"
                  @keyup="ValidateEmailPat(editUser.email)"
                />
                <p class="text-danger" v-show="validateUnique">
                  Email must be unique and checking well-formed.
                </p>
                <div class="text-danger" v-if="emailErr == 2">
                      Your pattern not correctly.
                    </div>
              </li>

              <br />

              <li class="list-group-item">
                Choose user role:
                <br />
                <div v-for="role in roles">
                  <input
                    type="radio"
                    v-model="currentUser.role"
                    name="roleEdit"
                    :value="role"
                  />
                  {{ role }}
                </div>
              </li>
              <br />
              <li class="list-group-item">
                createdOn :
                {{ moment(currentUser.createdOn).format("YYYY/MM/DD HH:mm") }}
              </li>
              <br />
              <li class="list-group-item">
                updatedOn :
                {{ moment(currentUser.updatedOn).format("YYYY/MM/DD HH:mm") }}
              </li>
            </ul>
            <div class="modal-footer">
              <button
                type="submit"
                class="btn btn-success"
                :disabled="checkNameMatch == false || checkEmailMatch == false"
                @click="
                  $emit(
                    'updateUser',
                    currentUser.userId,
                    editUser.name,
                    editUser.email,
                    currentUser.role
                  )
                "
              >
                Edit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
