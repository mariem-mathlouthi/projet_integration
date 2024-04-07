import { createRouter, createWebHistory } from "vue-router";
import Signin from "../components/SignIn.vue";
import Signup from "../components/SignUp.vue";
import SignupPart2 from "../components/SignUpPart2.vue";
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
    path: "/signupPart2",
    name: "signupPart2",
    component: SignupPart2,
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