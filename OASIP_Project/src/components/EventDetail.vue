<script setup>
import moment from "moment";

defineEmits(["updateEvent"]);
defineProps({
  eventDetail: {
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
              Detail of {{ eventDetail.bookingName }}
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
                Date : {{ moment(eventDetail.startTime).format("DD/MM/YYYY") }}
              </li>
              <li class="list-group-item">
                Time : {{ moment(eventDetail.startTime).format("HH:mm") }}
              </li>
              <li class="list-group-item">
                Durations : {{ eventDetail.durations }} mins
              </li>
              <li class="list-group-item">
                Category : {{ eventDetail.categoryName }}
              </li>
              <li class="list-group-item">
                Booker : {{ eventDetail.bookingName }}
              </li>
              <li class="list-group-item">
                Email : {{ eventDetail.bookingEmail }}
              </li>
              <li class="list-group-item">Note : {{ eventDetail.note }}</li>
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
