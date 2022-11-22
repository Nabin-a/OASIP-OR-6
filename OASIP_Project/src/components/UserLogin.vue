<script setup>
import { ref, computed } from "vue";
import { useRouter } from "vue-router"; 

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

const appRouter = useRouter();

const goRegister = () => appRouter.push({ name: "Register" });

const checkPasswordLength = ref(true);
const validateLength = () => {
  if (userLogin.value.password.length < 8) {
    checkPasswordLength.value = false;
  } else checkPasswordLength.value = true;
};

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
                <form  @submit.prevent="submit">
                  <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                    Sign in
                  </h3>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="email"
                      >Email address</label
                    >
                    <input
                      type="email"
                      id="email"
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
                      v-on:input="validateLength()"
                      minlength="8"
                      maxlength="14"
                      required
                    />
                    
                    <p class="text-danger" v-show="emailNotMatch">Password incorrect</p>
                  </div>

                  <div class="pt-1 mb-4">
                    <button
                      class="btn btn-primary btn-lg btn-block col-xl-12"
                      type="submit"
                      :disabled="checkPasswordLength == false"
                      @click="
                        $emit('userLogin', userLogin.email, userLogin.password)
                      "
                    >
                      Login
                    </button>
                  </div>
                </form>
                <!-- <div>
                  <small>No Account? </small><small class="pointer text-primary" @click="goRegister()">Create One!</small>
                </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.pointer{
  cursor: pointer;
}

</style>
