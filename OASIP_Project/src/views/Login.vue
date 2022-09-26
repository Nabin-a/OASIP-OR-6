<script setup>
import UserTable from "./UserTable.vue";
import { useRouter } from "vue-router";
import LoginFetch from "./LoginFetch.vue";
import NavBar from "./NavBar.vue";
</script>

<template>
  <NavBar />
  <div>
    <LoginFetch />
  </div>
</template>

<style></style>
