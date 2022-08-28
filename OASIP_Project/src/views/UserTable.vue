<script setup>
import { ref, onBeforeMount } from "vue";
import UserList from "../components/UserList.vue";
import UserDetail from "../components/UserDetail.vue";
import UserCreate from "../components/UserCreate.vue";

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
  const res = await fetch(`http://localhost:8080/api/users`, {
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
    location.reload();
    alert("Added sucessfully");
    const addedUser = await res.json();
    events.value.push(addedUser);
  } else console.log("error, cannot be added");
};

const removeUser = async (userId) => {
  if (confirm("Delete this user?") == true) {
    console.log(userId);
    const res = await fetch(`http://localhost:8080/api/users/${userId}`, {
      method: "DELETE"
    });
    if (res.status === 200) {
      users.value = users.value.filter((user) => user.userId !== userId);
      console.log("deleted successfully");
    } else console.log("error, cannot delete data");
  }
};

// PUT
const updateUser = async (userId, editName, editEmail, editRole) => {
  console.log(userId, editName, editEmail, editRole);
  const res = await fetch(`http://localhost:8080/api/users/${userId}`, {
    method: "PATCH",
    headers: {
      "content-type": "application/json;"
    },
    body: JSON.stringify({
      name: editName,
      email: editEmail,
      role: editRole
    })
  });
  if (res.status === 200) {
    location.reload();
    alert("Edit Success");
    console.log("edited successfully");
  } else console.log("error, cannot be edit");
};




</script>
 
<template>
    <UserCreate 
    @createUser="createNewUser"
    :userCreate="users"
    :currentUser="userDetail"
    @updateUser="updateUser"
    />
    <UserList
    :userList="users"
    @getUserid="getUserid"
    @removeUser="removeUser"
    />

    <UserDetail :userDetail="userDetail" />

    
</template>
 
<style>

</style>