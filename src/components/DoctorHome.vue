<template>
    <div class="page" :style="{ backgroundColor: isNightMode ? '#2c3e50' : 'lightblue' }">
      <h1>Tasks</h1>
      <div class="tasks">
        <div v-for="yeartask in yeartasks" :key="`${yeartask.yeart}-${yeartask.montht}`" class="task">
          <div>
            <div @click="gettask(yeartask.yeart, yeartask.montht)" class="task-item"
              :style="{ color: isNightMode ? 'white' : 'black' }">{{ yeartask.yeart + months.at(yeartask.montht) }}</div>
          </div>
        </div>
  
      </div>
      <div class="calendar-container" :style="{ backgroundColor: isNightMode ? '#2c3e50' : 'lightblue' }">
        <div class="slider">
          <div @click="prevSlide" class="nav-button"
            :style="{ backgroundColor: isNightMode ? '#34495e' : '#007bff', color: isNightMode ? '#ecf0f1' : 'white' }">&lt;
          </div>
          <div class="calendar-header"
            :style="{ backgroundColor: isNightMode ? '#34495e' : '#007bff', color: isNightMode ? '#ecf0f1' : 'white', borderRadius: isNightMode ? '5px' : '7%' }">
            {{ year + month }}</div>
          <div @click="nextSlide" class="nav-button"
            :style="{ backgroundColor: isNightMode ? '#34495e' : '#007bff', color: isNightMode ? '#ecf0f1' : 'white' }">&gt;
          </div>
          <div class="mode-toggle" @click="toggleMode">{{ isNightMode ? '☀ Day' : '🌙 Night' }}</div>
        </div>
  
        <HelloWorld :appointmentss="data" :chosenddate="chooseddate" ref="hello" />
  
        <div class="calendar-days">
          <div v-for="day in getMonthDays(month)" :key="day" class="calendar-day"
            :style="{ backgroundColor: (choosedday === day + 1) && (choosedmonth === month) && (choosedyear === year) ? 'green' : tasks.includes(formateddata(year, currentSlide, day + 1).formattedDate) ? 'red' : isNightMode ? '#455a64' : '#007bff', borderRadius: isNightMode ? '8px' : '8%' }"
            @click="openpage(year, currentSlide, day + 1)">
            <span v-if="day !== null" class="day-number">{{ day + 1 }}</span>
            <span v-else class="day-placeholder"> </span>
            {{ getDayInfo(year, currentSlide, day + 1).dayName }}
          </div>
  
        </div>
  
      </div>
    </div>
  </template>
  
  <script >
  import axios from "axios"
  import HelloWorld from './HelloWorld.vue'
  export default {
  name:"DoctorHome",
    created() {
      this.doctorName = localStorage.getItem("username")
      this.fetchAppointments();
    },
    components:{
        HelloWorld
    },
    data() {
      return {
        months: [
          'January', 'February', 'March', 'April', 'May', 'June',
          'July', 'August', 'September', 'October', 'November', 'December'
        ],
        currentSlide: 0,
        January: Array.from({ length: 31 }, (_, index) => index),
        February: Array.from({ length: 28 }, (_, index) => index),
        March: Array.from({ length: 31 }, (_, index) => index),
        April: Array.from({ length: 30 }, (_, index) => index),
        May: Array.from({ length: 31 }, (_, index) => index),
        June: Array.from({ length: 30 }, (_, index) => index),
        July: Array.from({ length: 31 }, (_, index) => index),
        August: Array.from({ length: 31 }, (_, index) => index),
        September: Array.from({ length: 30 }, (_, index) => index),
        October: Array.from({ length: 31 }, (_, index) => index),
        November: Array.from({ length: 30 }, (_, index) => index),
        December: Array.from({ length: 31 }, (_, index) => index),
        month: 'January',
        daysOfWeek: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'], tasks: [],
        year: 2023,
        isNightMode: false, chooseddate: "",
        showpage: false,
        appointments: [], choosedday: 0, choosedmonth: "", choosedyear: 0, yeartasks: [], patientid: '', patientname: "", search: 'name', searching: false, data: [], doctorName: ""
      };
    },
    methods: {
      getMonthDays(month) {
        return this[month];
      },
      getDayInfo(year, month, day) {
        const formattedMonth = month < 10 ? `0${month + 1}` : `${month + 1}`;
        const formattedDay = day < 10 ? `0${day}` : `${day}`;
        const formattedDate = `${year}-${formattedMonth}-${formattedDay}`;
        const date = new Date(formattedDate);
        const dayOfWeek = this.daysOfWeek[date.getUTCDay()];
        return { dayName: dayOfWeek };
      }, getDayInfo2(tdate) {
        const date = new Date(tdate);
        const dayOfWeek = this.daysOfWeek[date.getUTCDay()];
        return { dayName: dayOfWeek };
      },
      formateddata(year, month, day) {
        const formattedMonth = month < 10 ? `0${month + 1}` : `${month + 1}`;
        const formattedDay = day < 10 ? `0${day}` : `${day}`;
        const formattedDate = `${year}-${formattedMonth}-${formattedDay}`;
        return { formattedDate: formattedDate };
      },
      prevSlide() {
        if (this.month === 'January') {
          this.year = this.year - 1;
        }
        this.currentSlide = (this.currentSlide - 1 + 12) % 12;
        this.month = this.months[this.currentSlide];
      },
      nextSlide() {
        if (this.month === 'December') {
          this.year = this.year + 1;
        }
        this.currentSlide = (this.currentSlide + 1) % 12;
        this.month = this.months[this.currentSlide];
      },
      toggleMode() {
        this.isNightMode = !this.isNightMode;
      },
      openpage(year, month, day) {
  
        this.patientid = "";
        this.patientname = "";
        this.searching = false;
        if (day !== this.choosedday || this.choosedmonth !== this.months[month] || this.choosedyear !== year) {
          this.showpage = true;
          this.choosedday = day;
          this.choosedmonth = this.months[month];
          this.choosedyear = year;
          this.chooseddate = String(this.formateddata(year, month, day).formattedDate);
          this.update()
          if(this.data.length!=0){
          this.$refs.hello.showModal = true
          this.showpage = !this.showpage;
          this.choosedday = 0;
          this.choosedmonth = "";
          this.choosedyear = 0;
        }
        }
        else if (!this.showpage) {
          this.showpage = !this.showpage;
          this.choosedday = day;
          this.choosedmonth = this.months[month];
          this.choosedyear = year;
          this.chooseddate = String(this.formateddata(year, month, day).formattedDate);
        }
        else if (day === this.choosedday && this.choosedmonth === this.months[month] && this.choosedyear === year) {
          // {
          this.showpage = !this.showpage;
          this.choosedday = 0;
          this.choosedmonth = "";
          this.choosedyear = 0;
        }
  
      },
      gettask(yeartask, monthtask) {
        this.currentSlide = monthtask;
        this.month = this.months.at(this.currentSlide);
        this.year = yeartask;
      },
      loadtask() {
        for (const appointment of this.appointments) {
          this.tasks.push(appointment.booking_date);
          let date = new Date(appointment.booking_date);
          let year0 = date.getFullYear();
          console.log(year0);
          let month0 = date.getMonth();
          this.yeartasks.push({ yeart: year0, montht: month0 });
          console.log(this.tasks);
        }
      }, searchpatient() {
        this.choosedday = 0;
        this.searching = true;
      },
      fetchAppointments() {
        const baseUrl = 'http://localhost:8081';
  
        axios.get(`${baseUrl}/customDoctor`, {
          params: {
            doctor: this.doctorName
          }
        })
          .then(response => {
            this.appointments = response.data;
            console.log(this.appointments)
            this.loadtask()
            console.log(this.tasks)
          })
          .catch(error => console.error('Error fetching appointments:', error));
        
      
      },
      update() {
        this.data = []
        for (const appointment of this.appointments) {
          if (appointment.booking_date == this.chooseddate) {
            this.data.push(appointment)
          }
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .calendar-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 20px auto;
    background-color: lightblue;
    height: 500px;
    widows: 200px;
    border-color: #007bff;
  }
  
  .hh {
    background-color: #0b3654;
  }
  
  .slider {
    display: flex;
    align-items: center;
  }
  
  .page {
    display: flex;
  
  }
  
  .nav-button {
    margin: 10px;
    padding: 8px 16px;
    cursor: pointer;
    font-size: 1rem;
    border-radius: 5px;
  }
  
  .calendar-header {
    font-size: 1.5rem;
    margin: 0 20px;
    cursor: pointer;
  }
  
  .calendar-days {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    gap: 5px;
    color: white;
    cursor: pointer;
  }
  
  .calendar-day-header,
  .calendar-day {
    padding: 10px;
    text-align: center;
    border: 1px solid #ccc;
    border-radius: 8%;
  }
  
  .calendar-day-header {
    font-weight: bold;
  }
  
  .day-number {
    font-weight: bold;
  }
  
  .day-placeholder {
    color: #ccc;
  }
  
  .mode-toggle {
    margin-left: auto;
    margin-right: 10px;
    cursor: pointer;
  }
  
  .appointment-card {
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 16px;
    margin: 16px 0;
  }
  
  .info {
    margin: 8px 0;
  }
  
  .divider {
    border: 0;
    border-top: 1px solid #ccc;
    margin: 8px 0;
  }
  
  .task {
    display: grid;
    gap: 1px;
    color: white;
    cursor: pointer;
  
  }
  
  .task-item {
    padding: 10px;
    text-align: center;
    border: 1px solid #ccc;
    border-radius: 8%;
  }
  
  .task-item:hover {
    background-color: #0b3654;
    /* Change the background color on hover */
  }
  
  .tasks {
    overflow: auto;
    height: 500px;
    width: 400px;
  }
  
  .page {
    background-color: #f0f0f0;
    /* Light gray background color resembling hospital walls */
  }
  
  .calendar-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 20px auto;
    background-color: #ffffff;
    /* White background for the calendar container */
    height: 500px;
    width: 400px;
    /* Adjust the width as needed */
    border: 1px solid #007bff;
    /* Border color for the container */
    border-radius: 10px;
    /* Border radius for rounded corners */
  }</style>
  