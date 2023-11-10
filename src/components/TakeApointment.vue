<script setup>
import { reactive } from "vue";
import { RouterView, useRouter } from "vue-router";
import appointment from "./components/appointment.vue";


const router = useRouter();

const dt = reactive({
  doctorName: "",
  department: "",
  flag: false,
});

defineProps({
  NameOfDocter: String,
  Department: String,
});

function submit() {
  //   router.push("/appoint");
  dt.flag = true;
}
</script>

<template>
  <div>
    <!-- <input
      type="text"
      v-model.trim.lazy="dt.doctorName"
      placeholder="Enter Doctor Name"
    />
    <input
      type="text"
      v-model.trim.lazy="dt.department"
      placeholder="Enter Department"
    />
  </div>-->

    <div class="name">Dc. {{ NameOfDocter }}</div>
    <br />
    <div class="name">Department : {{ Department }}</div>
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
  background-color: greenyellow;
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
  background-color: rgb(39, 236, 39);
  color: white;
}
.sh {
  margin-top: 20px;
  background-color: aqua;
}
</style>
