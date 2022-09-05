<script setup>
import { ref } from "vue";
import UserLogin from "../components/UserLogin.vue";

const emailNotfound = ref(false);
const emailNotMatch = ref(false);
const userStore = ref({});

const userLogin = async (UserEmail, UserPassword) => {
  console.log(UserEmail);
  emailNotfound.value = false
  const res = await fetch(`http://localhost:8080/api/users/match`, {
    method: "POST",
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      email: UserEmail,
      password: UserPassword
    })
  });
  if (res.status === 200) {
    alert("Password Matched");
    location.reload()
    // window.open("http://localhost:3000/or6/#/user");
  } else if (res.status === 404) {
    emailNotfound.value = true
  } else if (res.status === 401) {
    emailNotMatch.value = true
  }
};
</script>

<template>
  <UserLogin @userLogin="userLogin" :userStore="userStore" :emailNotfound="emailNotfound" :emailNotMatch="emailNotMatch"/>

  
</template>

<style></style>
