<script setup>
import { reactive } from "vue";
const appoint = reactive({
  time: "",
  name: "",
  RationalId: "",
  PhoneNumber: "",
});

const confirm = () => {
  console.log(appoint.time);
};
</script>
<template>
  <div class="select">
    <select class="sel" v-model.trim="appoint.time">
      <option value="8:55">8:55</option>
      <option value="10:10">10:10</option>
      <option value="40:40">4:40</option>
      <option value="audi">5:50</option>
    </select>
  </div>
  <div class="sh">
    <p>Selected Time:{{ appoint.time }}</p>

    <input
      type="text"
      v-model.trim.lazy="appoint.name"
      placeholder="Enter Name"
    />

    <!-- <input v-model.lazy.trim="appoint.name" p="Enter Name" /> -->
    <input
      type="text"
      v-model.trim.lazy="appoint.PhoneNumber"
      placeholder="Enter Phone Number"
    />
    <input
      type="text"
      v-model.trim.lazy="appoint.RationalId"
      placeholder="Enter Rational Id"
    />
    <button @click.prevent="confirm">confirm</button>
  </div>
</template>

<style scoped>
.sel {
  margin: 10px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

p {
  margin: 10px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
.sh {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
input {
  margin: 10px;
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

</style>
