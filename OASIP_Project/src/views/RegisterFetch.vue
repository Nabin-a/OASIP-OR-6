<script setup>
import { ref, onBeforeMount } from "vue";
import UserRegister from "../components/UserRegister.vue";

const users = ref([]);

const createNewUser = async (
  newUserName,
  newUserEmail,
  newUserPassword,
  newUserRole,
  confirmPassword
) => {
  if(newUserPassword === confirmPassword 
  );
  const res = await fetch(`http://localhost:8080/api/users`, {
    method: "POST",
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      name: newUserName,
      email: newUserEmail,
      password: newUserPassword,
      role: newUserRole
    })
  });
  if (res.status === 201) {
    location.reload();
    alert("Added sucessfully");
    const addedUser = await res.json();
    events.value.push(addedUser);      
  } else if (res.status === 400) {
    alert("Name and email must be unique")
  }
        console.log("error, cannot be added");
};

</script>
 
<template>
    <UserRegister 
    @createUser="createNewUser"
    :userRegister="users"/>

</template>
 
<style>

</style>