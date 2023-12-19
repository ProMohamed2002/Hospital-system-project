<template>
    <div>
        <main_header/>
        <div class="hospital">
                <router-link class="hospital-name" to="/HospitalInfo">{{ hospital.name }}</router-link>
                <h6> {{ hospital.email_address }}</h6>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import axios from 'axios';
    import main_header from './header.vue'
    import Footer from './footer.vue'
    export default {
        name: 'PatientSearchResults',
        data() {
            return {
                hospital: {},
            }
        },
        components: {
            main_header,
            Footer
        },
        async mounted() {
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
    }
    .hospital .hospital-name{
        text-decoration: none;
        color: #1376ab;
        font-size: large;
        stroke-width: 10px;
        font-size: 30px;
    }
    .hospital .hospital-name:hover{
        letter-spacing: 1px;
    }
    .hospital:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
</style>