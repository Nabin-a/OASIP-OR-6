<script setup>
import { ref, onBeforeMount } from "vue";
import { useRouter } from "vue-router"
import UserRegister from "../components/UserRegister.vue";

const users1 = ref([]);
const validate = ref(false)
const appRouter = useRouter();
const goUser = () => appRouter.push({name: 'User'})

let token = localStorage.getItem('token')

const createNewUser = async (
  newUserName,
  newUserEmail,
  newUserPassword,
  newUserRole,
  confirmPassword
) => {
  if(newUserPassword === confirmPassword 
  );
  const res = await fetch(`http://localhost:8080/api/users/register`, {
    method: "POST",
    headers: {
      "content-type": "application/json;",
    },
    body: JSON.stringify({
      name: newUserName,
      email: newUserEmail,
      password: newUserPassword,
      role: newUserRole
    })
  });
 
  if (res.status === 201) {
    goUser();
    alert("Added sucessfully");
    const addedUser = await res.json();
    users1.value.push(addedUser)

  } else if (res.status === 400) {
    validate.value = true
  } else {
        console.log("error, cannot be added");
  }
};

</script>
 
<template>
    <UserRegister 
    @createUser="createNewUser"
    :userRegister="users1"
    :validate="validate"/>

</template>
 
<style>

</style>