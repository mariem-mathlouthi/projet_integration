<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Entreprise;

class entrepriseController extends Controller
{
    //
    public function ModifyEntrepriseInfo(Request $request)
{
    $requestData = $request->all();

    // Check if email already exists
    $existingUser = Entreprise::where('email', $requestData['email'])->first();

    if ($existingUser) {
        // Check if a logo file is uploaded
        $logo = $request->file('logo');
        // Generate a unique filename
        $filename = time() . '_' . $logo->getClientOriginalName();
        // Move the uploaded logo file to the uploads folder
        $logo->move(public_path('storage/uploads'), $filename);
        $url = asset('storage/uploads/'.$filename);

        // Update other fields of the existing user
        $existingUser->numeroSIRET = $requestData['numeroSIRET'];
        $existingUser->name = $requestData['name'];
        $existingUser->secteur = $requestData['secteur'];
        $existingUser->logo = $url;
        $existingUser->description = $requestData['description'];
        $existingUser->save();

        return response()->json([
            'message' => 'Account updated successfully',
            'update' => true,
        ]);
    } else {
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
            'message' => 'Entreprises details fetched successfully',
            'check' => true,
        ]);
    }
    



    


}
