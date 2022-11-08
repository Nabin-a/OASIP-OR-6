<script setup>
import { useRouter } from "vue-router";
defineEmits(["getUserid", "removeUser"]);
defineProps({
  userList: {
    type: Array,
    require: true
  }
});
const appRouter = useRouter();
const goLogin = () => appRouter.push({ name: "Login" });
let token = localStorage.getItem("token");
let role = localStorage.getItem("role");



</script>

<template>
  
    
    <h1 v-if="userList.length < 1" class="forusl">No users</h1>
    <!-- <table class="table table-danger table-striped table-hover" v-else>
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
    </table> -->
  
  <div class="container1 scroll ">
    <div 
      class="card testimonial-card"
      v-for="(user, index) in userList"
      :key="index"
    >
      <div
        class="card-up"
        style="background-color: #b4bdef"
      >
      <div class="d-flex flex-row-reverse">
        <i
          class="fa fa-trash text-white m-2 "
          @click="$emit('removeUser', user.userId)"
        ></i>
        <i
          class="fa fa-pencil text-white m-2 "
          data-bs-target="#EditModal"
          data-bs-toggle="modal"
          @click="$emit('getUserid', user.userId)"
        ></i>
       
          
        </div>
      </div>
      <div class="avatar mx-auto bg-white">
        <img
          src="../assets/avatar.png"
          class="rounded-circle img-fluid image"
          data-bs-toggle="modal"
          data-bs-target="#DetailModal"
          @click="$emit('getUserid', user.userId)"
        />
      </div>
      <div class="card-body">
        <h4 class="mb-0" style="font-size:18px">{{ user.name }}</h4>
        <hr />
        <p class="dark-grey-text mt-1">
          {{ user.email }}
        </p>
        <p class="dark-grey-text mt-1">
          Role - {{ user.role }}
        </p>
        
      </div>

    </div>
  </div>


</template>

<style>
.forusl {
  margin-left: 42%;
  color: rgb(227, 70, 106);
}

.container1 {
  background-color: #cbddf6;
  margin-left: 20%;
  height: 530px;
  display: flex;
  flex-wrap: wrap;
  width: 65%;
  position: relative;
  overflow: auto;
  border-radius: 50px;
}

.container1::-webkit-scrollbar {
  width:6px; 
 
}

.container1::-webkit-scrollbar-track {
  background:#cbddf6;
  margin :50px;
  
}

.container1::-webkit-scrollbar-thumb {
  background: #f1f1f1;
  
  border-radius: 50px;
  
}

.container1::-webkit-scrollbar-thumb:hover{
  background: #bdcde3;
  
}



.container1 > div {
  background-color: rgb(255, 255, 255);
  margin: 10px;
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
  width: 30%;
  border-radius: 50px;
}

.testimonial-card .card-up {
  height: 120px;
  overflow: hidden;
  border-top-left-radius: 0.25rem;
  border-top-right-radius: 0.25rem;
  border-radius: 20px;
}

.testimonial-card .avatar {
  width: 110px;
  margin-top: -60px;
  overflow: hidden;
  border: 3px solid #fff;
  border-radius: 50px;
}

.image {
  opacity: 1;
  display: block;
  transition: 0.5s ease;
  backface-visibility: hidden;
  position: relative;
}

.image:hover {
  opacity: 0.3;
  cursor: pointer;
}

.fa {
  cursor: pointer;
}




</style>
