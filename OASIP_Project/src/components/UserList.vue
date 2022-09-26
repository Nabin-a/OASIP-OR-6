<script setup>
import {useRouter} from 'vue-router'
defineEmits(["getUserid","removeUser"])
defineProps({
  userList: {
    type: Array,
    require: true
  }
});
const appRouter = useRouter()
const goLogin = () => appRouter.push({name: 'Login'})
let token = localStorage.getItem('token')
</script>

<template>
  <div class="container pt-3 pb-5">
    <h2 style="color: white">User List</h2>
    &nbsp
    <h1 v-if="token === null">Please <a class="link-blue" @click="goLogin">login</a>  before.</h1>
    <h1 v-else-if="userList.length < 1" class="forusl">No users</h1>
    <table class="table table-light table-striped table-hover" v-else>
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
          <th scope="col" style="padding-left: 7.5%">ooo</th>
        </tr>
      </thead>
      <tbody v-for="(user, index) in userList" :key="index">
        <tr>
          <td scope="col">{{ user.name }}</td>
          <td scope="col">{{ user.email }}</td>
          <td scope="col">{{ user.role }}</td>
          <td style="padding-left: 2%">
            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#DetailModal"
              @click="$emit('getUserid', user.userId)"
            >
              <i class="fa fa-info-circle"></i>
            </button>
            &nbsp
            <button
              class="btn btn-success"
              data-bs-target="#EditModal"
              data-bs-toggle="modal"
              @click="$emit('getUserid', user.userId)"
            >
              <i class="fa fa-edit"></i>
            </button>
            &nbsp;
            <button
              type="button"
              class="btn btn-danger"
              @click="$emit('removeUser', user.userId)"
            >
              <i class="fa fa-trash"></i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style>
 .forusl{
  margin-left: 42%;
  color: white;
 }
</style>
