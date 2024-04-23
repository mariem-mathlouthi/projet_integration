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
}
