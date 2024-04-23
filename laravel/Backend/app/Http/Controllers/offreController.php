<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Offre;

class offreController extends Controller
{
    //
    public function AddOffre(Request $request){
        $requestData = $request->all();
        $new = new Offre();
        $new->idEntreprise = $requestData['idEntreprise'];
        $new->status = $requestData['status'];
        $new->titre= $requestData['titre'];
        $new->description= $requestData['description'];
        $new->domaine= $requestData['domaine'];

        $date = $requestData['dateDebut'];;
        $formattedDate = date('Y-m-d', strtotime($date));
        $new->dateDebut = $formattedDate;

        $date2 = $requestData['dateFin'];;
        $formattedDate2 = date('Y-m-d', strtotime($date2));
        $new->dateFin = $formattedDate2;

        $new->typeOffre= $requestData['typeOffre'];
        $new->cahierCharge= $requestData['cahierCharge'];

        $new->save();

        return response()->json([
            'message' => 'Offre Added successfully',
            'check' => true,
        ]);

}


}
