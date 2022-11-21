<script setup>
import NavBar from './NavBar.vue';
import { useRouter } from "vue-router";

const appRouter = useRouter();

const goBooking = () => appRouter.push({ name: "Reserve"})
</script>
 
<template>
    <NavBar />
<br />
    <div class="container">
      <h1 style="font-size:80px">OASIP</h1>
      <p style="font-size:20px">Online Appointment Scheduling System for Intregrated Project Clinic</p>
      <div>
        <button class="button1" @click="goBooking()"><span>Reserve now</span></button>
      </div>
    </div>
</template>
 
<style>

.button1 {
	 display: inline-block;
	 padding: 0.75rem 1.25rem;
	 border-radius: 10rem;
	 color: rgb(251, 251, 251);
	 text-transform: uppercase;
	 font-size: 1rem;
	 letter-spacing: 0.15rem;
	 transition: all 0.5s;
	 position: relative;
	 overflow: hidden;
   border:none;
	 z-index: 1;
}
 .button1:after {
	 content: '';
	 position: absolute;
	 bottom: 0;
	 left: 0;
	 width: 100%;
	 height: 100%;
	 background-color: rgb(246, 137, 137);
	 border-radius: 10rem;
	 z-index: -2;
}
 .button1:before {
	 content: '';
	 position: absolute;
	 bottom: 0;
	 left: 0;
	 width: 0%;
	 height: 100%;
	 background-color: #9664ec;
	 transition: all 0.4s;
	 border-radius: 10rem;
	 z-index: -1;
}
 .button1:hover {
	 color: #fff;
}
 .button1:hover:before {
	 width: 100%;
}


</style>