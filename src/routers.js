import HoMe from "./components/Home.vue"
import Departement from "./components/Departement.vue"
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
    }
];
const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;