<script>
import axios from 'axios';
export default {
  name: "book",

  data() {
    return {
      selected: {
        work_start:'',
        work_end:'',
        week_day:''
      },
      appointment:{
        booking_date:'',
        session_date:'',
        booking_number:'',
        session_start:'',
        session_end:'',
        doctor:'',///local storage
        pationt:'',///localstorge
        week_day:'',
        fees:60/// static
      },
      index: 0,
      element: 0,
      appointments: [
        {
          week_day:'wednewday',
          work_start:'00:20',
          work_end:'00:40',
          session_date:'2023-01-1'

        },
        {
          week_day:'friday',
          work_start:'01:20',
          work_end:'01:40',
          session_date:'2023-01-20'
        },
        {
          week_day:'sunday',
          work_start:'02:20',
          work_end:'02:40',
          session_date:'2023-02-23'
        }
      ],
    };
  },
  async mounted(){
    ///get all free apointments 
    let res=await axios.get("http://localhost:8081/          ")
      this.appointments=res.data
  },
  methods: {
    selectbook(itm){
      this.appointment.week_day=itm.week_day
      this.appointment.session_start=itm.work_start
      this.appointment.session_end=itm.work_end 
      this.appointment.booking_date=new Date();
      this.appointment.doctor=localStorage.getItem("doctor")
      this.appointment.pationt=localStorage.getItem("user_name")
      this.appointment.week_day=itm.week_day
      this.appointment.session_date=itm.session_date
      this.appointment.fees=60
      axios.post("http://locahost8081/   ",this.appointment)
      this.$router.push('#')
    }
  },
};
</script>
import main_header from './header.vue'
import axios from 'axios'
import Footer from './footer.vue'
<template>
<section class="page-container">
    <header class="page-header">
      <figure class="page-header__avatar">
        <img
          class="page-header__avatar-img"
          src="../assets/Adel.png"
          alt="Profile picture"
        />
      </figure>
      <div class="page-header__title-wrapper">
        <h1 class="page-header__title"><span>{{localStorage.getItem("doctor")}}</span></h1>
        <small class="page-header__subtitle"
          >Set up an appointment by finding an available meeting time.</small
        >
      </div>
    </header>
    <table class="appointments-table">
      <tr>
        <th>Day</th>
        <th>Session Date</th>
        <th>Start</th>
        <th>End</th>
        <th>Choose</th>
      </tr>
      <tr v-for="item in appointments" :key="item.id">
        <td>{{ item.week_day }}</td>
        <td>{{ item.session_date }}</td>
        <td>{{ item.work_start }}</td>
        <td>{{ item.work_end }}</td>
        <td><button @click="selectbook(item)">Book</button></td>
      </tr>
    </table>
  </section>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap");
:root {
  /* COLORS */
  --sc-slate-gray: #243b53;
  --sc-border-gray: #ebedf0;
  --sc-background-gray: #f8f9fa;
  --sc-input-gray: #f0f2f5;
  --sc-blue: #1b91fb;
  --sc-light-blue: #f2f9ff;
  --white: #fff;

  /* FONT */
  --font-graphik: "Graphik", "Inter", ui-sans-serif, system-ui, -apple-system,
    BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans",
    sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol",
    "Noto Color Emoji";

  /* SHADOW */
  --shadow-sm: 0px 3.59106px 8.44563px rgba(36, 59, 83, 0.0363503),
    0px 1px 3px rgba(36, 59, 83, 0.04);

  /* BORDER */
  --radius: 4px;
  --border: 1px solid var(--sc-border-gray);
}

/* PAGE DEFAULTS
** This Body and Html CSS should probably be removed. */
html {
  font-family: var(--font-graphik);
  font-size: 16px;
  scroll-behavior: smooth;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

body {
  background: var(--sc-background-gray);
  color: var(--sc-slate-gray);
}

.material-symbols-outlined {
  font-variation-settings: "FILL" 1, "wght" 400, "GRAD" 0, "opsz" 24;
  color: var(--sc-slate-gray);
}

h1,
h2,
h3 {
  font-weight: 600;
}

strong,
b {
  font-weight: 500;
}

form {
  display: flex;
  flex-direction: column;
}
.appointments-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
}

/* Animation on hover */
tr:hover {
  background-color: #f5f5f5;
  transition: background-color 0.3s ease;
}
button {
  display: flex;
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  font-family: var(--font-graphik);
  background: none;
  border: none;
  padding: 0;
  margin: 0;
  cursor: pointer;
  font-weight: 500;
  font-size: 0.825rem;
}

button,
label,
textarea,
input {
  transition-property: background, border, color, opacity, transform, scale;
  transition-duration: 120ms;
  transition-timing-function: ease;
}

textarea,
input:not(input[type="radio"]) {
  border: var(--border);
  border-radius: var(--radius);
  padding: 0.5rem;
  color: var(--sc-slate-gray);
  box-sizing: border-box;
}

textarea {
  width: 100%;
  height: 4rem;
  resize: none;
}

::placeholder {
  color: var(--sc-slate-gray);
  opacity: 0.5;
}

textarea:hover,
input:not(input[type="radio"]):hover {
  background: var(--sc-background-gray);
  outline: none;
}

textarea:focus,
input:not(input[type="radio"]):focus {
  background: var(--white);
  border-color: var(--sc-blue);
  outline: none;
}

/* PAGE CONTAINER
** Replace this class with your existing container. */
.page-container {
  width: 100%;
  max-width: 1140px;
  margin: 0 auto;
  padding: 0 1rem 1rem;
  box-sizing: border-box;
}

/* PAGE HEADER/TITLE 
** Some of these styles may already be predefined in your existing stylesheets. */
.page-header {
  display: flex;
  align-items: center;
  margin: 3rem 0;
}

.page-header__avatar {
  margin: 0;
  width: 4rem;
  height: 4rem;
  overflow: hidden;
  border-radius: 999px;
}

.page-header__avatar-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.page-header__title-wrapper {
  display: flex;
  flex-direction: column;
  padding-left: 1rem;
}

.page-header__title {
  margin: 0;
}

.page-header__title > span {
  color: var(--sc-blue);
}

.page-header__subtitle {
  opacity: 0.6;
}

.container {
  display: flex;
  justify-content: space-around; /* Adjust as needed */
  align-items: center;
  margin: 20px auto;
  max-width: 80%;
  padding: 1rem;
  background-color: #fff;
  border-radius: 3px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
}

/* Item styles */
.item {
  text-align: center;
}

/* Style for labels */
label {
  display: inline-block;

  margin-bottom: 5px;
  margin-right: 5px;
  font-weight: bold;
  color: #392a2a;
}

/* Style for spans */
span {
  display: inline-block;
  padding: 8px;
  background-color: #e0e0e0;
  border-radius: 3px;
}

/* Style for the button */
button {
  padding: 10px 15px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  font-family: "Helvetica", sans-serif;
}

button:hover {
  background-color: #45a049;
}
</style>
