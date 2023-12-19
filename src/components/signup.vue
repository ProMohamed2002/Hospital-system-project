
<template>
  <main_header/>
    <v-dialog width="400" max-height="400" height="100%" class="card" v-model="dialog" transition="dialog-top-transition" persistent>
      <v-card variant="outlined">
       <v-card-text>
        Signin
       </v-card-text>
     <div style="width: 2000px; margin-left:80px"><input  style="background-color: white; margin:3px"  type="text" placeholder=" user name" v-model="name1" required autofocus/></div>
     <div style="width: 2000px; margin-left:80px"><input  style="background-color: white; margin:3px"  type="email" placeholder="  email" v-model="email1" required autofocus/></div>
      <div style="width: 2000px; margin-left:80px"> <input style="background-color: white; margin:3px" type="password" placeholder="  password" v-model="pas1" required autofocus/></div>
        <div style="width: 2000px; margin-left:80px"> <input  style="background-color: white; margin:3px"  type="tel" pattern="[0,9]{11}" placeholder="  phone number" required v-model="phone_number1" autofocus/></div>
          <div style="width: 2000px; margin-left:80px"> <input style="background-color: white; margin:3px" type="date" placeholder="  borth date" v-model="birth_date1" required autofocus/></div>
            <div style="width: 2000px; margin-left:80px"> <input style="background-color: white; margin:3px" type="password" placeholder="  civil_id" pattern="00000000000000" v-model="civil_id1" required autofocus/></div>
        <button style="margin-bottom:5px;" type="submit" class="submit" @click="submit()"  >sign up</button>
        <div style="margin-bottom:10px; margin-top:10px;">already have an account?<router-link to="/">login</router-link></div>
      </v-card>
      </v-dialog>
    <div class="pag">
  </div>
    <FooTer/>
  
  </template>
  
  
<script >
import axios from 'axios';
import FooTer from './footer.vue';
import main_header from './header.vue'
export default {
  name: 'signup',
  components: {
    FooTer,
    main_header
  },
  data(){
        return{
            email1:'',//email
            pas1:'',//password
            name1:'',//user name
            phone_number1:'',
            birth_date1:'',
            civil_id1:'',
            doctor:false,
            manger:false,
            person:false,
            dialog:true,
            obj:{
              user_name:'',
              email_address:"",
              password:"",
              phone_number:'',
              birth_date:'',
              civil_id:'',
            },
           
            
        };
    },
    methods: {
      async submit()
      {
        this.obj.user_name=this.name1
        this.obj.email_address=this.email1
        this.obj.password=this.pas1
        this.obj.phone_number=this.phone_number1
        this.obj.birth_date=this.birth_date1
        this.obj.civil_id=this.civil_id1
        localStorage.setItem("user_name", this.obj.user_name)
        localStorage.setItem("password", this.obj.password)
        await axios.post("http://localhost:8081/addPatient", this.obj).then(
          this.$router.push("/PatientHome")
        ).catch((error) => {
        //Handle errors
        console.error('Error:', error);
        });
                  
      },
      doc(){
        this.doctor=true
      
      },
      man(){
        this.manger=true
        
      },
      pat(){
        this.person=true
        
      }
    }, 
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

input:invalid {
  border: 2px solid red;
}
.pag{
  height: 1000px;
  width: 900px;
  margin: auto;
  background-image: url('../assets/ministryofhealth.png');
  background-size: cover;
  background-position: center;
  margin-bottom: 50px;
}
  .mail
  {
    margin : 20px 0 0 0;
  
    display: block;
  
  }
  .password
  {
    margin-top: 20px;
    
  }
  .pp{
    display: flex;
    flex-direction: row;
    gap: 15px;
    padding-left:2px ;
    margin-left: 100px;
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
  .options{
    margin-top: 5px;
    width: 100px;
    margin-left: 5px;

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
  body
  {
   
    background-size: 100% auto;
  }
  
  </style>