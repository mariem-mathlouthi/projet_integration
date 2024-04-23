import { createRouter, createWebHistory } from "vue-router";
import Signin from "../components/Auth/SignIn.vue";
import SignupEtudiant from "../components/Auth/SignUpEtudiant.vue";
import SignupEtudiantPart2 from "../components/Auth/SignUpEtudiantPart2.vue";
import SignupEntreprise from "../components/Auth/SignUpEntreprise.vue";
import SignupEntreprisePart2 from "../components/Auth/SignUpEntreprisePart2.vue";
import Contact from "../components/Contact.vue";
import LandingPage from "../components/LandingPage.vue";
import StudentDash from "../components/StudentDash/StudentDashboard.vue";
import EntrepriseDash from "../components/EntrepriseDash/EntrepriseDashbord.vue";
import OffersList from "../components/EntrepriseDash/OffersList.vue";
import AddOffer from "../components/EntrepriseDash/AddOffer.vue";
import DetailOffre from "../components/EntrepriseDash/DétailOffre.vue";
import EditOffre from "../components/EntrepriseDash/EditOffre.vue";
import TreatedRequest from "../components/EntrepriseDash/TreatedRequest.vue";
import EntrepriseAccount from "../components/EntrepriseDash/Account.vue";
import StudentsList from "../components/EntrepriseDash/StudentsList.vue";
import DetailStudent from "../components/EntrepriseDash/DetailStudent.vue";
import AdminDashboard from "../components/Admin/AdminDash.vue";
import UsersListEtudiants from "../components/Admin/UsersListEtudiants.vue";
import OffresListAdmin from "../components/Admin/OffresListAdmin.vue";
import MessagesList from "../components/Admin/MessagesList.vue";
import DetailOffreAdmin from "../components/Admin/DetailOffreAdmin.vue";
import UsersList from "../components/Admin/UsersList.vue";
import AccountSetting from "../components/Admin/AccountSetting.vue";
import AddOfferAdmin from "../components/Admin/AddOffer.vue";
const routes = [
   {
    path: "/",
    name: "landingPage",
    component: LandingPage,
    },
    {
      path: "/DetailStudent",
      name: "DetailStudent",
      component: DetailStudent,
      },
    {
      path: "/EntrepriseAccount",
      name: "EntrepriseAccount",
      component: EntrepriseAccount,
      },
    {
      path: "/StudentsList",
      name: "StudentsList",
      component: StudentsList,
      },
    {
      path: "/EditOffre",
      name: "EditOffre",
      component: EditOffre,
      },
      {
        path: "/TreatedRequest",
        name: "TreatedRequest",
        component: TreatedRequest,
        },
    {
      path: "/StudentDash",
      name: "StudentDash",
      component: StudentDash,
      },
      {
        path: "/DetailOffre",
        name: "DetailOffre",
        component: DetailOffre,
        },
        {
          path: "/AddOffer",
          name: "AddOffer",
          component: AddOffer,
          },
      {
        path: "/EntrepriseDash",
        name: "EntrepriseDash",
        component: EntrepriseDash,
        },
  {
    path: "/signupEtudiant",
    name: "signupEtudiant",
    component: SignupEtudiant,
  },
  {
    path: "/OffersList",
    name: "OffersList",
    component: OffersList,
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
    path: "/OffresListAdmin",
    name: "OffresListAdmin",
    component: OffresListAdmin, 
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
    path: "/AddOfferAdmin",
    name: "AddOfferAdmin",
    component: AddOfferAdmin,
    },
    {
      path: "/DetailOffreAdmin",
      name: "DetailOffreAdmin",
      component: DetailOffreAdmin,
      },
      {
        path: "/UsersListEtudiants",
        name: "UsersListEtudiants",
        component: UsersListEtudiants,
        }
  
 
  // Other routes...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;