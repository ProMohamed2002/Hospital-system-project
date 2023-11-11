import HoMe from "./components/Home.vue"
import Departement from "./components/Departement.vue"
import PayMent from "./components/pay.vue"
import login from "./components/login.vue"
import radio_button from "./components/radio.vue"
import TakeApointment from './components/TakeApointment'
import signup from './components/signup'
import { createRouter, createWebHistory } from "vue-router"
const routes = [
    {
        name: "Home",
        component: HoMe,
        path: "/"
    },
    {
        name: "Departement",
        component: Departement,
        path: "/departement"
    },
    {
        name: "pay",
        component: PayMent ,
        path: "/pay"
    },
    {
        name: "login",
        component: login ,
        path: "/login"
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
        name: "signup",
        component: signup ,
        path: "/signup"
    }
];
const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;