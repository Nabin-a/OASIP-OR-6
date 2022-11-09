<script setup>
import { useRouter } from "vue-router"
import { ref, computed } from "vue";
defineEmits(["getUserid", "removeUser","createUser"]);
const props = defineProps({
  userList: {
    type: Array,
    require: true
  },
  userRegister: {
    type: Object,
    default: {}
  },
  validate: {
    type: Boolean,
    default: false
  }
});

const newUser = computed(() => {
  return {
    userId: props.userRegister.userId,
    name: props.userRegister.name,
    email: props.userRegister.email,
    password: props.userRegister.password
  };
});

const roles = ref(["student", "admin", "lecturer"]);

const userRoleSelect = ref();

const showPassword1 = ref(false);
const showPassword = ref(false);

const confirmPassword = ref();

const checkPasswordMatch = ref(true);
const validatePassword = () => {
  if (confirmPassword.value != newUser.value.password) {
    checkPasswordMatch.value = false;
  } else checkPasswordMatch.value = true;
};


let token = localStorage.getItem("token");
let role = localStorage.getItem("role");
</script>

<template>
  <h1 v-if="userList.length < 1" class="forusl">No users</h1>
  <!-- <table class="table table-danger table-striped table-hover" v-else>
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
          <th scope="col" style="padding-left: 7.5%">ooo</th>
        </tr>
      </thead>
      <tbody v-for="(user, index) in userList" :key="index">
        <tr>
          <td scope="col">{{ user.name }}</td>
          <td scope="col">{{ user.email }}</td>
          <td scope="col">{{ user.role }}</td>
          <td style="padding-left: 2%">
            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#DetailModal"
              @click="$emit('getUserid', user.userId)"
            >
              <i class="fa fa-info-circle"></i>
            </button>
            &nbsp
            <button
              class="btn btn-success"
              data-bs-target="#EditModal"
              data-bs-toggle="modal"
              @click="$emit('getUserid', user.userId)"
            >
              <i class="fa fa-edit"></i>
            </button>
            &nbsp;
            <button
              type="button"
              class="btn btn-danger"
              @click="$emit('removeUser', user.userId)"
            >
              <i class="fa fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table> -->
  <div>
    <div class="buttonAdd">
      <span
        ><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Add User
