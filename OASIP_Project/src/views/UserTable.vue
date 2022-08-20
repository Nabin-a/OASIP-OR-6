<script setup>
import { ref, onBeforeMount } from "vue";
import UserList from "../components/UserList.vue";
import UserDetail from "../components/UserDetail.vue";

const users = ref([]);
const userDetail = ref({});



const getUsers = async () => {
  const res = await fetch(`http://localhost:8080/api/users`);
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
  const res = await fetch(`http://localhost:8080/api/users/${userId}`);
  if (res.status === 200) {
    userDetail.value = await res.json();
    console.log(userDetail.value);
  } else console.log("error, cannot get data");
};


</script>
 
<template>
    <UserList
    :userList="users"
    @getUserid="getUserid"/>

    <UserDetail :userDetail="userDetail" />
</template>
 
<style>

</style>