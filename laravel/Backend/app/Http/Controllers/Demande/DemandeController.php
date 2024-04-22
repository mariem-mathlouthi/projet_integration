<?php

namespace App\Http\Controllers\Demande;

use App\Http\Controllers\Controller;
use App\Models\Demande;
use Illuminate\Http\Request;

class DemandeController extends Controller
{
    public function AddDemande (Request $request){
        $requestData = $request->all();
        $new = new Demande();
        $new->idEtudiant = $requestData['idEtudiant']; $new->idoffreDeStage = $requestData['idOffreDeStage']; $new->statut= $requestData['statut'];
        $date = $requestData['DateSoumission'];;
        $formattedDate
        =
        date('Y-m-d', strtotime($date));
        $new->DateSoumission = $formattedDate; $new->cv = $requestData['cv']; $new->save();
        return response()->json([
        'message' => 'Demande Added successfully', 'check' => true,
        ]);
    }
    public function acceptDemande($id)
{
    $demande = Demande::find($id);

    if ($demande) {
        $demande->update([
            "statut"=> 1
        ]);
        return response()->json(["data" => $demande], 200);
    } else {
        return response()->json(["message" => "Non trouvé"], 404);
    }
}

    
}
