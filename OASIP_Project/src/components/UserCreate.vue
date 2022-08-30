<script setup>
import { ref,computed } from "vue";
import moment from "moment"
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
    email: props.userCreate.email,
    password: props.userCreate.password
  };
});

const nameEdit = ref();
const emailEdit = ref();

const showPassword1 = ref(false)
const showPassword = ref(false)

const confirmPassword = ref()



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
            <form class="needs-validation" method="post" @submit.prevent="submit" 
            oninput='pwsd2.setCustomValidity(pwsd2.value != pwsd1.value ? "Passwords do not match." : "")' novalidate >
            
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
                  <br/>
                  <li class="list-group-item">
                    <label class="form-label">Password:</label>
                    
                    <input
                      :type=" showPassword ? ' text ' : 'password'"
                      class="form-control"
                      name="pwsd1"
                      id="pwsd1"
                      placeholder="need character 8 to 14"
                      v-model="newUser.password"
                      minlength="8"
                      maxlength="14"
                      required
                    />
                    <i class="fa fa-eye" aria-hidden="true" @click="showPassword = !showPassword"></i>
                    <div class="invalid-feedback">need character 8 to 14.</div>
                    </li>
                  <br />
                  <li class="list-group-item">
                    <label class="form-label">Confirm Password:</label>                      <input
                      :type=" showPassword1 ? ' text ' : 'password'"
                      name="pwsd2"
                      class="form-control"              
                      placeholder="Confirm password"
                      v-model="confirmPassword"
                      minlength="8"
                      maxlength="14"
                      required
                    />
                 
                    <i class="fa fa-eye" aria-hidden="true" @click="showPassword1 = !showPassword1"></i>
                    <div class="invalid-feedback">Password not match!.</div>
                    </li>
                    <br/>
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
             <!-- disabled="newUser.password == 8  || newUser.password !== confirmPassword" -->
            <button
              type="submit"
              class="btn btn-success"
              :disabled="confirmPassword == null  || confirmPassword !== newUser.password"
              @click="
                $emit(
                  'createUser',
                  newUser.name,
                  newUser.email,
                  newUser.password,
                  confirmPassword,
                  userRoleSelect
                 
                  
                );
              
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
          <form class="was-validated" @submit.prevent="submit">
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
                              <input type="radio" v-model="currentUser.role" name="roleEdit" :value="role"> {{role}}
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
            value="submit"
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