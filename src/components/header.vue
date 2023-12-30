<template>
    <div class="header" :class="{ 'fixed': isFixed }">
      <div class="container">
        <ul class="link">
          <li><div class="operation" @click="home">Home</div></li>
          <li><div class="operation" @click="profile">Profile</div></li>
          <li><router-link class="operation" @click="logout" to="/">Logout</router-link></li>
        </ul>
      </div>
    </div>
  </template>
<script>
export default{
    name : 'main_header',
    data(){
        return{
            isFixed: false,
        }
    },
    mounted() {
    window.addEventListener('scroll', this.handleScroll);
     },
    beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll);
      },
    methods: { 
        handleScroll() {
      this.isFixed = window.scrollY > 0;
    },
        logout() {
            localStorage.setItem("user_name", "");
            localStorage.setItem("password", "");
            localStorage.setItem("user_type", "");
        },
        home() {
            if(localStorage.getItem("user_type") === "patient") {
                this.$router.push("/PatientHome");
            }
                
            else if(localStorage.getItem("user_type") === "doctor") {
                this.$router.push("/DoctorHome");
            }
                else if(localStorage.getItem("user_type") === "manager") {
                this.$router.push("/ManagerHome");
            }
        },
        profile() {
            if(localStorage.getItem("user_type") === "patient") {
                this.$router.push("/PatientEditProfile");
            }
                
            else if(localStorage.getItem("user_type") === "doctor") {
                this.$router.push("/DoctorEditProfile");
            }
                else if(localStorage.getItem("user_type") === "manager") {
                this.$router.push("/ManagerEditProfile");
            }
        }

    }
  }
</script>
<style scoped>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;

}
body{
    font-family: Arial, Helvetica, sans-serif;
}
.header {
  background-color: #1376ab;
  position: relative;
  z-index: 1000;
  transition: background-color 0.3s ease;
}

.fixed {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.container {
  max-width: 1170px;
  margin: auto;
}

.link {
  display: flex;
  justify-content: center;
  align-items: center;
  list-style: none;
  margin: 0;
}

.link li {
  margin: 0 15px;
}

.operation {
  text-decoration: none;
  color: white;
  padding: 10px;
  transition: all 0.3s ease;
  cursor: pointer;
}

.operation:hover {
  background-color: #0d5f8b;
  border-radius: 5px;
}
</style>
