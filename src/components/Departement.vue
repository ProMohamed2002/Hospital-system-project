<template>
    <main_header/>
        <div class="contr">
            <h1 class="heading">Welcome to {{ departement }} departement</h1>
            <div class="box-container">
                <div class="box"  v-for="doctor in doctors" :key="doctor.id">
                    <img src="../assets/Adel.png" alt="doctor's image" >
                    <h3>{{ doctor.name }}</h3>
                    
                    <router-link to="#" class="btn">book an appointmnet</router-link>
                </div>
            </div>
        </div>      
    <FooTer/>
</template>

<script>
    import main_header from "./header.vue" 
    import FooTer from "./footer.vue" 
    import axios from "axios"
    export default {
        name: "Departement",
        components:{
            main_header,
            FooTer
        },
        data() {
            return {
                departement: '',
                departementsArray: [],
                hospital: '',
                doctors: [],
                imagepath: ""
            }
        },

        async mounted() {
            let departement = localStorage.getItem("departement");
            this.departement = departement.trim()
            let hospital = localStorage.getItem("hospital")
            this.hospital = hospital.trim()
            console.log(this.hospital, typeof this.hospital, this.departement, typeof this.departement)
            let result = await axios.get(
                `https://my-json-server.typicode.com/Yahia-Ibrahim/my_Database/main/db.json/hospitals`
            )
            if(result.status == 200 && result.data.length>0) {
                    console.warn(result.data)
                    let hospitals = result.data
                    let hospital = this.filteredHospitals(hospitals)[0]
                    this.departementsArray = hospital["departements"]
                    this.doctors = this.filteredDepartement.length > 0 ? this.filteredDepartement[0].doctors : [];
                    console.warn(this.filteredDepartement)
            }
        },
        methods: {
            filteredHospitals(hospitalsArray) {
                return hospitalsArray.filter((hospital) => {
                    return JSON.stringify(hospital.name) == this.hospital;
                });
            },
            lowerCased(data) { 
                let lower = [] 
                data.split(' ').forEach(word => { 
                    lower.push(word.toLowerCase()) 
                }) 
                return lower.join(' ') 
            }, 
            assignImage(doctor) {
                this.imagepath = this.lowerCased(doctor.imagepath)
            }
        },
        computed: {
            filteredDepartement() {
                return this.departementsArray.filter((departement) => {
                    return JSON.stringify(departement.name) == this.departement;
                });
            },            
        }
        
    }
</script>

<style>
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
</style>