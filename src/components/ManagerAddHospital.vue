<template>
    <main_header/>
    <center><h1>add new hospital</h1></center>
    <form @submit="submit">
        <label>name:</label>
        <input type="text" inputmode="text" placeholder="hospital name" required v-model="this.name">
        <label>telephone number:</label>
        <input type="tel" placeholder="+88 88888888" pattern="[0-9]{2} [0-9]{8}" required v-model="this.tel">
        <label>clinics number:</label>
        <input type="number" placeholder="clinics number" min="1" max="1000" required v-model="this.clinics">
        <label>intensive care beds:</label>
        <input type="number" placeholder="number of intensive care beds" min="1" max="10000" required v-model="this.beds">
        <input type="submit" class="add-btn" value="add hospital">
    </form>
    <Footer/>
</template>

<script>
    
    import axios from 'axios'
import main_header from './header.vue'
import Footer from './footer.vue'
    export default {
        name: "ManagerAddHospital",

        data() {
            return {
                name: '',
                tel: '',
                clinics: 0,
                beds: 0
            }
        },

        components: {
            main_header,
            Footer
        },
        methods: {
            submit() {
                console.log("submitted")
                let hospital = axios.post(`http://localhost:8081/addHospital`, 
                {
                    name: this.name,
                    email_address: "+" + this.tel,
                    doctors_number: 0,
                    clinics_number: this.clinics,
                    intensive_care_beds: this.beds
                });
                console.log(hospital)
                this.$router.push("/ManagerHome");
            }
        },
        mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
        }

    }
</script>

<style>
h1{
    font-size: 50px;
    font-weight: bold;
}
form{
    display: grid;
}
form input {
    width: 500px;
    height: 50px;
    margin: 20px;
    border: 2px solid skyblue;
    border-radius: 5px;
}
form input:invalid {
  border: 2px solid red;
}
form label{
    font-weight: bold;
    font-size: 30px;
    margin-left: 30px;
}

form .add-btn:hover {
    letter-spacing: 1px;
    font-size: large;
}
form .add-btn{
    background-color: #1376ab;
    color: white;
    font-size: large;
}

</style>