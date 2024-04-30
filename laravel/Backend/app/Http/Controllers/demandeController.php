<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Demande;

class demandeController extends Controller
{
    //
    public function AddDemande(Request $request){
        $requestData = $request->all();
        $new = new Demande();
        $new->idEtudiant = $requestData['idEtudiant'];
        $new->idOffreDeStage = $requestData['idOffreDeStage'];
        $new->statut= $requestData['statut'];
        $date = $requestData['DateSoumission'];;
        $formattedDate = date('Y-m-d', strtotime($date));
        $new->DateSoumission = $formattedDate;
        $new->cv = $requestData['cv'];
        $new->save();

        return response()->json([
            'message' => 'Demande Added successfully',
            'check' => true,
        ]);
        

    }

    

public function getAllDemandes(Request $request,$idEtudiant){
    // Fetch all offers
    $demandes = Demande::where('idEtudiant', $idEtudiant)->get();
    return response()->json([
        'demandes' => $demandes,
        'message' => 'All demandes fetched successfully for idEtudiant ' . $idEtudiant,
        'check' => true,
    ]);
}



public function Demandes(Request $request){
    // Fetch all offers
    $demandes = Demande::all();
    return response()->json([
        'demandes' => $demandes,
        'message' => 'All demandes fetched successfully ',
        'check' => true,
    ]);
}



public function getDemandeById(Request $request,$id){
    // Fetch all offers
    $demande = Demande::where('id', $id)->get();
    return response()->json([
        'demande' => $demande,
        'message' => 'demande fetched successfully',
        'check' => true,
    ]);
}




public function getDemandeByOfferId(Request $request,$offerId){
    // Fetch all offers
    $demandes = Demande::where('idOffreDeStage', $offerId)->get();
    return response()->json([
        'demandes' => $demandes,
        'message' => 'demandes fetched successfully',
        'check' => true,
    ]);
}


public function updateStatut(Request $request ,$id){
    $requestData = $request->all();
    $ExistingDemande = Demande::where('id', $id)->first();
    if ($ExistingDemande) {
        // Update Demande
        $ExistingDemande->statut= $requestData['statut'];
        
        $ExistingDemande->save();
        
        return response()->json([
            'message' => 'Demande updated successfully',
            'update' => true,
           
        ]);
        
    }else {
        return response()->json([
            'message' => 'Demande not found',
            'update' => false,
            
        ], 404);
    }
}





public function deleteDemande($id){
    
    $ExistingDemande = Demande::where('id', $id)->first();
    if ($ExistingDemande) {
        // delete Demande
        $ExistingDemande->delete();
        
        return response()->json([
            'message' => 'Demande deleted successfully',
            'delete' => true,
           
        ]);
        
    }else {
        return response()->json([
            'message' => 'Demande not found',
            'delete' => false,
            
        ], 404);
    }

}







}
