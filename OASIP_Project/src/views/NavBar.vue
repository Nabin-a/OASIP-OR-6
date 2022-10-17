<script setup>
import { useRouter } from "vue-router";

const appRouter = useRouter();
const goHome = () => appRouter.push({ name: "Home" });
const goUser = () => appRouter.push({ name: "User" });
const goEvent = () => appRouter.push({ name: "Event" });
const goLogin = () => appRouter.push({ name: "Login" });
const goRegister = () => appRouter.push({ name: "Register" });


let token = localStorage.getItem("token");
let name = localStorage.getItem("email")
let role = localStorage.getItem("role")

const clearData = () => localStorage.clear();
const reload = () => location.reload();



</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <button 
      @click="goHome" class="btn btn-light rounded-pill">Home</button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <button 
            v-if = "role =='ROLE_admin'"
            @click="goUser" class="btn btn-light rounded-pill">
              User
            </button>
          </li>
          &nbsp;
          <li class="nav-item">
            <button @click="goEvent" class="btn btn-light rounded-pill">
              Event
            </button>
          </li>
        </ul>
        
          <li v-if="token !== null" class="list-group item text-dark" >{{name}} |
          </li>
       
        <button
          v-if="token === null"
          class="btn btn-outline-dark rounded-pill"
          @click="goRegister"
        >
          Register
        </button>
        &nbsp; |
        <button
          v-if="token === null"
          class="btn btn-outline-dark rounded-pill"
          @click="goLogin"
        >
          Login
        </button>
        <button
          v-else="token !== null"
          class="btn btn-outline-dark rounded-pill"
          @click="
            clearData();
            reload();
          "
        >
          Logout
        </button>
      </div>
    </div>
  </nav>
</template>

<style></style>
