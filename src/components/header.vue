<template>
    <div class="header">
        <div class="container">
        <div class="logo">
            <i class="fa-solid fa-hand-holding-medical" style="font-size:50px"></i>
        </div>
            <ul  class="link">
                <li><router-link to="/">Home</router-link></li>
                <li><router-link to="/">contact</router-link></li>
                <li><router-link to="/">about</router-link></li>
                <li><router-link to="/pay">Pay</router-link></li>
            </ul>

    </div>
    </div>
    <div class="search">
        <div class="boxh">

        <div class="searching">
        <label for="#s1">name of hospital</label>
        <input id="#s1" type="text" placeholder="name of hospital" v-model="hospital">
        <button @click="setHospital(hospital)">search</button>
        <div class="sign"> <i class="fa-solid fa-user" style="font-size: 15px ;color:#fff;"></i><a href="#sign up">Sign up</a></div>
    </div>
    </div>
    
    </div>
</template>
<script>
export default{
    name : 'main_header',
    data() {
        return {
            hospital: "",
        }
    },
    methods: {
        setHospital(hospital) {
            localStorage.setItem("hospital", JSON.stringify(hospital));
        } 
    },
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
   }
.link{
    display:flex;
    flex-wrap: wrap;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    color: black;

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
    bottom: -5px;
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
a{
    text-decoration: none;
    color: black;
    padding-right: 4px;
    transition: all 0.3s ease;
}
.header  a:hover{
    padding-right: 5px;
    color: #ffffffff;
}
.search{
    background-color: #1376ab;
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