</button>
</span>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form @submit.prevent="submit">
                  
                 

                  <div class="form-outline mb-4">
                    <label class="form-label" for="countChar">Name</label>
                    <input
                      type="text"
                      class="form-control"
                      id="countChar"
                      placeholder="Enter your name"
                      v-model="newUser.name"
                      rule:unique
                      minlength="1"
                      maxlength="100"
                      required
                    />
                    <p class="text-danger" v-show="validate">
                      Name must be unique
                    </p>

                   
                  </div>

                  <label class="form-label" for="form2Example27">Email</label>
                  <div class="form-outline mb-4">
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
                    <p class="text-danger" v-show="validate">
                      Email must be unique and checking well-formed
                    </p>
                    
                  </div>

                  <div class="row g-4">
                    <div class="form-group col-md-6">
                  <label class="form-label" for="form2Example27"
                    >Password</label
                  >
                  <div class="input-group">
                    <input
                      :type="showPassword ? ' text ' : 'password'"
                      class="form-control border-end-0 border"
                      name="pwsd1"
                      id="pwsd1"
                      placeholder="need character 8 to 14"
                      v-model="newUser.password"
                      minlength="8"
                      maxlength="14"
                      required
                      v-on:input="validatePassword()"
                    />
                    <span class="input-group-append">
                      <button
                        class="btn btn-outline-secondary bg-white border-start-0 border-bottom-1 border ms-n5"
                        type="button"
                      >
                        <i
                          class="fa fa-eye"
                          aria-hidden="true"
                          @click="showPassword = !showPassword"
                        ></i>
                      </button>
                    </span>
                  </div>
                  </div>
                  <div class="invalid-feedback">need character 8 to 14.</div>

                  <div class="form-group col-md-6">
                  <label class="form-label">Confirm Password</label>
                  <div class="input-group">
                    <input
                      :type="showPassword1 ? ' text ' : 'password'"
                      name="pwsd2"
                      class="form-control border-end-0 border"
                      placeholder="Confirm password"
                      v-model="confirmPassword"
                      minlength="8"
                      maxlength="14"
                      required
                      v-on:input="validatePassword()"
                    />
                    <span class="input-group-append">
                      <button
                        class="btn btn-outline-secondary bg-white border-start-0 border-bottom-1 border ms-n5"
                        type="button"
                      >
                        <i
                          class="fa fa-eye"
                          aria-hidden="true"
                          @click="showPassword1 = !showPassword1"
                        ></i>
                      </button>
                    </span>
                  </div>
                  </div>
                  </div>
                  
                  <small v-if="!checkPasswordMatch" class="text-danger">
                    Password are not match
                  </small>
                  <br />
                  <div class="form-outline mb-4">
                    Role
                  

                    <div class="m-2">
                       
                      <select
                        id="inputRole"
                        class="form-control form-select"
                        v-model="userRoleSelect"           
                      >
                        <option
                          v-for="role in roles"
                          
                          :value="role"
                          
                        >
                          {{ role }}
                        </option>
                      </select>
                    </div>
                  </div>

                  <div class="pt-1 mb-4 ">
                    <button
                      type="submit"
                      class="btn btn-primary col-xl-12"
                      :disabled="checkPasswordMatch == false"
                      @click="
                        $emit(
                          'createUser',
                          newUser.name,
                          newUser.email,
                          newUser.password,
                          userRoleSelect,
                          confirmPassword
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

    <div class="container1 scroll">
      <div
        class="card testimonial-card"
        v-for="(user, index) in userList"
        :key="index"
      >
        <div class="card-up" style="background-color: #b4bdef">
          <div class="d-flex flex-row-reverse">
            <i
              class="fa fa-trash text-white m-2"
              @click="$emit('removeUser', user.userId)"
            ></i>
            <i
              class="fa fa-pencil text-white m-2"
              data-bs-target="#EditModal"
              data-bs-toggle="modal"
              @click="$emit('getUserid', user.userId)"
            ></i>
          </div>
        </div>
        <div class="avatar mx-auto bg-white">
          <img
            src="../assets/avatar.png"
            class="rounded-circle img-fluid image"
            data-bs-toggle="modal"
            data-bs-target="#DetailModal"
            @click="$emit('getUserid', user.userId)"
          />
        </div>
        <div class="card-body">
          <h4 class="mb-0" style="font-size: 18px">{{ user.name }}</h4>
          <hr />
          <p class="dark-grey-text mt-1">
            {{ user.email }}
          </p>
          <p class="dark-grey-text mt-1">Role - {{ user.role }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.forusl {
  margin-left: 42%;
  color: rgb(227, 70, 106);
}

.container1 {
  background-color: #cbddf6;
  margin-left: 20%;
  height: 530px;
  display: flex;
  flex-wrap: wrap;
  width: 65%;
  position: relative;
  overflow: auto;
  border-radius: 50px;
}

.container1::-webkit-scrollbar {
  width: 6px;
}

.container1::-webkit-scrollbar-track {
  background: #cbddf6;
  margin: 50px;
}

.container1::-webkit-scrollbar-thumb {
  background: #f1f1f1;

  border-radius: 50px;
}

.container1::-webkit-scrollbar-thumb:hover {
  background: #bdcde3;
}

.container1 > div {
  background-color: rgb(255, 255, 255);
  margin: 10px;
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
  width: 30%;
  border-radius: 50px;
}

.testimonial-card .card-up {
  height: 120px;
  overflow: hidden;
  border-top-left-radius: 0.25rem;
  border-top-right-radius: 0.25rem;
  border-radius: 20px;
}

.testimonial-card .avatar {
  width: 110px;
  margin-top: -60px;
  overflow: hidden;
  border: 3px solid #fff;
  border-radius: 50px;
}

.image {
  opacity: 1;
  display: block;
  transition: 0.5s ease;
  backface-visibility: hidden;
  position: relative;
}

.image:hover {
  opacity: 0.3;
  cursor: pointer;
}

.fa {
  cursor: pointer;
}

.buttonAdd {
  margin-bottom: 20px;
  margin-left:78%;
  margin-top: -20px;
  
}


</style>
