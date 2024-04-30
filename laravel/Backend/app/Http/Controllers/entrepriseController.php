<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Entreprise;

class entrepriseController extends Controller
{
    //
    public function ModifyEntrepriseInfo(Request $request){
        $requestData = $request->all();
        // Check if email already exists
        $existingUser = Entreprise::where('email', $requestData['email'])->first();
        if ($existingUser) {
            // Update Account user
            $existingUser->numeroSIRET= $requestData['numeroSIRET'];
            $existingUser->name = $requestData['name'];
            $existingUser->secteur = $requestData['secteur'];
            $existingUser->description = $requestData['description'];
            $existingUser->save();
            return response()->json([
                'message' => 'Account updated successfully',
                'update' => true,
               
            ]);
            
        }else {
            return response()->json([
                'message' => 'Entreprise not found',
                'update' => false,
                
            ], 404);
        }

    }

    public function getEntreprise(Request $request, $idEntreprise)
    {
        // Fetch the specific offer for the given idEntreprise and id
        $entreprise = Entreprise::where('id', $idEntreprise)->first();
    
        if (!$entreprise) {
            // Return a 404 Not Found response if the offer is not found
            return response()->json([
                'message' => 'Entreprise not found',
                'check' => false,
            ], 404);
        }
    
        // Return the details of the offer
        return response()->json([
            'entreprise' => $entreprise,
            'message' => 'Offer details fetched successfully',
            'check' => true,
        ]);
    }
    



    


}
