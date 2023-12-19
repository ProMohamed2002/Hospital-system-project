<template>
  <div>
      <main_header/>
      <div class="search-hospital">
          <input type="text" class="search-box" v-model="hospital" placeholder="search for hospital by name">
          <button class="search-button" @click="search">search</button>
      </div>
      <div class="ctr">
          <div class="hospital" v-for="h in this.hospitals" :key="h.id">
              <div class="name">
                  <router-link class="hospital-name" to="/HospitalInfo" @click="department(h.name)">{{ h.name }}</router-link>
                  <h6> {{ h.email_address }}</h6>
              </div>
          </div>
      </div>
      <Footer/>
  </div>
</template>
<script>
  import axios from 'axios';
  import main_header from './header.vue'
  import Footer from './footer.vue'
  export default {
      name : 'ManagerHome',
      data() {
          return {
              hospital:"",
              hospitals: [],
          }
      },
      components: {
          main_header,
          Footer
      },
      methods: {
          search() {
              localStorage.setItem("hospital", this.hospital);
              this.$router.push("/PatientSearchResults");
          },
          department(hospitalName) {
              localStorage.setItem("hospital", hospitalName);
          },
          setHospital(hospitalName) {
              localStorage.setItem("hospital", hospitalName) 
          },
      },
      async mounted() {
          let array = await axios.get("http://localhost:8081/customFetchHospital")
          this.hospitals = array.data
          console.log(this.hospitals)
      }

      
  }
</script>

<style>
  .search-hospital {
      justify-content: center;
     
      margin-top: 20px;
      margin: 0 auto;
      margin-left: auto;
      margin-right: auto;
      
  }
  .search-hospital .search-box{
  
      width: 500px;
      height: 50px;
      margin-top: 20px;
      display: block;
      margin-left: auto;
      margin-right: auto;
      border: 2px solid skyblue;
      
  }
  .search-hospital .search-button{
      height: 30px;
      display: block;
      margin-left: auto;
      margin-right: auto;
      width: 500px;
      background-color: #1376ab;
      color: white;
      font-size: large;
  }
  .search-hospital .search-button:hover {
      letter-spacing: 1px;
      font-size: large;
  }
  .ctr {
      display: grid;
      margin-top: 30px;
      gap: 15px;
  }
  .ctr .hospital{
      
      box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
      border-radius: 5px;
      padding: 30px 20px;
      width: 90%;
      height: 120px;
      margin-top: 30px;
      display: flex;
      direction: flex-row;
      margin: auto;
  }
  .ctr .hospital .name{
      width: 50%;
  }
  .ctr .hospital .name .hospital-name {
      text-decoration: none;
      color: #1376ab;
      font-size: large;
      stroke-width: 10px;
      font-size: 30px;
      
  }
  .ctr .hospital .name .hospital-name:hover{
      letter-spacing: 1px;
  }
  .ctr .hospital:hover{
      box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
      transform: scale(1.02);
  }
  .ctr .hospital .options{
      justify-content: right;
      float: right;
      width: 50%;
      
  }
  .ctr .hospital .options .delete-icon {
      float: right;
      
  }
  .ctr .hospital .options .delete-icon:hover {
      cursor: pointer;
      width: 50px;
  }

  .ctr .hospital .options .edit-btn {
      background: green;
      color: #fff;
      font-size: 23px;
      border-radius: 5px;
      padding: 8px;
      width: max-content;
      margin-right: 20px;
      text-decoration: none;
      
  }
  .ctr .hospital .options .edit-btn:hover {
      cursor: pointer;
      letter-spacing: 1px;
  }
  .ctr .green-btn-add{
      margin-top: 10px;
      display: inline-block;
      background: green;
      color: #fff;
      font-size: 17px;
      border-radius: 5px;
      padding: 8px;
      width: 200px;
      margin-left: 75px;
      float: none;
      text-align: center;
      text-decoration: none;
  }
  
  .green-btn-add:hover{
      letter-spacing: 1px;
      transform: scale(1.02);
  }
</style>