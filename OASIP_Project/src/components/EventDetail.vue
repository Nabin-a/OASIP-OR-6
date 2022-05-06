<script setup>
import { useRoute, useRouter } from 'vue-router';
defineProps({
    eventDetail:{
        type: Object,
    }
})
</script>
 
<template>
    <div>
        <h1>Event Detail</h1>
        <div>
            <ul>
                <li>{{ eventDetail.bookingName }}</li>
                <li>{{ eventDetail.bookingEmail }}</li>
                <li>{{ eventDetail.category }}</li>
                <li>{{ eventDetail.startTime }}</li>
                <li>{{ eventDetail.durations }}</li>
                <li>{{ eventDetail.note }} </li>
            </ul>
        </div>
    </div>
</template>
 
<style>

</style>