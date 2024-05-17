<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;
use App\Models\Etudiant;

class studentController extends Controller
{
    //
    public function ModifyEtudiantInfo(Request $request){
        $requestData = $request->all();
        // Check if email already exists
        $existingUser = Etudiant::where('email', $requestData['email'])->first();
        if ($existingUser) {
            $image = $request->file('image');
            // Generate a unique filename
            $filename = time() . '_' . $image->getClientOriginalName();
            // Move the uploaded logo file to the uploads folder
            $image->move(public_path('storage/uploads'), $filename);
            $url = asset('storage/uploads/'.$filename);
            // Update Account user
            $existingUser->fullname = $requestData['fullname'];
            $existingUser->niveau = $requestData['niveau'];
            $existingUser->domaine = $requestData['domaine'];
            $existingUser->typeStage = $requestData['typeStage'];
            $existingUser->specialite = $requestData['specialite']; // Corrected typo from 'specailite' to 'specialite'
            $existingUser->etablissement = $requestData['etablissement'];
            $existingUser->image = $url;
            $existingUser->save();
            return response()->json([
                'message' => 'Account updated successfully',
                'update' => true,
            ]);
            
        }else {
            return response()->json([
                'message' => 'Student not found',
                'update' => false,
            ], 404);
        }

    }


    public function getStudentDetail($id)
    {
        // Fetch the specific offer for the given idEntreprise and id
        $student = Etudiant::where('id', $id)->first();
    
        if (!$student) {
            // Return a 404 Not Found response if the offer is not found
            return response()->json([
                'message' => 'Student not found',
                'check' => false,
            ], 404);
        }
    
        // Return the details of the offer
        return response()->json([
            'student' => $student,
            'message' => 'Student detail fetched successfully',
            'check' => true,
        ]);
    }
    

}
