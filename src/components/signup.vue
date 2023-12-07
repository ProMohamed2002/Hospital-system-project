
<script>
import main_header from "./header.vue" 
 import FooTer from "./footer.vue" 
 import axios from "axios"
   export default{
    name:'signup',
    components:{
            main_header,
            FooTer
        },
    data(){
        return{
            hospitals:[],
            input_catagorey:"",
              email:"",
            password:"",
            
        };

    },
    methods: {
      async signUp() {
                let result = await axios.post("https://my-json-server.typicode.com/Yahia-Ibrahim/my_Database/main/db.json/users/",{
                    name:this.name,
                    email:this.email,
                    password:this.password
                });
                console.warn(result);
                if(result.status == 201) {
                    localStorage.setItem("user-info", JSON.stringify(result.data));
                    this.$router.push( {name: "Home"} );
                }
            },
        goTohome() {
      this.$router.push("/");
    }
    }, 
    
    }
</script>

<template>
<main_header/>
  <form class="card" style="padding-top:10px" @submit.prevent="signUp()">
    <div class="name"><input type="text" placeholder="enter your name" v-model="name"/></div>
    <div class="mail"><input type="email" placeholder="email" v-model="email"/></div>
    <div class="password"><input type="password" placeholder="password" v-model="password"/></div>
  <div >
      <label class="bb" >
        <input type="radio" value="doctor" v-model="input_catagorey" />
        <div class="font">Doctor</div>
      </label>
     <label class="bb" >
        <input type="radio" value="manager" v-model="input_catagorey" />
        <div class="font">Manager</div>
      </label>
      <label class="bb" >
        <input type="radio"  value="patient" v-model="input_catagorey" />
        <div class="font">Patient</div>
      </label>
    </div>
     
      <button type="submit" class="submit" @click="signUp()"  >sign up</button>
      <div class="anchors">
      </div>
      <div class="anchors">already have acount <router-link to="/login">login</router-link></div>
    </form>
  
  <FooTer/>

</template>

<style>

.mail
{
  margin : 20px 0 0 0;

  display: block;

}
.password
{
  margin-top: 20px;
  
}
.submit
{
  font-size:medium;
  font-weight: bold;
  margin-top: 20px;
  display: block;
  margin-right: auto;
  border-radius: 30px;
  margin-left: auto;
  background-color:royalblue;
  border-color: white;
  font-family:Georgia, 'Times New Roman', Times, serif;
  color:white ;
  width: 150px;
  height: 30px;
}

.card
{
  text-align: center;
  border: 1px solid rgb(2, 5, 4,0.5);
  margin: 200px auto 200px auto ;
  display: block;
  background-color: #1376ab ;
  color:white; 
  width:400px;
 height: 500px;
}
.anchors
{
  margin-top: 20px;
  margin-bottom: 20px;
  font-size: larger;
  font-weight: bold;
  font-family: cursive;
}
.anchors a
{
    color: white;
}
.anchors  :hover 
{
    color : black;
}

.chooseH
{
  margin : 70px 0 0 0;

display: block;
}


.font
{
  font-size: medium;
  font-family: 'Times New Roman', Times, serif;
  font-weight: bold;
}
.bb
{
  margin-left: 10px;
  margin-right: 10px; 
  margin-top: 20px ;
}
body
{
 
  background-size: 100% auto;
}

</style>
