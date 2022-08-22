<script setup>
import { ref,computed } from "vue";
defineEmits(["createUser"])
const props = defineProps({
  userCreate: {
    type: Object,
    default: {}
  }
})

const roles = ref(['student', 'admin', 'lecturer'])

const userRoleSelect = ref({})

const newUser = computed(() => {
  return {
    userId: props.userCreate.userId,
    name: props.userCreate.name,
    email: props.userCreate.email
  };
});
</script>
 
<template>
    <div class="container pt-3 pb-5">
    <h2 style="color: white">Create User</h2>
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
            <h5 class="modal-title" id="CreateModalLabel">Create User</h5>
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
                      v-model="newUser.name"
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
                      v-model="newUser.email"
                      minlength="1"
                      maxlength="50"
                      required
                    />
                    <div class="invalid-feedback">
                      Your pattern not correctly.
                    </div>
                    <small>
                      <div class="form-text">
                        <span id="current_email">0</span>
                        <span id="maximum_email">/ 50</span>
                      </div>
                    </small>
                  </li>
                  <br />
                  <li class="list-group-item">
                    Choose user role:
                    <br />
                        <div v-for="role in roles">
                              <input type="radio" v-model="userRoleSelect" name="role" :value="role"> {{role}}
                        </div>
                  </li>
                  <br />
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
                  'createUser',
                  newUser.name,
                  newUser.email,
                  userRoleSelect
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
</template>
 
<style>

</style>