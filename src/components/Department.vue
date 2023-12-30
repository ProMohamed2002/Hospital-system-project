<template>
    <main_header/>
        <div class="contr">
            <div class="box-container">
                <div class="box"  v-for="doctor in doctors" :key="doctor.id">
                    <img src="../assets/Adel.png" alt="doctor's image" >
                    <h3>{{ doctor.user_name }}</h3>
                    <h6>{{ doctor.email_address }}</h6>
                    <h6>{{ doctor.phone_number }}</h6>
                    <router-link to="/Take" class="btn">book an appointmnet</router-link>
                </div>
            </div>
        </div> 
        <Footer/>    
</template>

<script>
    import axios from 'axios';
    import main_header from "./header.vue"
    import Footer from './footer.vue'
    export default {
        name: "Department",
        data() {
            return {
                doctors: []
            }
        },
        components: {
            main_header,
            Footer
        },
        methods: {
            async deleteDoctor(user_name, hospital, department) {
                await axios.delete("http://localhost:8081/customDeleteDoctor", {
                    params: {
                        user_name: user_name,
                        hospital: hospital,
                        department: department
                    }
                });
                location.reload();
            },
            setDoctor(user_name, password) {
                localStorage.setItem("doctorname", user_name);
                localStorage.setItem("doctorpassword", password);
            }
        },
        async mounted() {
            let array = await axios.get("http://localhost:8081/customHospitalAndDepartment", {
                params: {
                    hospital: localStorage.getItem("hospital"),
                    department: localStorage.getItem("department")
                }
            })
            this.doctors = array.data
            console.log(this.doctors)
        },
    }
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,500;0,700;1,200&display=swap');
    *{
        font-family: 'Poppins', sans-serif;
        margin: 0; padding: 0;
        box-sizing: border-box;
        outline: none;
        border: none;
        text-decoration: none;
        text-transform: capitalize;
        transition: .2s linear;
    }
    .contr{
        padding: 100px;
        padding-bottom: 100px;
    }
    .contr .heading{
        text-align: center;
        padding-bottom: 15px;
        margin-bottom: 50px;
        text-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        font-size: 50px;
    }
    .contr .box-container{
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(270px, 1fr));
        gap: 15px;
    }
    .contr .box-container .box{
        box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        border-radius: 5px;
        text-align: center;
        padding: 30px 20px;

    }
    .contr .box-container .box img{
        height: 250px;
    }
    .contr .box-container .box h3{
        color: #444;
        font-size: 22px;
        padding: 10px 0;
    }
    .contr .box-container .box .green-btn{
        margin-top: 10px;
        display: inline-block;
        background: green;
        color: #fff;
        font-size: 17px;
        border-radius: 5px;
        padding: 8px;
        width: 100px;
        margin-right: 5px;
    }
    .contr .box-container .box .red-btn{
        margin-top: 10px;
        display: inline-block;
        background: red;
        color: #fff;
        font-size: 17px;
        border-radius: 5px;
        padding: 8px;
        width: 100px;
        margin-left: 5px;
    }
    .contr .box-container .box .green-btn:hover{
        letter-spacing: 1px;
    }
    .contr .box-container .box .red-btn:hover{
        letter-spacing: 1px;
    }
    .contr .box-container .box:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
    .contr .green-btn-add{
        margin-top: 10px;
        display: inline-block;
        background: green;
        color: #fff;
        font-size: 17px;
        border-radius: 5px;
        padding: 8px;
        width: 200px;
        text-decoration: none;
        text-align: center;
     
    }
    .green-btn-add:hover{
        letter-spacing: 1px;
    }
    .contr .box-container .box .btn{
        margin-top: 10px;
        display: inline-block;
        background: green;
        color: #fff;
        font-size: 17px;
        border-radius: 5px;
        padding: 8px;
    }
    .contr .box-container .box .btn:hover{
        letter-spacing: 1px;
    }
    @media(max-width: 768px) {
        .contr{
            padding: 20px;
        }
    }
</style>
<!-- <style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,500;0,700;1,200&display=swap');
    *{
        font-family: 'Poppins', sans-serif;
        margin: 0; padding: 0;
        box-sizing: border-box;
        outline: none;
        border: none;
        text-decoration: none;
        text-transform: capitalize;
        transition: .2s linear;
    }
    .contr{
        padding: 100px;
        padding-bottom: 100px;
    }
    .contr .heading{
        text-align: center;
        padding-bottom: 15px;
        margin-bottom: 50px;
        text-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        font-size: 50px;
    }
    .contr .box-container{
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(270px, 1fr));
        gap: 15px;
    }
    .contr .box-container .box{
        box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        border-radius: 5px;
        text-align: center;
        padding: 30px 20px;

    }
    .contr .box-container .box img{
        height: 250px;
    }
    .contr .box-container .box h3{
        color: #444;
        font-size: 22px;
        padding: 10px 0;
    }
    .contr .box-container .box .btn{
        margin-top: 10px;
        display: inline-block;
        background: green;
        color: #fff;
        font-size: 17px;
        border-radius: 5px;
        padding: 8px;
    }
    .contr .box-container .box .btn:hover{
        letter-spacing: 1px;
    }
    .contr .box-container .box:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
    @media(max-width: 768px) {
        .contr{
            padding: 20px;
        }
    }
</style> -->