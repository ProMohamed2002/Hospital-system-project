<script setup>
import { reactive } from "vue";
import appointment from "./appointment.vue";
const dt = reactive({
  doctorName: "Mohsen",
  department: "Neurosurgery",
  flag: false,
});

// eslint-disable-next-line no-undef
defineProps({
  NameOfDocter: String,
  Department: String,
});
function submit() {
  dt.flag = true;
}

</script>

<template>
  <div>
 

    <div class="name" style="color:#ffffffff">Dc. {{ dt.doctorName }}</div>
    <br />
    <div class="name" style="color:#ffffffff">Department : {{ dt.department }}</div>
    <button @click="submit">Show</button>
    <div v-show="dt.flag" class="sh">
      <appointment />
    </div>
  </div>
</template>

<style scoped>
.name {
  padding: 10px;
  align-content: center;
  justify-content: center;
  width: 20%;
  background-color: #1376ab;
  font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
}

div {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
input {
  margin: 10px;
  margin-top: 20px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
button {
  margin: 10px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
button:hover {
  background-color: #375f74;
  color: white;
}
.sh {
  margin-top: 20px;
  background-color:  #094d71;
}
</style>