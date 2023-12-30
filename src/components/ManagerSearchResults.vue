<template>
    <div>
        <main_header/>
        <div class="hospital">
                <div class="hospital-name">
                    <router-link class="hospital-name" to="/ManagerDepartments">{{ hospital.name }}</router-link>
                    <h6> {{ hospital.email_address }}</h6>
                </div>
                <div class="options">
                    <img class= "delete-icon" src="../assets/icons8-cancel-48.png" alt="delete hospital" @click="deleteHospital(h.name)">
                    <router-link @click="setHospital(this.name)" to="/EditHospital" class="edit-btn"> edit </router-link>
                </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import main_header from './header.vue'
    export default {
        name: 'ManagerSearchResults',
        data() {
            return {
                hospital: {},
                name: ''
            }
        },
        components: {
            main_header
        },
        methods: {
            setHospital(hospitalName) {
                localStorage.setItem("hospital", hospitalName) 
            },
        },
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let hospitalName = '' 
            hospitalName = localStorage.getItem("hospital");
            console.log(hospitalName);
            let h = await axios.get('http://localhost:8081/customName', {
                params: {
                    name: hospitalName
                }
            });
            console.log(h)
            this.hospital = h.data
            this.name = this.hospital.name
        }
    }
</script>

<style>
    .ctr {
        display: grid;
        margin-top: 30px;
        gap: 15px;
    }
    .hospital{
        
        box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        border-radius: 5px;
        padding: 30px 20px;
        width: 90%;
       
        height: 120px;
        margin-top: 30px;
        margin: auto;
        display: flex;
        flex-direction: row;
    }
    .hospital .hospital-name{
        text-decoration: none;
        color: #1376ab;
        font-size: large;
        stroke-width: 10px;
        font-size: 30px;
        width: 50%;
    }
    .hospital .hospital-name:hover{
        letter-spacing: 1px;
    }
    .hospital:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
    .hospital .options{
        width: 50%;
    }
    .hospital .options .delete-icon {
      float: right;
      
    }
    .hospital .options .delete-icon:hover {
        cursor: pointer;
        width: 50px;
    }

    .hospital .options .edit-btn {
        background: green;
        color: #fff;
        font-size: 23px;
        border-radius: 5px;
        padding: 8px;
        width: max-content;
        margin-right: 20px;
        text-decoration: none;
        
    }
    .hospital .options .edit-btn:hover {
        cursor: pointer;
        letter-spacing: 1px;
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

        margin: 50px;
      }
</style>