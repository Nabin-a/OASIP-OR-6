<script setup>
import { ref } from "vue";
import UserMatch from "../components/UserMatch.vue";
import { useRouter } from "vue-router"

const emailNotfound = ref(false);
const emailNotMatch = ref(false);
const userStore = ref({});
const appRouter = useRouter();
const goUser = () => appRouter.push({name: 'User'})

const userMatch = async (UserEmail, UserPassword) => {
  console.log(UserEmail);
  emailNotfound.value = false
  const res = await fetch(`http://localhost:8080/api/users/match`, {
    method: 'POST',
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      email: UserEmail,
      password: UserPassword
      
    }
    )
    
  });
 
  if (res.status === 200 || res.status === 201) {
    alert("Password Matched");
    goUser();
    
  } else if (res.status === 404) {
    emailNotfound.value = true
  } else if (res.status === 401) {
    emailNotMatch.value = true
  } 
  
};
</script>
 
<template>
<UserMatch @userMatch="userMatch" :userStore="userStore" :emailNotfound="emailNotfound" :emailNotMatch="emailNotMatch" />
</template>
 
<style>

</style>