<script setup>
defineEmits(["getUserid"])
defineProps({
  userList: {
    type: Array,
    require: true
  }
});
</script>

<template>
  <div class="container pt-3 pb-5">
    <h2 style="color: white">Scheduled Events</h2>

    <table class="table table-light table-striped table-hover">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
          <th scope="col" style="padding-left: 2.5%">ooo</th>
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
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style></style>
