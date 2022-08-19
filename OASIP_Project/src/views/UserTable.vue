<script setup>
import { ref, onBeforeMount } from "vue";
import UserList from "../components/UserList.vue";

const users = ref([]);




const getEvents = async () => {
  const res = await fetch(`http://localhost:8080/api/users`);
  if (res.status === 200) {
    users.value = await res.json();
    console.log(users.value);
    return users.value;
  } else console.log("error, cannot get notes");
};

onBeforeMount(async () => {
  await getEvents();
  console.log(users.value);
});

</script>
 
<template>
    <UserList
    :userList="users"/>

</template>
 
<style>

</style>