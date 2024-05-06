<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;
use App\Models\Admin;
use App\Models\Etudiant;
use App\Models\Entreprise;
use App\Models\Offre;
class adminController extends Controller
{
    //
    public function signUpAdmin(Request $request){
        $requestData = $request->all();
        // Check if email already exists
        $existingAdmin = Admin::where('email', $requestData['email'])->first();
        if ($existingAdmin) {
            return response()->json([
                'message' => 'Email already exists',
                'check' => false,
            ]);
        }
       
        // Create a new admin
        $newAdmin = new Admin();
        $newAdmin->email = $requestData['email'];
        $newAdmin->password = Hash::make($requestData['password']);
        $newAdmin->save();

        return response()->json([
            'message' => 'Account created successfully',
            'check' => true,
        ]);
    }

    public function states(){
        $newOrders = Offre::count();
        $companies = Entreprise::count();
        $students  = Etudiant::count();    
    
        return response()->json([
            'newOrders' => $newOrders,
            'companies' => $companies,
            'students' => $students
        ]);
    }
    public function getAllOffresAdmin(){
        // Fetch all offers
        $offres = Offre::all();
        return response()->json([
            'offres' => $offres,
            'message' => 'All offres fetched successfully',
            'check' => true,
        ]);
    }

    public function updateOfferStatus(Request $request, $id) {  
        $offer = Offre::findOrFail($id);
        $newStatus = $request->input('status');
    
        // Vérifiez si le statut fourni est valide
        if ($newStatus !== 'en attente' && $newStatus !== 'accepté' && $newStatus !== 'refusé') {
            return response()->json([
                'error' => 'Invalid status provided'
            ], 400);
        }
    
        // Mettez à jour le statut de l'offre
        $offer->status = $newStatus;
        $offer->save();
    
        return response()->json([
            'message' => 'Offer status updated successfully',
            'offer' => $offer
        ]);
    }
    public function getAllStudents()
    {
        // Récupérer tous les étudiants
        $students = Etudiant::all();
    
        // Vérifier si des étudiants sont trouvés
        if ($students->isEmpty()) {
            // Retourner une réponse 404 Not Found si aucun étudiant n'est trouvé
            return response()->json([
                'message' => 'Aucun étudiant trouvé',
                'students' => [],
            ], 404);
        }
    
        // Retourner la liste des étudiants
        return response()->json([
            'students' => $students,
            'message' => 'Étudiants récupérés avec succès',
        ]);
    }
    public function deleteStudent($id)
    {
        // Recherche de l'étudiant à supprimer
        $student = Etudiant::find($id);

        // Vérifie si l'étudiant existe
        if (!$student) {
            return response()->json([
                'message' => 'Étudiant non trouvé',
            ], 404);
        }

        // Suppression de l'étudiant
        $student->delete();

        return response()->json([
            'message' => 'Étudiant supprimé avec succès',
        ]);
    }
    public function getAllEnterprises()
    {
        // Fetch all enterprises
        $enterprises = Entreprise::all();
    
        // Check if any enterprises are found
        if ($enterprises->isEmpty()) {
            // Return a 404 Not Found response if no enterprises are found
            return response()->json([
                'message' => 'No enterprises found',
                'enterprises' => [],
            ], 404);
        }
    
        // Return the list of enterprises
        return response()->json([
            'enterprises' => $enterprises,
            'message' => 'Enterprises fetched successfully',
        ]);
    }
    public function deleteEntreprise($id)
    {
        // Rechercher l'entreprise à supprimer
        $entreprise = Entreprise::find($id);

        // Vérifier si l'entreprise existe
        if (!$entreprise) {
            // Retourner une réponse 404 Not Found si l'entreprise n'est pas trouvée
            return response()->json([
                'message' => 'Entreprise not found',
            ], Response::HTTP_NOT_FOUND);
        }

        // Supprimer l'entreprise
        $entreprise->delete();

        // Retourner une réponse de succès
        return response()->json([
            'message' => 'Entreprise deleted successfully',
        ]);
    }
    






}
