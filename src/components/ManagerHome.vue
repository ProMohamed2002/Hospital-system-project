<template>
    <div>
        <main_header/>
        <div class="search-hospital">
            <input type="text" class="search-box" v-model="hospital" placeholder=" search..." list="hospital-list">
            <datalist id="hospital-list">
            <option v-for="hospital in filteredHospitals" :value="hospital.name" :key="hospital.id"></option>
            </datalist>
            <div class="bo" >
                <select v-model="searchby" name="serchby" class="custom-select">
                    <option disabled value="">Search by</option>
                    <option value="Doctor">Doctor</option>
                    <option value="Hospital">Hospital</option>
                  </select>
            <button class="search-button" @click="search">search</button>

        </div>
        </div>
       
        <div class="ctr">
            <router-link class="green-btn-add" to="/AddHospital">add new hospital</router-link>

            <h class="animated-heading">Hospitals</h>
            <div class="hospital" v-for="h in this.hospitals" :key="h.id">
                <div class="name">
                    <router-link class="hospital-name" to="/ManagerDepartments" @click="department(h.name)">{{ h.name }}</router-link>
                    <h6> {{ h.email_address }}</h6>
                </div>
                <div class="options">
                    <img class= "delete-icon" src="../assets/icons8-cancel-48.png" alt="delete hospital" @click="deleteHospital(h.name)">
                    <router-link @click="setHospital(h.name)" to="/EditHospital" class="edit-btn"> edit </router-link>
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
                searchby:'',
            }
        },
        components: {
            main_header,
            Footer
        },
        methods: {
            search() {
                const selectedHospital = this.hospitals.find(hospital =>
            hospital.name.toLowerCase() === this.hospital.toLowerCase()
            );
            console.log(selectedHospital.name)
                localStorage.setItem("hospital", selectedHospital.name);
                this.$router.push("/ManagerSearchResults");
            },
            department(hospitalName) {
                localStorage.setItem("hospital", hospitalName);
            },
            setHospital(hospitalName) {
                localStorage.setItem("hospital", hospitalName) 
            },
            async deleteHospital(hospitalName) {
                await axios.delete(`http://localhost:8081/customDeleteHospital?name=${hospitalName}`);
                location.reload();
            }
        },
        computed: {
    filteredHospitals() {
      if (this.hospital === "") {
        return this.hospitals; // Return all hospitals if search query is empty
      } else {
        const hospital = this.hospital.toLowerCase();
        return this.hospitals.filter(hospitall =>
          hospitall.name.toLowerCase().includes(hospital)
        );
      }
    },
},
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let array = await axios.get("http://localhost:8081/customFetchHospital")
            this.hospitals = array.data
            console.log(this.hospitals)
        }        
    }
</script>

<style>
.custom-select {
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background-color: blanchedalmond;
    margin-left: 510px;
    width: 500px;
    height: 30px;
    border: 1px solid #ccc;
    border-radius: 5px;
    position: relative;
    cursor: pointer;
}


.custom-select::after {
    content: '▼'; 
    font-size: 10px;
    color: #333; 
    position: absolute;
    top: 50%;
    right: 10px;
    transform: translateY(-50%);
    pointer-events: none; 
  }
  
  .custom-select:hover, .custom-select:focus {
    border-color: #666;
  }
  
  .custom-select::-moz-focus-inner {
    border: 0;
  }
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
        margin-top: 5px;
        width: 200px;
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
    @keyframes colorChange {
        0% { color: #3498db; }
        50% { color: #e74c3c; }
        100% { color: #3498db; }
      }
  
      .animated-heading {
        font-family: 'Arial', sans-serif;
        font-size: 32px;
        animation: colorChange 4s infinite;
        border: 2px solid #3498db;
        padding: 10px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
      }
</style>