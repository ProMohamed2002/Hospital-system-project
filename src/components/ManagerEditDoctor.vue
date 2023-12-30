<template>
    <main_header/>
    <center><h1>edit doctor</h1></center>
    <form @submit="submit">
        <label>user name:</label>
        <input type="text" inputmode="text" placeholder="doctor name" required v-model="this.name" readonly style="background-color: skyblue;">
        <label>Rational id:</label>
        <input type="text" inputmode="number" pattern="[0-9]{14}" placeholder="88888888888888" required v-model="this.civilID" readonly style="background-color: skyblue;">
        <label>birth date:</label>
        <input type="date" required v-model="this.birthDate" readonly style="background-color: skyblue;">
        <label>email address:</label>
        <input type="email" inputmode="text" placeholder="email address" required v-model="this.email">
        <label>password:</label>
        <input type="text" inputmode="text" placeholder="password" required v-model="this.password">
        <label>telephone number:</label>
        <input type="tel" placeholder="88888888888" pattern="[0-9]{11}" required v-model="this.tel">
        <label>academic degree:</label>
        <input type="text" placeholder="academic degree" v-model="this.academicDegree">
        <div v-for="hours in this.workingHours" class="working-hours" :key="hours.id">
            <h3 style="margin: 10px;">{{ hours.week_day }}</h3>
            <h3 style="margin: 10px;">{{ hours.work_start }}</h3>
            <h3 style="margin: 10px;">{{ hours.work_end }}</h3>
            <button style="float: right;" @click="deletee(hours.week_day, hours.doctor)">delete</button>
        </div>
        <label>add Working hours through the week</label>
        <div class="add-working-hour">
            <select class="drop-down" v-model="this.weekDay">
                <option value="Sat">saturday</option>
                <option value="Sun">sunday</option>
                <option value="Mon">monday</option>
                <option value="Tue">tuesday</option>
                <option value="Wed">wednesday</option>
                <option value="Thu">thursday</option>
                <option value="Fri">friday</option>
            </select>
            <input type="time" v-model="this.startTime">
            <input type="time" v-model="this.endTime">
            <button  @click="addWorkingHour">add</button>
        </div>
        <input type="submit" class="add-btn" value="save changes">
    </form>
    <Footer/>
</template>

<script>
    import axios from 'axios'
    import main_header from './header.vue'
    import Footer from './footer.vue'
    export default {
        name: "ManagerEditDoctor",

        data() {
            return {
                name: '',
                email:'',
                password:'',
                tel: '',
                birthDate: '',
                academicDegree: '',
                weekDay: '',
                startTime: '',
                endTime: '',
                workingHours: []
            }
        },
        components: {
            main_header,
            Footer
        },
        methods: {
            deletee(day, doctor) {
                axios.delete('http://localhost:8081/customDeleteWorkingHours', {
                    params: {
                        doctor: doctor,
                        day: day
                    }
                })
            },
            async addWorkingHour() {
                
                console.log(this.startTime)
                if(this.endTime > this.startTime && this.weekDay != '') {
                    await axios.post('http://localhost:8081/addWorkingHours', {
                        doctor: this.name,
                        week_day: this.weekDay,
                        work_start: this.startTime.concat(':00'),
                        work_end: this.endTime.concat(':00')
                    })
                }
                
                let workingHours = await axios.get('http://localhost:8081/customFetchWorkingHoursByDoctor', {
                    params: {
                        doctor: this.name
                    }
                })
                this.workingHours = workingHours.data
                
            },
            async submit() {
                axios.post(`http://localhost:8081/customUpdateDoctor`, 
                {
                    user_name: this.name,
                    email_address: this.email,
                    password: this.password,
                    phone_number: this.tel,
                    birth_date: this.birthDate,
                    description: this.academicDegree,
                    hospital: localStorage.getItem("hospital"),
                    department: localStorage.getItem("department"),
                    civil_id: this.civilID
                });
                this.$router.push("/ManagerHome");

            }
        },
        async mounted() {
            if(localStorage.getItem("user_type") !== "manager") {
                this.$router.push("/");
            }
            let doctor = await axios.get("http://localhost:8081/customDoctorNameAndPassword", {
                params: {
                    user_name: localStorage.getItem("doctorname"),
                    password: localStorage.getItem("doctorpassword")
                }
            })
            const d = doctor.data
            this.name = d.user_name,
            this.email = d.email_address,
            this.password = d.password,
            this.tel = d.phone_number,
            this.birthDate = d.birth_date,
            this.civilID = d.civil_id,
            this.academicDegree = d.description,
            console.log(d)

            let workingHours = await axios.get('http://localhost:8081/customFetchWorkingHoursByDoctor', {
                params: {
                    doctor: this.name
                }
            })
            this.workingHours = workingHours.data
            //console.log(this.workingHours)
        }

    }
</script>

<style>
h1{
    font-size: 50px;
    font-weight: bold;
}
form{
    display: grid;
}
form input {
    width: 500px;
    height: 50px;
    margin: 20px;
    border: 2px solid skyblue;
    border-radius: 5px;
}
form input:invalid {
  border: 2px solid red;
}
form label{
    font-weight: bold;
    font-size: 30px;
    margin-left: 30px;
}

form .add-btn:hover {
    font-weight: bold;
    letter-spacing: 1px;
    font-size: large;
}
form .add-btn{
    background-color: #1376ab;
    color: white;
    font-size: large;
}
form .add-working-hour {
    display: flex;
    width: 35%;
}

form .add-working-hour .drop-down {
    width: 50%;
}

form .working-hours {
    display: flex;
    border: 1px solid skyblue;
    margin: 4px;
    width: 30%;
    border-radius: 2px;
    margin-left: 20px;
}

</style>