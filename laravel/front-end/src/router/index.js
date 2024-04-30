import { createRouter, createWebHistory } from "vue-router";
import Signin from "../components/Auth/SignIn.vue";
import SignupEtudiant from "../components/Auth/SignUpEtudiant.vue";
import SignupEtudiantPart2 from "../components/Auth/SignUpEtudiantPart2.vue";
import SignupEntreprise from "../components/Auth/SignUpEntreprise.vue";
import SignupEntreprisePart2 from "../components/Auth/SignUpEntreprisePart2.vue";
import Contact from "../components/Contact.vue";
import LandingPage from "../components/LandingPage.vue";


import StudentDash from "../components/StudentDash/StudentDashboard.vue";
import NavBarStd from "../components/StudentDash/NavBarStd.vue";
import DetailsOffreStd from "../components/StudentDash/DetailsOffreStd.vue";
import PostulerCondidature from "../components/StudentDash/PostulerCondidature.vue";
import ListeStagesAcceptes from "../components/StudentDash/ListeStagesAcceptes.vue";
import Consulternotif from "../components/StudentDash/Consulternotif.vue";
import EtudiantAccount from "../components/StudentDash/EtudiantAccount.vue";
import OffersListStd from "../components/StudentDash/OffersListStd.vue";


import EntrepriseDash from "../components/EntrepriseDash/EntrepriseDashbord.vue";
import OffersList from "../components/EntrepriseDash/OffersList.vue";
import AddOffer from "../components/EntrepriseDash/AddOffer.vue";
import DetailOffre from "../components/EntrepriseDash/DétailOffre.vue";
import EditOffre from "../components/EntrepriseDash/EditOffre.vue";
import TreatedRequest from "../components/EntrepriseDash/TreatedRequest.vue";
import EntrepriseAccount from "../components/EntrepriseDash/Account.vue";
import StudentsList from "../components/EntrepriseDash/StudentsList.vue";
import DetailStudent from "../components/EntrepriseDash/DetailStudent.vue";
import DetailDemande from "../components/EntrepriseDash/DetailDemande.vue";
import EditDemande from "../components/EntrepriseDash/EditDemande.vue";



const routes = [
   {
    path: "/",
    name: "landingPage",
    component: LandingPage,
    },
    {
      path: "/DetailDemande/:id",
      name: "DetailDemande",
      component: DetailDemande,
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
      path: "/EditOffre/:idEntreprise/:id",
      name: "EditOffre",
      component: EditOffre,
      },
      {
        path: "/TreatedRequest",
        name: "TreatedRequest",
        component: TreatedRequest,
        },
      {
        path: "/detailoffre/:id",
        name: "DetailOffre",
        component: DetailOffre,
        },
        {
          path: "/EditDemande/:id",
          name: "EditDemande",
          component: EditDemande,
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
      path: "/StudentDash",
      name: "StudentDash",
      component: StudentDash,
      },
  {
    path: "/EtudiantAccount",
    name: "EtudiantAccount",
    component: EtudiantAccount,
    },

  {
    path: "/Consulternotif",
    name: "Consulternotif",
    component: Consulternotif,
    },
  {
    path: "/ListeStagesAcceptes",
    name: "ListeStagesAcceptés",
    component: ListeStagesAcceptes,
    },
  {
    path: "/PostulerCondidature/:id",
    name: "PostulerCondidature",
    component: PostulerCondidature,
    },

    {
      path: "/DetailsOffreStd/:id",
      name: "DetailsOffreStd",
      component: DetailsOffreStd,
    },
    
    
  {
    path: "/OffersListStd",
    name: "OffersListStd",
    component: OffersListStd,
    },
  {
    path: "/NavBarStd",
    name: "NavBarStd",
    component: NavBarStd,
    },




 
  
 
  // Other routes...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;