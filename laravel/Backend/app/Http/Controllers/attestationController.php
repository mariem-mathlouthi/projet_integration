<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Attestation;
use Illuminate\Support\Facades\Storage;


class attestationController extends Controller
{
    //
    public function addAttestation(Request $request){
        $requestData = $request->all();
    
        // Get the uploaded file
        $attestation = $request->file('attestation');
    
        // Generate a unique filename
        $filename = time().'_'.$attestation->getClientOriginalName();
    
        // Move the uploaded file to the uploads folder
        $attestation->move(public_path('storage/uploads'), $filename);

        // Get the URL of the uploaded file
        $url = asset('storage/uploads/'.$filename);
    
        // Create a new Demande instance
        $new = new Attestation();
        $new->idEtudiant = $requestData['idEtudiant'];
        $new->idEntreprise = $requestData['idEntreprise'];
        $new->idOffreDeStage = $requestData['idOffreDeStage'];
        $new->attestation = $url; // Save the URL in the database
        $new->message = $requestData['message']; // Save the URL in the database
        $new->date = date('Y-m-d', strtotime($requestData['date']));
        $new->save();
        return response()->json([
            'message' => 'attestation Added successfully',
            'check' => true,
        ]);
    }

    public function getAttestationByEtudiant_Offer($idEtudiant)
{
    $attestation = Attestation::where('idEtudiant', $idEtudiant)->get();

    if ($attestation->isEmpty()) {
        return response()->json([
            'message' => 'Attestation does not exist',
            'check' => false,
        ]);
    }

    return response()->json([
        'attestation' => $attestation,
        'message' => 'Attestation fetched successfully',
        'check' => true,
    ]);
}


}
