<script setup>
import { ref, onBeforeMount } from "vue";
import { useRouter } from "vue-router"
import UserList from "../components/UserList.vue";
import UserDetail from "../components/UserDetail.vue";
import UserCreate from "../components/UserCreate.vue";

onBeforeMount(async () => {
  await getUsers();
});


const appRouter = useRouter();
const users = ref([]);
const userDetail = ref({});
const validateUnique = ref(false);
const goLogin = () => appRouter.push({ name: "Login" });
const goUser = () => appRouter.push({ name: "User" });
const users1 = ref([]);
const validate = ref(false);

let token = localStorage.getItem("token");

const getUsers = async () => {
  const res = await fetch(`http://localhost:8080/api/users`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    users.value = await res.json();
    console.log(users.value);
    return users.value;
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/refresh`, {
      headers: {
        Authorization: `Bearer` + localStorage.getItem("refreshToken")
      }
    });
    if (resfs.status === 200) {
      data = await resfs.json();
      localStorage.setItem("token", data.accessToken);
    } else if (resfs.status === 401) {
      goLogin();
    }
  }
};

const getUserid = async (userId) => {
  console.log(userId);
  const res = await fetch(`http://localhost:8080/api/users/${userId}`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  if (res.status === 200) {
    userDetail.value = await res.json();
    console.log(userDetail.value);
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/refresh`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("refreshToken")}`
      }
    });
    if (resfs.status === 200) {
      data = await resfs.json();
      localStorage.setItem("token", data.accessToken);
    }
  }
};

const removeUser = async (userId) => {
  if (confirm("Delete this user?") == true) {
    console.log(userId);
    const res = await fetch(`http://localhost:8080/api/users/${userId}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`
      }
    });
    if (res.status === 200) {
      users.value = users.value.filter((user) => user.userId !== userId);
      console.log("deleted successfully");
    } else if (res.status === 401) {
      const resfs = await fetch(`https://localhost:8080/api/refresh`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("refreshToken")}`
        }
      });
      if (resfs.status === 200) {
        data = await resfs.json();
        localStorage.setItem("token", data.accessToken);
      }
    }
  }
};
// PATCH
const updateUser = async (userId, editName, editEmail, editRole) => {
  console.log(userId, editName, editEmail, editRole);
  const res = await fetch(`http://localhost:8080/api/users/${userId}`, {
    method: "PATCH",
    headers: {
      "content-type": "application/json;",
      Authorization: `Bearer ${token}`
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
  } else if (res.status === 400) {
    validateUnique.value = true;
  } else if (res.status === 401) {
    const resfs = await fetch(`https://localhost:8080/api/refresh`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("refreshToken")}`
      }
    });
    if (resfs.status === 200) {
      data = await resfs.json();
      localStorage.setItem("token", data.accessToken);
    }
  }
};
const createNewUser = async (
  newUserName,
  newUserEmail,
  newUserPassword,
  newUserRole,
  confirmPassword
) => {
  if (newUserPassword === confirmPassword);
  const res = await fetch(`http://localhost:8080/api/users/register`, {
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
    location.reload()
    alert("Added sucessfully");
    const addedUser = await res.json();
    users1.value.push(addedUser);
  } else if (res.status === 400) {
    validate.value = true;
  } else {
    console.log("error, cannot be added");
  }
};
</script>

<template>
  <UserCreate
    :currentUser="userDetail"
    :validateUnique="validateUnique"
    @updateUser="updateUser"
  />
  <UserList
    :userList="users"
    @getUserid="getUserid"
    @removeUser="removeUser"
    @createUser="createNewUser"
    :userRegister="users1"
    :validate="validate"
  />

  <UserDetail :userDetail="userDetail" />
</template>

<style></style>
