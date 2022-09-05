<script setup>
    import { ref, computed } from "vue";
    defineEmits(["createUser"]);
    const props = defineProps({
        userRegister: {
    type: Object,
    default: {}
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
    </script>
    
    <template>
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center">
          <div class="col col-xl-10">
            <div class="card" style="border-radius: 1rem">
              <div class="row g-0">
                <div class="col-md-6 d-none d-md-block"></div>
                <div class="col-md-6 col-lg-12 d-flex">
                  <div class="card-body p-4 p-lg-5 text-black">
                    <form  @submit.prevent="submit" oninput='pwsd2.setCustomValidity(pwsd2.value != pwsd1.value ? "Passwords do not match." : "")'
              novalidate>
                      <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                        Sign into your account
                      </h5>
    
                      <div class="form-outline mb-4">
                        <label class="form-label" for="countChar"
                          >Name</label
                        >
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
                    <div class="invalid-feedback">Name must not be blank.</div>

                    <small>
                      <div class="form-text">
                        <span id="current_count">0</span>
                        <span id="maximum_count">/ 100</span>
                      </div>
                    </small>
                        
                      </div>
                        
                      <label class="form-label" for="form2Example27"
                          >Email</label
                        >
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
                    <div class="invalid-feedback">
                      Your pattern not correctly.
                    </div>
                    <small>
                      <div class="form-text">
                        <span id="current_email">0</span>
                        <span id="maximum_email">/ 50</span>
                      </div>
                    </small>
                      </div>
                      
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
                      <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-1 border ms-n5" type="button">
                    <i
                      class="fa fa-eye"
                      aria-hidden="true"
                      @click="showPassword = !showPassword"
                    ></i>
                    </button>
                    </span>
                    </div>
                    <div class="invalid-feedback">need character 8 to 14.</div>

                    <br />
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
                      <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-1 border ms-n5" type="button">
                    <i
                      class="fa fa-eye"
                      aria-hidden="true"
                      @click="showPassword1 = !showPassword1"
                    ></i>
                    </button>
                    </span>
                    </div>
                    <p
                      v-if="!checkPasswordMatch"
                      class="text-danger"
                    >
                      Password are not match
                    </p>
                    <br />
                      <div class="form-outline mb-4">
                    Choose user role:
                    <br />
                    
                    <div v-for="role in roles">
                      <input
                        type="radio"
                        v-model="userRoleSelect"
                        name="role"
                        :value="role"
                      />
                      {{ role }}
                    </div>
                </div>

                      <div class="pt-1 mb-4">
                        <button
                    type="submit"
                    class="btn btn-dark"
                    :disabled="
                      checkPasswordMatch == false
                    "
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
                    Create
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
    