<template>
    <main_header/>
    <center><h1>add new departement</h1></center>
    <form @submit="submit">
        <label>department name:</label>
        <select name="departments" v-model="name">
            <option>Internal medicine</option>
            <option>Pediatrics </option>
            <option>General surgery</option>
            <option>Neurology</option>
            <option>Urology</option>
            <option>Physical therapy</option>
            <option>Ophthalmology</option>
            <option>Obstetrics and gynaecology</option>
            <option>Orthopedic</option>
            <option>dermatology</option>
        </select>
        <input type="submit" class="add-btn" value="add department">
    </form>
    <Footer/>
</template>

<script>
    import axios from 'axios'
    import main_header from './header.vue'
    import Footer from './footer.vue'
    export default {
        name: "ManagerAddDepartment",

        data() {
            return {
                name: '',
            }
        },
        methods: {
            submit() {
                console.log("submitted")
                let department = axios.post(`http://localhost:8081/addDepartment`, 
                {
                    name: this.name,
                    hospital: localStorage.getItem("hospital")
                });
                console.log(department)
                this.$router.push("/ManagerDepartments");
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
form select {
    width: 500px;
    height: 50px;
    margin: 20px;
    border: 2px solid skyblue;
    border-radius: 5px;
}
form select:invalid {
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