<template>
    <main_header/>
    <div style=" margin:auto;">
      <h1 style="margin: auto; margin-left: 47%; margin-top: ;">{{hospital}}</h1>
  
      <div class="analysiz" style="margin: 100px auto; width:700px;">
        <div class="block">
            <label>intensive care beds</label>
            <blockquote>{{ Number_of_beds_in_care }} </blockquote>
        </div>
        <div class="block">
            <label style="margin-left: 27px;">clinics</label>
            <blockquote>{{ Number_of_department }} </blockquote>
        </div>
        <div class="block">
            <label>doctores registered</label>
            <blockquote>{{ Number_of_doctor }} </blockquote>
        </div>
      </div>
    </div>
    <div class="cotr">
            <div class="department" v-for="d in this.departments" :key="d.id">
                <router-link class="department-name" to="/department" @click="setDepartment(d.name)">{{ d.name }}</router-link>
            </div>
    </div>
    <Footer/>
  </template>
  
  <script>
  
    import main_header from './header.vue'
    import axios from 'axios'
    import Footer from './footer.vue'
    export default {
    name:'HospitalInfo',
    data() {
      return {
        hospital:'',
        Number_of_beds_in_care: 0,
        Number_of_department: 0,
        Number_of_doctor: 0,
        departments:[],
        }
       
    },
    components: {
        main_header,
        Footer
    },
    methods: {
        setDepartment(departement) {
                localStorage.setItem("department", departement)
        },
    },
    async mounted() {
            let array = await axios.get("http://localhost:8081/customHospital", {
                params: {
                    hospital: localStorage.getItem("hospital")
                }
            })
            this.departments = array.data
            console.log(this.departments)

            let hospital = await axios.get("http://localhost:8081/customName", {
                params: {
                    name: localStorage.getItem("hospital")
                }
            })
            const h = hospital.data
            this.Number_of_beds_in_care = h.intensive_care_beds,
            this.Number_of_department = h.clinics_number,
            this.Number_of_doctor = h.doctors_number
            console.log()
        }
    

}
</script>
  
  <style>
    /* Add your styles here */
    .analysiz{
        display: flex;
        flex-direction: row;
        gap: 10px;
        margin:auto;
        justify-content: center;
    }
    .departments{
      display: flex;
      flex-direction: column;
      gap: 10px;
    }
    blockquote {
      width: 100px;
      height: 100px;
      border: 10px solid rgba(255, 0, 0, 0.785);
      border-radius: 50%;
      padding: 10px;
      margin: auto;
      margin-top: 5px;
      transition: all 0.4s ease; 
      /* padding-left: 32px;
      padding-top: 18px; */
      padding: auto;
      font-size: x-large;
  }
  blockquote:hover {
      margin-top: 1px; /* Move the blockquote down by 20 pixels on hover */
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.9); /* Add a subtle box shadow on hover */
      cursor: pointer;
  }
  .block{
    display:flex;
    flex-direction: column;
    gap: 5px
  }
  .cotr {
        display: grid;
        margin-top: 30px;
        gap: 15px;
    }
    .cotr .department{
        
        box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        border-radius: 5px;
        border: 2px skyblue;
        padding: 30px 20px;
        width: 90%;
        height: 120px;
        margin-top: 30px;
        margin: auto;
        background-color: lightgrey;
    }
    .cotr .department .department-name{
        text-decoration: none;
        color: #1376ab;
        font-size: large;
        stroke-width: 10px;
        font-size: 30px;
    }
    .cotr .department .department-name:hover{
        letter-spacing: 1px;
    }
    .cotr .department:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
    @media(max-width: 768px) {
        .cotr{
            padding: 20px;
        }
    }
  </style>
  