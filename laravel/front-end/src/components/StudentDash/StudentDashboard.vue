<template>
    <div>
      <!-- Barre de navigation -->
      <Navbar />
  
      <!-- Contenu du dashboard -->
      <div class="container">
        <ConsultStages />
        <FilterStages />
        <OfferDetails />
        <ApplyForStage />
        <SubmitCV />
        <ModifyAccount />
        <AcceptedStages />
      </div>
  
   
    
    </div>
  </template>
  
  <script>
  import Navbar from './Navbar.vue';
  import ConsultStages from './ConsultStages.vue';
  import FilterStages from './FilterStages.vue';
  import OfferDetails from './OfferDetails.vue';
  import ApplyForStage from './ApplyForStage.vue';
  import SubmitCV from './SubmitCV.vue';
  import ModifyAccount from './ModifyAccount.vue';
  import AcceptedStages from './AcceptedStages.vue';
  
  export default {
    components: {
      Navbar,
      ConsultStages,
      FilterStages,
      OfferDetails,
      ApplyForStage,
      SubmitCV,
      ModifyAccount,
      AcceptedStages
    }
  }
  </script>
  
  <style>
  .container {
    max-width: 1200px;
    margin: 0 auto;
  }
  </style>
  