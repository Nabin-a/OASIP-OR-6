<script setup>
import { ref, computed } from "vue";
import moment from "moment";
defineEmits(["createUser", "updateUser"]);
const props = defineProps({
  userCreate: {
    type: Object,
    default: {}
  },
  currentUser: {
    type: Object,
    default: {}
  }
});

const roles = ref(["student", "admin", "lecturer"]);

const userRoleSelect = ref();

const newUser = computed(() => {
  return {
    userId: props.userCreate.userId,
    name: props.userCreate.name,
    email: props.userCreate.email,
    password: props.userCreate.password
  };
});

const nameEdit = ref();
const emailEdit = ref();

const showPassword1 = ref(false);
const showPassword = ref(false);

const confirmPassword = ref();

const checkPasswordMatch = ref(true);
const validatePassword = () => {
  if (confirmPassword.value != newUser.value.password) {
    checkPasswordMatch.value = false;
  } else checkPasswordMatch.value = true;
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
                  required
                  v-model="nameEdit"
                />
              </li>
              <br />
              <li class="list-group-item">
                Booker Email:
                <input
                  type="text"
                  class="form-control"
                  disabled
                  v-model="currentUser.email"
                />
              </li>
              <br />
              <li class="list-group-item">
                Booker Email:
                <input
                  type="email"
                  class="form-control"
                  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                  v-model="emailEdit"
                  minlength="1"
                  maxlength="50"
                  required
                />
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
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="submit"
            value="submit"
            class="btn btn-success"
            @click="
              $emit(
                'updateUser',
                currentUser.userId,
                nameEdit,
                emailEdit,
                currentUser.role
              )
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
