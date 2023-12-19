<template>
    <main_header/>
    <center><h1>add new doctor</h1></center>
    <form @submit="submit">
        <label>user name:</label>
        <input type="text" inputmode="text" placeholder="doctor name" required v-model="this.name">
        <label>email address:</label>
        <input type="email" inputmode="text" placeholder="email address" required v-model="this.email">
        <label>password:</label>
        <input type="text" inputmode="text" placeholder="password" required v-model="this.password">
        <label>telephone number:</label>
        <input type="tel" placeholder="88888888888" pattern="[0-9]{11}" required v-model="this.tel">
        <label>birth date:</label>
        <input type="date" pattern="\d{4}/\d{1,2}/\d{1,2}" required v-model="this.birthDate">
        <label>civil id:</label>
        <input type="text" inputmode="number" pattern="[0-9]{14}" placeholder="88888888888888" required v-model="this.civilID">
        <label>academic degree:</label>
        <input type="text" placeholder="academic degree" v-model="this.academicDegree">
        <input type="submit" class="add-btn" value="add doctor">
    </form>
    <Footer/>
</template>

<script>
    
    import main_header from './header.vue'
    import axios from 'axios'
    import Footer from './footer.vue'
    export default {
        name: "ManagerAddDoctor",

        data() {
            return {
                name: '',
                email:'',
                password:'',
                tel: '',
                birthDate: '',
                civilID: '',
                academicDegree: '',
            }
        },
        methods: {
            submit() {
                console.log("submitted")
                let doctor = axios.post(`http://localhost:8081/addDoctor`, 
                {
                    user_name: this.name,
                    email_address: this.email,
                    password: this.password,
                    phone_number: this.tel,
                    birth_date: this.birthDate,
                    civil_id: this.civilID,
                    description: this.academicDegree,
                    hospital: localStorage.getItem("hospital"),
                    department: localStorage.getItem("department")
                });
                console.log(doctor.data)
                this.$router.push("/ManagerDoctors");
            }
        },
        components: {
            main_header,
            Footer
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
    font-weight: bold;
    letter-spacing: 1px;
    font-size: large;
}
form .add-btn{
    background-color: #1376ab;
    color: white;
    font-size: large;
}

</style>