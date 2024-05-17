<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Offre;
use Illuminate\Support\Facades\Storage;

class offreController extends Controller
{
    //
    public function addOffre(Request $request){
        $requestData = $request->all();
        
        $cahierCharge = $request->file('cahierCharge');
    
        // Generate a unique filename
        $filename = time().'_'.$cahierCharge->getClientOriginalName();
    
        // Move the uploaded file to the uploads folder
        $cahierCharge->move(public_path('storage/uploads'), $filename);

        // Get the URL of the uploaded file
        $url = asset('storage/uploads/'.$filename);

    
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
        $new->cahierCharge= $url; // Save filename or path
    
        $new->save();
    
        return response()->json([
            'message' => 'Offre Added successfully',
            'check' => true,
        ]);
    }
    


public function updateOffre(Request $request){
    $requestData = $request->all();
    // Check if email already exists
    $ExistingOffre = Offre::where('id', $requestData['id'])->first();
    if ($ExistingOffre) {
        $cahierCharge = $request->file('cahierCharge');
    
        // Generate a unique filename
        $filename = time().'_'.$cahierCharge->getClientOriginalName();
    
        // Move the uploaded file to the uploads folder
        $cahierCharge->move(public_path('storage/uploads'), $filename);

        // Get the URL of the uploaded file
        $url = asset('storage/uploads/'.$filename);
        // Update Offre
        $ExistingOffre->status = $requestData['status'];
        $ExistingOffre->titre= $requestData['titre'];
        $ExistingOffre->description= $requestData['description'];
        $ExistingOffre->domaine= $requestData['domaine'];

        $date = $requestData['dateDebut'];;
        $formattedDate = date('Y-m-d', strtotime($date));
        $ExistingOffre->dateDebut = $formattedDate;

        $date2 = $requestData['dateFin'];;
        $formattedDate2 = date('Y-m-d', strtotime($date2));
        $ExistingOffre->dateFin = $formattedDate2;

        $ExistingOffre->typeOffre= $requestData['typeOffre'];
        $ExistingOffre->cahierCharge= $url;

        $ExistingOffre->save();
        
        return response()->json([
            'message' => 'Offre updated successfully',
            'update' => true,
           
        ]);
        
    }else {
        return response()->json([
            'message' => 'Offre not found',
            'update' => false,
            
        ], 404);
    }

}


public function deleteOffre(Request $request){
    $requestData = $request->all();
    // Check if email already exists
    $ExistingOffre = Offre::where('id', $requestData['id'])->first();
    if ($ExistingOffre) {
        // delete Offre
        $ExistingOffre->delete();
        
        return response()->json([
            'message' => 'Offre deleted successfully',
            'delete' => true,
           
        ]);
        
    }else {
        return response()->json([
            'message' => 'Offre not found',
            'delete' => false,
            
        ], 404);
    }

}



public function getAllOffres(Request $request,$idEntreprise){
        // Fetch all offers
        $offres = Offre::where('idEntreprise', $idEntreprise)->get();
        return response()->json([
            'offres' => $offres,
            'message' => 'All offres fetched successfully for idEntreprise ' . $idEntreprise,
            'check' => true,
        ]);
    }


    public function getOffreDetail(Request $request, $idEntreprise, $id)
    {
        // Fetch the specific offer for the given idEntreprise and id
        $offre = Offre::where('idEntreprise', $idEntreprise)
                        ->where('id', $id)
                        ->first();
    
        if (!$offre) {
            // Return a 404 Not Found response if the offer is not found
            return response()->json([
                'message' => 'Offer not found',
                'check' => false,
            ], 404);
        }
    
        // Return the details of the offer
        return response()->json([
            'offre' => $offre,
            'message' => 'Offer details fetched successfully',
            'check' => true,
        ]);
    }

    
    public function OffreDetail(Request $request, $id)
    {
        // Fetch the specific offer for the given idEntreprise and id
        $offre = Offre::where('id', $id)->first();
    
        if (!$offre) {
            // Return a 404 Not Found response if the offer is not found
            return response()->json([
                'message' => 'Offer not found',
                'check' => false,
            ], 404);
        }
    
        // Return the details of the offer
        return response()->json([
            'offre' => $offre,
            'message' => 'Offer details fetched successfully',
            'check' => true,
        ]);
    }
    


    public function AllOffres()
    {
        $offres = Offre::all();
        return response()->json([
            'offres' => $offres,
            'message' => 'Offers  fetched successfully',
            'check' => true,
        ]);
    }

    
    

    



}
