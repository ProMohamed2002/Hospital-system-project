import PatientHome from "./components/PatientHome.vue"
import Department from "./components/Department.vue"
import PayMent from "./components/pay.vue"
import login from "./components/login.vue"
import radio_button from "./components/radio.vue"
import TakeApointment from './components/TakeApointment'
import signup from './components/signup.vue'
import ManagerHome from './components/ManagerHome.vue'
import ManagerSearchResults from './components/ManagerSearchResults'
import ManagerDepartments from './components/ManagerDepartments'
import ManagerDoctors from "./components/ManagerDoctors"
import ManagerAddHospital from "./components/ManagerAddHospital"
import ManagerAddDoctor from "./components/ManagerAddDoctor"
import ManagerAddDepartment from "./components/ManagerAddDepartment"
import ManagerEditDoctor from "./components/ManagerEditDoctor"
import ManagerEditHospital from "./components/ManagerEditHospital"
import HospitalInfo from "./components/HospitalInfo"
import PatientSearchResults from "./components/PatientSearchResults"
import PatientEditProfile from "./components/PatientEditProfile"
import ManagerEditProfile from "./components/ManagerEditProfile"
import { createRouter, createWebHistory } from "vue-router"
const routes = [
    {
        name: "PatientHome",
        component: PatientHome,
        path: "/PatientHome"
    },
    {
        name: "Department",
        component: Department,
        path: "/department"
    },
    {
        name: "pay",
        component: PayMent ,
        path: "/pay"
    },
    {
        name: "login",
        component: login ,
        path: "/"
    },
    {
        name: "radio",
        component: radio_button ,
        path: "/radio"
    },
    {
        name: "Take",
        component: TakeApointment ,
        path: "/Take"
    },
    
    {
        name: "ManagerHome",
        component: ManagerHome,
        path: "/ManagerHome"
    },
    {
        name: "ManagerSearchResults",
        component: ManagerSearchResults,
        path: "/ManagerSearchResults"
    },
    {
        name: "ManagerDepartments",
        component: ManagerDepartments,
        path:"/ManagerDepartments"
    },
    {
        name: "ManagerDoctors",
        component: ManagerDoctors,
        path: "/ManagerDoctors"
    },
    {
        name: "ManagerAddHospital",
        component: ManagerAddHospital,
        path: "/AddHospital"
    },
    {
        name: "ManagerAddDoctor",
        component: ManagerAddDoctor,
        path: "/AddDoctor"
    },
    {
        name: "ManagerAddDepartment",
        component: ManagerAddDepartment,
        path: "/AddDepartment"
    },
    {
        name: "ManagerEditDoctor",
        component: ManagerEditDoctor,
        path: "/EditDoctor"
    },
    {
        name: "ManagerEditHospital",
        component: ManagerEditHospital,
        path: "/EditHospital"
    },
    {
        name: "signup",
        component: signup,
        path: "/signup"
    },
    {
        name: "HospitalInfo",
        component: HospitalInfo,
        path: "/HospitalInfo"
    },
    {
        name: "PatientSearchResults",
        component: PatientSearchResults,
        path: "/PatientSearchResults"
    },
    {
        name: "PatientEditProfile",
        component: PatientEditProfile,
        path: "/PatientEditProfile"
    },
    {
        name: "ManagerEditProfile",
        component: ManagerEditProfile,
        path: "/ManagerEditProfile"
    }

];
const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;