<script setup>
import moment from "moment";

defineProps({
  userDetail: {
    type: Object
  }
});
</script>

<template>
  <div>
    <div
      class="modal fade"
      id="DetailModal"
      tabindex="-1"
      aria-labelledby="DetailModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header bg-dark">
            <h4 class="modal-title" id="DetailModalLabel">
              Detail of {{ userDetail.name }}
            </h4>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <ul class="list-group">
              <li class="list-group-item">
                name : {{ userDetail.name }} 
              </li>
              <li class="list-group-item">
                email : {{ userDetail.email }}
              </li>
              <li class="list-group-item">
                role : {{ userDetail.role }}
              </li>
              <li class="list-group-item">
                createdOn : {{ moment(userDetail.createdOn).format("YYYY/MM/DD HH:mm") }}
              </li>
              <li class="list-group-item">
                updatedOn : {{ moment(userDetail.updatedOn).format("YYYY/MM/DD HH:mm") }}
              </li>            
            </ul>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.modal-header {
  background-color: #6666ff;
  color: white;
}

li {
  font-size: 20px;
}
</style>
