
<template>
  <main_header/>
  
    <v-dialog width="400" max-height="400" height="80%" class="card" v-model="dialog" transition="dialog-bottom-transition" persistent>
      <v-card variant="outlined">
       <v-card-text>
        LOGIN
       </v-card-text>

    <div style="width: 2000px; margin-left:80px"><input  style="background-color: white; margin:10px "  type="text" placeholder=" user name" v-model="user_name" autofocus/></div>
    <div style="width: 2000px; margin-left:80px"><input style="background-color: white; margin:10px" type="password" placeholder="  password" v-model="password" autofocus/></div> 
       <div class="pp">
          <input id="doc" name="category" type="radio"  @click="doc()"  />
          <label for="doc">doctor</label>
        </div>
       <div class="pp">
          <input id="pat" name="category" type="radio"  @click="pat()"/>
          <label for="pat"> normal user</label>
        </div>
       <div class="pp">
          <input id="man" name="category" type="radio"  @click="man()" />
             <label for="man"> manager</label>
        </div>  
        <button style="margin-bottom:10px;" type="submit" class="submit" @click="submit()"  >Log in</button>
        <div style="margin-bottom:10px; margin-top:10px;">dont have an account?<router-link to="/signup">sign up</router-link></div>
      </v-card>
      </v-dialog>
    <div class="pag">

    </div>
    <FooTer/>
  
  </template>
  
  
<script>
import axios from 'axios';
export default {
  name: 'loGin',
  data() {
        return{
            check: {},
            user_name:'',
            password:'',
            doctor:false,
            manager:false,
            person:false,
            dialog:true,        
        };
    },
    methods: {
      async submit()
      {
      if(this.person){

        await axios.get(`http://localhost:8081/customPatientNameAndPassword?user_name=${this.user_name}&password=${this.password}`).then((r) => {
          this.check = r.data
        })
        localStorage.setItem('user_name',this.user_name)
        localStorage.setItem('password',this.password)
        if(this.check)
              this.goTohome()
        else
          alert('user name or password may be wrong');
        }
        else if(this.doctor){
        await axios.get(`http://localhost:8081/customDoctorNameAndPassword?user_name=${this.user_name}&password=${this.password}`).then(
          (r) => {
            this.check = r.data
          }
        )
        localStorage.setItem('user_name',this.user_name)
        localStorage.setItem('password',this.password)
        if(this.check)
              this.goTohome()
        else
          alert('user name or password may be wrong');
        }
        else if(this.manager){
        await axios.get(`http://localhost:8081/customManagerNameAndPassword?user_name=${this.user_name}&password=${this.password}`).then(
          (r) => {

            this.check = r.data
            console.log(r.data)
          }
        )
        console.log(this.check)
        localStorage.setItem('user_name',this.user_name)
        localStorage.setItem('password',this.password)
        if(this.check) {
              console.log(this.check, "always true");
              this.goTohome()
        }
        else
        alert('user name or password may be wrong');
      }  
      this.user_name=''
      this.password=''
        },

      goTohome() {
        if(this.person) {
          localStorage.setItem("user_type", "patient");
          this.$router.push("/PatientHome");
        }
          
        else if(this.doctor) {
          localStorage.setItem("user_type", "doctor");
          this.$router.push("/DoctorHome");
        }
        else if(this.manager) {
          localStorage.setItem("user_type", "manager");
          this.$router.push("/ManagerHome");
        }
      },
      doc(){
        this.doctor=true
        this.patient=false
        this.manager=false
      },
      man(){
        this.manager=true
        this.doctor=false
        this.patient=false
      },
      pat(){
        this.person=true
        this.doctor=false
        this.manager=false
      }
    }, 
    mounted() {
      localStorage.setItem("user_name", "");
      localStorage.setItem("password", "");
    }
    
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
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