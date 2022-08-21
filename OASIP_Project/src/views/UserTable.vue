<script setup>
import { ref, onBeforeMount } from "vue";
import UserList from "../components/UserList.vue";
import UserDetail from "../components/UserDetail.vue";
import UserCreate from "../components/UserCreate.vue";

const users = ref([]);
const userDetail = ref({});



const getUsers = async () => {
  const res = await fetch(import.meta.env.BASE_URL+`api/users`);
  if (res.status === 200) {
    users.value = await res.json();
    console.log(users.value);
    return users.value;
  } else console.log("error, cannot get notes");
};

onBeforeMount(async () => {
  await getUsers();
  console.log(users.value);
});

const getUserid = async (userId) => {
  console.log(userId);
  const res = await fetch(import.meta.env.BASE_URL+`api/users/${userId}`);
  if (res.status === 200) {
    userDetail.value = await res.json();
    console.log(userDetail.value);
  } else console.log("error, cannot get data");
};

const createNewUser = async (
  newUserName,
  newUserEmail,
  newUserRole
) => {
  console.log(
    newUserName,
    newUserEmail,
    newUserRole
  );
  const res = await fetch(import.meta.env.BASE_URL+`api/users`, {
    method: "POST",
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      name: newUserName,
      email: newUserEmail,
      role: newUserRole,
    })
  });
  if (res.status === 201) {
    alert("Added sucessfully");
    const addedUser = await res.json();
    events.value.push(addedUser);
  } else console.log("error, cannot be added");
};

</script>
 
<template>
    <UserCreate 
    @createUser="createNewUser"
    :userCreate="users"

    />
    <UserList
    :userList="users"
    @getUserid="getUserid"/>

    <UserDetail :userDetail="userDetail" />
</template>
 
<style>

</style>