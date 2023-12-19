<template>
    <main_header/>
    <center><h1>edit hospital</h1></center>
    <form @submit="submit">
        <label>name:</label>
        <input type="text" inputmode="text" placeholder="hospital name" required v-model="this.name" readonly style="background-color: skyblue;">
        <label>telephone number:</label>
        <input type="tel" placeholder="+88 88888888" pattern="[0-9]{2} [0-9]{8}" required v-model="this.tel">
        <label>number of doctors:</label>
        <input type="number" placeholder="0" min="1" max="10000" required v-model="this.doctors_number">
        <label>clinics number:</label>
        <input type="number" placeholder="clinics number" min="1" max="1000" required v-model="this.clinics">
        <label>intensive care beds:</label>
        <input type="number" placeholder="number of intensive care beds" min="1" max="10000" required v-model="this.beds">
        <input type="submit" class="add-btn" value="save changes">
    </form>
    <Footer/>
</template>

<script>
    
    import axios from 'axios';
import main_header from './header.vue'
import Footer from './footer.vue'
    export default {
        name: "ManagerEditHospital",

        data() {
            return {
                hospital: {},
                name: '',
                tel: '',
                clinics: 0,
                beds: 0,
                doctors_number: 0
            }
        },

        components: {
            main_header,
            Footer
        },
        methods: {
            async submit() {
                console.log(this.name, this.tel, this.clinics, this.beds)
                let hospital = axios.post(`http://localhost:8081/customUpdateHospital`, 
                {
                    name: this.name,
                    email_address: "+" + this.tel,
                    doctors_number: this.doctors_number,
                    clinics_number: this.clinics,
                    intensive_care_beds: this.beds
                });
                console.log(hospital)
                this.$router.push("/ManagerHome");

            }
        },
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let hospital = await axios.get("http://localhost:8081/customName", {
                params: {
                    name: localStorage.getItem("hospital")
                }
            })
            
            this.hospital = hospital.data
            console.log(this.hospital)
            this.name = this.hospital.name;
            this.tel = this.hospital.email_address.substring(1);
            this.clinics = this.hospital.clinics_number;
            this.beds = this.hospital.intensive_care_beds;
            this.doctors_number = this.hospital.doctors_number;
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