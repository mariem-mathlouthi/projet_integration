<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\Hash;
use App\Models\Entreprise;
use App\Models\Etudiant;
use App\Models\Admin;
use Illuminate\Http\Request;

class authController extends Controller
{
    //

    public function signUpEtudiant(Request $request){
        $requestData = $request->all();
        // Check if email already exists
        $existingUser = Etudiant::where('email', $requestData['email'])->first();
        $existingUser2 = Etudiant::where('cin', $requestData['cin'])->first();
        if ($existingUser) {
            return response()->json([
                'message' => 'Email already exists',
                'check' => false,
            ]);
        }
        if ($existingUser2) {
            return response()->json([
                'message' => 'cin already exists',
                'check' => false,
            ]);
        }
        // Create a new user
        $newUser = new Etudiant();
        $newUser->fullname = $requestData['fullname'];
        $newUser->niveau = $requestData['niveau'];
        $newUser->cin = $requestData['cin'];
        $newUser->email = $requestData['email'];
        $newUser->password = Hash::make($requestData['password']);
        $newUser->domaine = $requestData['domaine'];
        $newUser->typeStage = $requestData['typeStage'];
        $newUser->specialite = $requestData['specialite']; // Corrected typo from 'specailite' to 'specialite'
        $newUser->etablissement = $requestData['etablissement'];
        $newUser->image = $requestData['image'];
        $newUser->save();

        return response()->json([
            'message' => 'Account created successfully',
            'check' => true,
        ]);
    }




    public function signUpEntreprise(Request $request){
        $requestData = $request->all();
        // Check if email already exist
        $existingUser = Entreprise::where('email', $requestData['email'])->first();
        if ($existingUser) {
            return response()->json([
                'message' => 'Email already exists',
                'check' => false,
            ]);
        }
        // Create a new user
        $newUser = new Entreprise();
        $newUser->numeroSIRET = $requestData['numeroSIRET'];
        $newUser->email = $requestData['email'];
        $newUser->password = Hash::make($requestData['password']);
        $newUser->name = $requestData['name'];
        $newUser->secteur = $requestData['secteur'];
        $newUser->logo = $requestData['logo'];
        $newUser->description = $requestData['description'];
        $newUser->link = $requestData['link'];
        $newUser->save();

        return response()->json([
            'message' => 'Account created successfully',
            'check' => true,
        ]);
    }


    public function LoginUser(Request $request)
    {
        $requestData = $request->all();
        $email = $requestData['email'];
        $password = $requestData['password'];

        // Check if the user exists as a student
        $student = Etudiant::where('email', $email)->first();
        if ($student && Hash::check($password, $student->password)) {
            // If the user exists and the password matches, return success
            return response()->json([
                'message' => 'Student login successful',
                'user' => $student,
                'role' => 'student',
                'check' => true,
            ]);
        }
        // Check if the user exists as an entreprise
        $entreprise = Entreprise::where('email', $email)->first();
        if ($entreprise && Hash::check($password, $entreprise->password)) {
            // If the user exists and the password matches, return success
            return response()->json([
                'message' => 'Entreprise login successful',
                'user' => $entreprise,
                'role' => 'entreprise',
                'check' => true,
            ]);
        }
        $admin = Admin::where('email', $email)->first();
        if ($admin && Hash::check($password, $admin->password)) {
            // If the user exists and the password matches, return success
            return response()->json([
                'message' => 'Admin login successful',
                'admin' => $admin,
                'role' => 'admin',
                'check' => true,
            ]);
        }
        // If user doesn't exist or password doesn't match for either student or entreprise
        return response()->json([
            'message' => 'Invalid email or password',
            'check' => false,
        ]);
    }



}