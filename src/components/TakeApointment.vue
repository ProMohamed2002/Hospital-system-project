<template>
  <main_header/>
  <div class="row">
    <div class="col-md-12">
      <div class="form">
        <h1>Take Appointment</h1>

        <fieldset>
          <legend><span class="number">1</span> Your Basic Info</legend>

          <label for="name">Name:</label>
          <input type="text" id="name" name="user_name" />

          <label for="phone">Phone Number:</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <select id="countryCode" name="countryCode" class="custom-select">
                <option value="">+12</option>
                <option value="">+10</option>
                <option value="">+15</option>
                <option value="">+18</option>
              </select>
            </div>
            <input
              type="tel"
              id="phone"
              name="user_phone"
              class="form-control"
              placeholder="Enter your phone number"
            />
          </div>

          <label for="email">Email:</label>
          <input type="email" id="mail" name="user_email" />

          <label>Age:</label>
          <input
            type="radio"
            id="under_13"
            value="under_13"
            name="user_age"
          /><label for="under_13" class="light">Under 13</label><br />
          <input
            type="radio"
            id="over_13"
            value="over_13"
            name="user_age"
          /><label for="over_13" class="light">Over 13</label>
        </fieldset>
        <fieldset>
          <legend><span class="number">2</span>Select Appointment</legend>

          <div class="Select">
            <button class="Select-button" @click="searchAction">
              Select Appointment:
            </button>
          </div>
          <div v-if="showModal" class="modal-overlay">
            <div class="modal" @click.stop>
              <div class="button-container">
                <button @click="closeModal" class="close-button">Close</button>
                <button @click="searchAction" class="search-button">
                  Confirm
                </button>
              </div>
            </div>
          </div>
          <div class="show">
            <lab> Date: </lab>
            <span>{{ "2021-10-10" }}</span>

            <lab> Your Selected Time: </lab>
            <span>{{ "10:10" }}</span>
            <span>to</span>
            <span>{{ "10:50" }}</span>
          </div>
        </fieldset>
        <button class="submit" @click="confirm">Confirm</button>
      </div>
    </div>
  </div>
  <Footer/>
</template>
<script>
import main_header from './header.vue'
import axios from 'axios'
import Footer from './footer.vue'
export default {
  name: "TakeApointment",
  components: {
        main_header,
        Footer
    },
  data() {
    return {
      showModal: false,
    };
  },
 
  methods: {
    ///sent the time to back
   async confirm(){
      await axios.get("http://localhost:8081/          ", {
                params: {
                    hospital: localStorage.getItem("booking")
                }
            })
    },
    searchAction() {
      this.$router.push('/book')
    },
    closeModal() {
      this.showModal = false;
    },
  },
};
</script>

<style scoped>
*:before,
*:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

body {
  font-family: "Nunito", sans-serif;
  color: #384047;
}

.form {
  max-width: 70%;
  margin: 10px auto;
  padding: 10px 20px;
  background: #f4f7f8;
  border-radius: 8px;
}

h1 {
  margin: 0 0 30px 0;
  text-align: center;
}

input[type="text"],
input[type="password"],
input[type="date"],
input[type="datetime"],
input[type="email"],
input[type="number"],
input[type="search"],
input[type="tel"],
input[type="time"],
input[type="url"],
textarea,
select {
  background: rgba(255, 255, 255, 0.1);
  border: none;
  font-size: 16px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 15px;
  width: 100%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
  margin-bottom: 30px;
}

input[type="radio"],
input[type="checkbox"] {
  margin: 0 4px 8px 0;
}

select {
  padding: 6px;
  height: 32px;
  border-radius: 2px;
}

.submit {
  padding: 19px 39px 18px 39px;
  color: #fff;
  background-color: #4bc970;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  border-radius: 5px;
  width: 100%;
  border: 1px solid #3ac162;
  border-width: 1px 1px 3px;
  box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
  margin-bottom: 10px;
}

fieldset {
  margin-bottom: 30px;
  border: none;
}

legend {
  font-size: 1.4em;
  margin-bottom: 10px;
}

label {
  display: block;
  margin-bottom: 8px;
}

label.light {
  font-weight: 300;
  display: inline;
}

.number {
  background-color: #5fcf80;
  color: #fff;
  height: 30px;
  width: 30px;
  display: inline-block;
  font-size: 0.8em;
  margin-right: 4px;
  line-height: 30px;
  text-align: center;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
  border-radius: 100%;
}

@media screen and (min-width: 480px) {
  form {
    max-width: 480px;
  }
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5); /* Semi-transparent overlay */
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  max-height: 80vh; /* Set a maximum height */
  overflow-y: auto;
  background: white;
  width: 60%;
  height: auto;
  margin-top: 20px;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(15, 14, 14, 0.3);
}

.button-container {
  display: flex;
  justify-content: space-between;
  margin-top: 10px; /* Adjust margin as needed */
}

.close-button,
.search-button {
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.close-button {
  background-color: #ccc;
}

.search-button {
  background-color: #061106;
  color: white;
}
.search-container {
  position: relative;
}

/* Style for the search input */
.search-input {
  padding: 10px 40px 10px 15px; /* Adjust padding as needed */
  border: 1px solid #ccc; 
  border-radius: 5px; 
  width: 200px; 
  box-sizing: border-box; 
}

.Select {
  display: inline-block;
  margin: 10px;
}

.Select-button {
  padding: 10px;
  background-color: #3498db;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.Select-button:hover {
  background-color: #2980b9;
}
.show {
  display: flex;
  align-items: center;
  font-size: 16px;
}

.show lab {
  margin-right: 10px;
  font-weight: bold;
}

.show span {
  padding: 5px;
  background-color: #e0e0e0;
  border-radius: 3px;
  margin-right: 5px;
}
</style>
