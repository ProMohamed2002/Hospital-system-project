<<<<<<< HEAD
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
=======
<script setup>
import { reactive } from "vue";
import input from "./inpute.vue";

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

<style lang="scss" scoped>
.sel {
  margin: 10px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}
option {
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

.options {
  display: none;
  position: absolute;
  top: 100%;
  right: 0;
  left: 0;
  z-index: 999;
  margin: 0;
  padding: 0;
  list-style: none;
  // background-color: darken($select-background, 5);
  li {
    margin: 0;
    padding: 12px 0;
    text-indent: 15px;
    // border-top: 1px solid darken($select-background, 10);
    // @include transition(all 0.15s ease-in);
    &:hover,
    &.is-selected {
      // color: $select-background;
      // background: $select-color;
    }
    &[rel="hide"] {
      display: none;
    }
  }
}
</style>
>>>>>>> 0e37c644dee0e31dfdd75c0824c1f443c9331a88
