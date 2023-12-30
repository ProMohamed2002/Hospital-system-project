<template>
    <main_header/>
    <center><h1>profile</h1></center>
    <form @submit="submit">
        <label>user name:</label>
        <input type="text" inputmode="text" placeholder="user name" required v-model="this.name" readonly style="background-color: skyblue;">
        <label>National id:</label>
        <input type="text" inputmode="number" pattern="[0-9]{14}" placeholder="88888888888888" required v-model="this.civilID" readonly style="background-color: skyblue;">
        <label>birth date:</label>
        <input type="date" required v-model="this.birthDate" readonly style="background-color: skyblue;">
        <label>email address:</label>
        <input type="email" inputmode="text" placeholder="email address" required v-model="this.email">
        <label>password:</label>
        <input type="text" inputmode="text" placeholder="password" required v-model="this.password">
        <label>telephone number:</label>
        <input type="tel" placeholder="88888888888" pattern="[0-9]{11}" required v-model="this.tel">
        <input type="submit" class="add-btn" value="save changes">
    </form>
    <Footer/>
</template>

<script>
    import axios from 'axios'
    import main_header from './header.vue'
    import Footer from './footer.vue'
    export default {
        name: "PatientEditProfile",

        data() {
            return {
                name: '',
                email:'',
                password:'',
                tel: '',
                birthDate: '',
                civilID: ''
            }
        },
        components: {
            main_header,
            Footer
        },
        methods: {
            async submit() {
                let patient = axios.post(`http://localhost:8081/customUpdateManager`, 
                {
                    user_name: this.name,
                    email_address: this.email,
                    password: this.password,
                    phone_number: this.tel,
                    birth_date: this.birthDate,
                    civil_id: this.civilID
                });
                console.log(patient)
                this.$router.push("/PatientHome");

            }
        },
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let patient = await axios.get("http://localhost:8081/customManagerNameAndPassword", {
                params: {
                    user_name: localStorage.getItem("user_name"),
                    password: localStorage.getItem("password")
                }
            })
            const p = patient.data
            this.name = p.user_name,
            this.email = p.email_address,
            this.password = p.password,
            this.tel = p.phone_number,
            this.birthDate = p.birth_date,
            this.civilID = p.civil_id,
            console.log(p)
        }

    }
</script>

<style scoped>
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
    margin: auto;
    border: 2px solid skyblue;
    border-radius: 5px;
}
form input:invalid {
  border: 2px solid red;
}
form label{
    font-weight: bold;
    font-size: 30px;
    margin-left: 510px;
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