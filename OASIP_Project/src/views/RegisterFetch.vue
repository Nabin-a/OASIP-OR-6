<script setup>
import { ref, onBeforeMount } from "vue";
import UserRegister from "../components/UserRegister.vue";

const users1 = ref([]);
const validate = ref(false)

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