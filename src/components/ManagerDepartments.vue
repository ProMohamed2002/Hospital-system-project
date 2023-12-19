<template>
    <main_header/>
    <div class="cotr">
            <div class="department" v-for="d in this.departements" :key="d.id">
                <router-link class="department-name" to="/ManagerDoctors" @click="setDepartment(d.name)">{{ d.name }}</router-link>
                <img class= "delete-icon" src="../assets/icons8-cancel-48.png" alt="delete department" @click="deleteDepartment(d.name, d.hospital)">
            </div>
            <router-link class="green-btn-add" to="/AddDepartment">add new departement</router-link>
    </div>
    <Footer/>
</template>

<script>
    import axios from 'axios';
    import main_header from './header.vue'
    import Footer from './footer.vue'
    export default {
        name: 'ManagerDepartments',
        data() {
            return {
                departements: []
            }
            
        },
        components: {
            main_header,
            Footer
        },
        methods: {
            setDepartment(departement) {
                localStorage.setItem("department", departement)
            },
            async deleteDepartment(name, hospital) {
                await axios.delete("http://localhost:8081/customDeleteDepartment", {
                    params: {
                        name: name,
                        hospital: hospital
                    }
                });
                location.reload();
            }
        },
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let array = await axios.get("http://localhost:8081/customHospital", {
                params: {
                    hospital: localStorage.getItem("hospital")
                }
            })
            this.departements = array.data
            console.log(this.departements)
        }
    }
</script>

<style>
    .cotr {
        display: grid;
        margin-top: 30px;
        gap: 15px;
    }
    .cotr .department{
        
        box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
        border-radius: 5px;
        padding: 30px 20px;
        width: 90%;
        height: 120px;
        margin-top: 30px;
        margin: auto;
    }
    .cotr .department .department-name{
        text-decoration: none;
        color: #1376ab;
        font-size: large;
        stroke-width: 10px;
        font-size: 30px;
    }
    .cotr .department .department-name:hover{
        letter-spacing: 1px;
    }
    .cotr .department:hover{
        box-shadow: 0 10px 15px rgba(0, 0, 0, .3);
        transform: scale(1.02);
    }
    @media(max-width: 768px) {
        .cotr{
            padding: 20px;
        }
    }
    .delete-icon {
        float: right;
    }
    .delete-icon:hover {
        cursor: pointer;
        width: 50px;
    }

    .edit-btn {
        background: green;
        color: #fff;
        font-size: 23px;
        border-radius: 5px;
        padding: 8px;
        width: max-content;
        float: right;
        margin-right: 20px;
    }
    .edit-btn:hover {
        cursor: pointer;
        letter-spacing: 1px;
    }
    .cotr .green-btn-add{
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
</style>