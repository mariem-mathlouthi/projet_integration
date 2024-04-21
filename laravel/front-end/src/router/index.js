import { createRouter, createWebHistory } from "vue-router";
import Signin from "../components/Auth/SignIn.vue";
import SignupEtudiant from "../components/Auth/SignUpEtudiant.vue";
import SignupEtudiantPart2 from "../components/Auth/SignUpEtudiantPart2.vue";
import SignupEntreprise from "../components/Auth/SignUpEntreprise.vue";
import SignupEntreprisePart2 from "../components/Auth/SignUpEntreprisePart2.vue";
import Contact from "../components/Contact.vue";
import LandingPage from "../components/LandingPage.vue";
import StudentDash from "../components/StudentDash/StudentDashboard.vue";
import StudentAccount from "../components/StudentDash/ModifyAccount.vue";
import AdminDashboard from "../components/Admin/AdminDash.vue";
import OffresList from "../components/Admin/OffresList.vue";
import MessagesList from "../components/Admin/MessagesList.vue";
import UsersList from "../components/Admin/UsersList.vue";
import AccountSetting from "../components/Admin/AccountSetting.vue";
import AddOffer from "../components/Admin/AddOffer.vue";



const routes = [
   {
    path: "/",
    name: "landingPage",
    component: LandingPage,
    },
    {
      path: "/StudentDash",
      name: "StudentDash",
      component: StudentDash,
    },
    {
        path: "/StudentAccount",
        name: "StudentAccount",
        component: StudentAccount,
  },
  {
    path: "/signupEtudiant",
    name: "signupEtudiant",
    component: SignupEtudiant,
  },
  {
    path: "/signupEtudiantPart2",
    name: "signupEtudiantPart2",
    component: SignupEtudiantPart2,
  },
  {
    path: "/contact",
    name: "contact",
    component: Contact,
  },
  {
    path: "/signupEntreprise",
    name: "signupEntreprise",
    component: SignupEntreprise,
  },
  {
    path: "/signupEntreprisePart2",
    name: "signupEntreprisePart2",
    component: SignupEntreprisePart2,
  },
  {
    path: "/signin",
    name: "signin",
    component: Signin,
  },
  {
    path: "/Admin", // Define the path for the admin page
    name: "admin", // Define the name for the admin route
    component: AdminDashboard, // Specify the component for the admin page
  },
  {
    path: "/OffresList",
    name: "OffresList",
    component: OffresList, 
  },
  {
    path: "/MessagesList",
    name: "MessagesList",
    component: MessagesList, 
  },
  {
    path: "/UsersList",
    name: "UsersList",
    component: UsersList, 
  },
  {
    path: "/AccountSetting",
    name: "AccountSetting",
    component: AccountSetting, 
  },
  {
    path: "/AddOffer",
    name: "AddOffer",
    component: AddOffer,
    },
  // Other routes...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;