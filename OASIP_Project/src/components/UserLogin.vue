<script setup>
import { ref, computed } from "vue";
defineEmits(["userLogin"]);
const props = defineProps({
  userStore: {
    type: Object,
    default: {}
  },
  emailNotfound: {
    type: Boolean,
    default: false
  },
  emailNotMatch: {
    type: Boolean,
    default: false
  }
  
});
const userLogin = computed(() => {
  return {
    userId: props.userStore.userId,
    email: props.userStore.email,
    password: props.userStore.password
  };
});


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
                <form  @submit.prevent="submit">
                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                    Sign into your account
                  </h5>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="form2Example17"
                      >Email address</label
                    >
                    <input
                      type="email"
                      id="form2Example17"
                      class="form-control form-control-lg"
                      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                      minlength="1"
                      maxlength="50"
                      v-model="userLogin.email"
                      required
                    />
                    
                    <p class="text-danger" v-show="emailNotfound">Email not found</p>
                  </div>
                    
                  <label class="form-label" for="form2Example27"
                      >Password</label
                    >
                  <div class="form-outline mb-4">
                    <input
                      type="password"
                      id="form2Example27"
                      class="form-control form-control-lg"
                      v-model="userLogin.password"
                      minlength="8"
                      maxlength="14"
                      required
                    />
                    
                    <p class="text-danger" v-show="emailNotMatch">Password incorrect</p>
                  </div>

                  <div class="pt-1 mb-4">
                    <button
                      class="btn btn-dark btn-lg btn-block"
                      type="submit"
                      @click="
                        $emit('userLogin', userLogin.email, userLogin.password)
                      "
                    >
                      Login
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
