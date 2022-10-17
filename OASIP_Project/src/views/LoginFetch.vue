<script setup>
import { ref } from "vue";
import UserLogin from "../components/UserLogin.vue";
import { useRouter } from "vue-router"

const emailNotfound = ref(false);
const emailNotMatch = ref(false);
const userStore = ref({});
const appRouter = useRouter();
const goHome = () => appRouter.push({name: 'Home'})

const LocalStorage = (name, accessToken) => {
  localStorage.setItem(name, `${accessToken}`)
}

function parseJwt(token) {
  var base64Url = token.split('.')[1]
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/')
  var jsonPayload = decodeURIComponent(
    window
      .atob(base64)
      .split('')
      .map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2)
      })
      .join('')
  )
  return JSON.parse(jsonPayload)
}

const pushRole = (accessToken) => {
  let role = null
  role = parseJwt(accessToken)
  localStorage.setItem('role', `${role.Roles}`
  )
}


const userLogin = async (UserEmail, UserPassword) => {
  console.log(UserEmail);
  emailNotfound.value = false
  const res = await fetch(`http://localhost:8080/api/users/login`, {
    method: 'POST',
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
    pushRole(jwttoken.accessToken)
    goHome();
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
