<template>
    <div class="modal-container" v-if="showModal">
      <div class="modal-background">
        <div class="modal-content">
          {{ chosenddate }}
          
          <div class="modal-scrollable">
            <div v-for="(appointment, index) in appointmentss" :key="index" class="appointment-info">
              <p class="info">Booking Date: {{ appointment.booking_date }}</p>
              <p class="info">Booking Number: {{ appointment.id }}</p>
              <p class="info">Session Start: {{ appointment.session_start }}</p>
              <p class="info">Session End: {{ appointment.session_end }}</p>
              <p class="info">Doctor: {{ appointment.doctor }}</p>
              <p class="info">Patient: {{ appointment.patient }}</p>
              <p class="info">Week Day: {{ appointment.week_day }}</p>
              <p class="info">Fees: {{ appointment.fees }}</p>
              <hr class="divider" />
            </div>
          </div>
          
         
          
          <div class="modal-footer">
            <button @click="closeModal">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <style scoped>
  .modal-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black background */
  }
  
  .modal-background {
    background-color: #fff; /* White background for the modal */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Box shadow for a subtle lift effect */
  }
  
  .modal-content {
    max-height: 70vh; /* Set a maximum height for the modal content */
    overflow-y: auto; /* Enable vertical scrolling when content exceeds the max height */
  }
  
  .modal-scrollable {
    overflow-y: auto; /* Enable vertical scrolling for the scrollable area */
  }
  
  .appointment-info {
    margin-bottom: 10px;
  }
  
  .divider {
    margin: 15px 0;
    border: 1px solid #ccc;
  }
  
  .modal-footer {
    display: flex;
    justify-content: flex-end;
  }
  
  button {
    padding: 10px 15px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  </style>
  
  
  <script >
  export default {
    name:"HelloWorld",
    props: ['appointmentss', 'chosenddate'],
    data() {
      return {
        showModal: true,
      };
    },
    methods: {
      closeModal() {
        this.showModal = false;
      },
    }
  };
  </script>