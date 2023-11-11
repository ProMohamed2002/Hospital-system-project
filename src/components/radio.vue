<template >
    <main_header/>
    <div class="content">
        <div class="profile" >
            <div class="photo">
                <img   src="../assets/Abuobayda.jpg" height="200px" width="200px" style="border-radius: 100px; border: 2px black solid;">
            </div>
            <div class="photoEdit" >
                <br><button>Edit your profile </button><br><br>
                <button>Rate hospital</button>
            </div>
        </div>
        <div class="sentences">
            <h3 id="h1">personal data </h3> <hr width="150px" >
            <ul >
                
                <li>
                    <label for="اسم">name </label>
                    <span style="padding:5px">farahat</span>
                    <br><br>
                    
                </li>
                <li>
                    <label for="name ">mobile number </label>
                    <span style="padding:5px">015555555</span>
                    <br><br>
                </li>
                <li>
                    <label for="اسم">national ID </label>
                    <span style="padding:5px">21011067 </span> 
                    <br><br>
                </li>
            </ul>
            <h3 id="h1">The doctor following up on the case </h3> <hr width="350px">
            <h3 id="h1">insurance type </h3> <hr width="160px">
            <h3 id="h1">diagnosis of the patient's condition </h3> <hr width="350px">
            <h3 id="h1">contact with patient </h3> <hr width="200px">
        </div>
        
    </div>
    <FooTer/>
</template>

<script>
 import main_header from "./header.vue" 
 import FooTer from "./footer.vue" 
export default {
  name: "radio_button",
  components:{
            main_header,
            FooTer
        },
}
</script>
 
<style>
.sentences {
    
    font-weight: bold;
    text-align: left;
    margin-left: 60px;
}
#h1::before{
    content: "✔";
    color: brown;
}

.sentences hr{
    margin-left: 0px;
    padding-top: 1px;
    background-color: black;
}
.profile {
    text-align: left;
    border-radius: 125px;
    margin-left: 1250px;
    
}
.profile .photo{
    margin-right: 50px;
    margin-top: 60px;
    
}
.photoEdit button {
    
    margin-right: 60px;
    font-weight: bold;
    cursor: pointer;
    font-size: 20px;
    border-radius: 10px; 
    color: rgb(0, 0, 0); 
    background-color: rgb(131, 131, 160);
}

</style>