<script setup>
import { ref,computed } from "vue";
import moment from "moment"
import { Field, Form } from 'vee-validate';


defineEmits(["createUser","updateUser"])
const props = defineProps({
  userCreate: {
    type: Object,
    default: {}
  },
  currentUser: {
    type: Object,
    default: {}
  },
})

const roles = ref(['student', 'admin', 'lecturer'])

const userRoleSelect = ref()

const newUser = computed(() => {
  return {
    userId: props.userCreate.userId,
    name: props.userCreate.name,
    email: props.userCreate.email
  };
});

const nameEdit = ref();
const emailEdit = ref();

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
                      vee-validate="'required|unique'"
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
          <form class="was-validated">
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
                  type="text"
                  class="form-control"
                  v-model="emailEdit"
                />
              </li>
              <br />

              <li class="list-group-item">
                    Choose user role:
                    <br />
                        <div v-for="role in roles">
                              <input type="radio" v-model="currentUser.role" name="role" :value="role"> {{role}}
                        </div>
              </li>
              <br />
              <li class="list-group-item">
                createdOn : {{ moment(currentUser.createdOn).format("YYYY/MM/DD HH:mm") }}
              </li>
              <br />
              <li class="list-group-item">
                updatedOn : {{ moment(currentUser.updatedOn).format("YYYY/MM/DD HH:mm") }}
              </li>
            </ul>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="submit"
            class="btn btn-success"
            @click="
              $emit('updateUser', currentUser.userId, nameEdit, emailEdit, currentUser.role)
            "
          >
            Edit
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
 
<style>

</style>