<script setup>
import { ref } from 'vue';

const datas =  ref([
  {name: 'aaa', catagory:'zzz', stTime:12.30, duration:'30m',ooo:'zzz'},
  {name: 'avc', catagory:'zz1', stTime:12.30, duration:'30m',ooo:'zzz'},
  {name: 'abc', catagory:'zz3', stTime:12.30, duration:'30m',ooo:'zzz'}
])
</script>
 
<template>
  <div>
    <div v-show="datas.length===0">
    <h1 class="ne">No Event Schudule Today</h1>
    </div>
    <table v-show="datas.length!=0">
      <thead>
        <tr>
          <th>Booking Name</th>
          <th>Catagory</th>
          <th>Start Up Time</th>
          <th>Duration</th>
          <th>ooo</th>
        </tr>
      </thead>
      <tbody v-for="(data,index) in datas" :key="index">
        <td>{{data.name}}</td>
        <td>{{data.catagory}}</td>
        <td>{{data.stTime}}</td>
        <td>{{data.duration}}</td>
        <td>{{data.ooo}}</td>
      </tbody>
    </table>
  </div>
</template>
 
<style>
.ne {
  font-size: 600%;
  padding: 10% 0px 0px 10%;
  color:white;
  font-style: italic;
}
th , td {
  font-size:30px;
  padding-left: 100px;
  padding-top: 30px;
}
</style>