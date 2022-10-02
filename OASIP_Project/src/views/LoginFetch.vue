<script setup>
import { ref } from "vue";
import UserLogin from "../components/UserLogin.vue";
import { useRouter } from "vue-router"

const emailNotfound = ref(false);
const emailNotMatch = ref(false);
const userStore = ref({});
const appRouter = useRouter();
const goUser = () => appRouter.push({name: 'User'})

const LocalStorage = (name, accessToken) => {
  console.log(accessToken)
  localStorage.setItem(name, `${accessToken}`)
}



const userLogin = async (UserEmail, UserPassword) => {
  console.log(UserEmail);
  emailNotfound.value = false
  const res = await fetch(`http://localhost:8080/api/users/login`, {
    method: "POST",
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      email: UserEmail,
      password: UserPassword
      
    },
    localStorage.setItem('email',`${UserEmail}`))
    
  });
 
  if (res.status === 200 || res.status === 201) {
    alert("Password Matched");
    const jwttoken = await res.json()
    LocalStorage('token',jwttoken.accessToken)
    LocalStorage('refreshToken',jwttoken.refreshToken)
    goUser();
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
