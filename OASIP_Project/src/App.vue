<script setup>
import EventList from './components/EventList.vue';
import Mytable from './views/Mytable.vue';

</script>
 
<template>
  
  <div>
   
    <Mytable/>
  </div>
  <div>
    <router-view></router-view>
  </div>
</template>
 
<style>


/* .container1 {
 background-color: #FD8D8D;
 font-size: 30px;
 height: 50px;
 padding: 5px 0px 0px 30px;
}

.container2 {
  height: 500px;
  width:1400px;
  background-color: #FD8D8D;
  border-radius: 20%;
  margin-left: 70px;
  
} */
</style>