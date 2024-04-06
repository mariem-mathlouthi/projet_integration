import { createRouter, createWebHistory } from "vue-router";
import Signin from "../components/SignIn.vue";
import Signup from "../components/SignUp.vue";
import Contact from "../components/Contact.vue";
import Signup2 from "../components/SignUpEntreprise.vue";
import LandingPage from "../components/LandingPage.vue";

const routes = [
   {
    path: "/",
    name: "landingPage",
    component: LandingPage,
    },
  {
    path: "/signup",
    name: "signup",
    component: Signup,
  },
  {
    path: "/contact",
    name: "contact",
    component: Contact,
  },
  {
    path: "/signupEntreprise",
    name: "signup2",
    component: Signup2,
  },
  {
    path: "/signin",
    name: "signin",
    component: Signin,
  },
 
  // Other routes...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;