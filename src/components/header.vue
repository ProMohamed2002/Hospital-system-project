<template>
    <div class="header">
        <div class="container">
        <div class="logo"><img src="../assets/ministryofhealth.png" alt="">
        </div>
            <ul  class="link">
                <li><div class="operation" @click="home">Home</div></li>
                <li><div class="operation" @click="profile">profile</div></li>
                <li><router-link class="operation" @click="logout" to="/">logout</router-link></li>
            </ul>
    </div>
    </div>
</template>
<script>
export default{
    name : 'main_header',
    methods: { 
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
.header{
    background-image: url('../assets/23018.jpg');
    opacity: 0.8;
    background-size: 100% 320px;
    background-position: center;
    margin: 0;
    background-color:#1376ab ;
    position: relative;
    height: 100hv;
    width: 100%;
}
.container{
    max-width: 1170px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    padding:10px 50px;
    margin: auto;
}
.logo{
   font-size: 60px;
   padding:0 10px;
   color: rgb(241, 241, 241);
    width:50px;
}
.link{
    display:flex;
    flex-wrap: wrap;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    color: black;
    background-color: lightgray;
    margin-top: 272px;

}
.header li{
    padding-left: 10px;
    margin-left:30px ;
    list-style: none;
    text-decoration:none;
    font-weight: 500;
    font-size:larger;
    transition: 0.2s;
    
    
}
li::before{
    content: '';
    position:absolute;
    bottom: -5;
    left:1;
    background-color: #f1e6e6;
    height: 2px;
    box-sizing: border-box;
    width:0;
    transition: width 0.3s ease;

}
li:hover::before{
    width: 30px;
}
.operation{
    text-decoration: none;
    color: black;
    padding-right: 4px;
    transition: all 0.3s ease;
}
.header  .operation:hover{
    padding-right: 5px;
    color: #ffffffff;
    cursor: pointer;
}
.search{
    background-color: #1376ab;
    margin-bottom: 5px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 10px;
    padding-bottom: 6px;
}
.boxh{
    max-width: 400px;
}
@media (max-width: 767px){ 
}
label{
    padding-left: 0;
    color: #fff;
    font-size: larger;
    font-weight: bold;
}
label:hover{
    cursor: pointer;
}
input{
    border : 2px solid #fff;
    width:300px;
    height: 30px;
}
button{
    height: 30px;
    color: #fff;
    width: 60px;
    margin-left: 2px;
    background: #072230;
    border: 2px solid transparent;
}
button:hover{
    cursor:pointer;
}
.sign{
    margin-top: 3px;
}
.sign a{
    color: #fff;
    margin-left: -10;
    padding-left: 6px;
    font-family: Arial, Helvetica, sans-serif;
    font-size:13px ;

}
</style>