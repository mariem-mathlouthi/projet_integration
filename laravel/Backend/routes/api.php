<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\authController;
use App\Http\Controllers\studentController;
use App\Http\Controllers\entrepriseController;
use App\Http\Controllers\demandeController;
use App\Http\Controllers\adminController;
use App\Http\Controllers\offreController;
use App\Http\Controllers\notificationController;
use App\Http\Controllers\attestationController;


/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::group(['middleware' => 'cors'], function () {
    Route::post('/singupEtudiant', [authController::class, 'signUpEtudiant']);
    Route::post('/signupEntreprise', [authController::class, 'signUpEntreprise']);
    Route::post('/admin', [adminController::class, 'signUpAdmin']);
    Route::post('/login', [authController::class, 'LoginUser']);
    Route::post('/modifyStudent', [studentController::class, 'ModifyEtudiantInfo']);
    Route::post('/modifyEntreprise', [entrepriseController::class, 'ModifyEntrepriseInfo']);
    Route::get('/getStudentDetail/{id}', [studentController::class, 'getStudentDetail']);
    Route::get('/getEntreprise/{idEntreprise}', [entrepriseController::class, 'getEntreprise']);
    Route::post('/addDemande', [demandeController::class, 'addDemande']);
    Route::post('/updateSatutDemande/{id}', [demandeController::class, 'updateStatut']);
    Route::delete('/deleteDemande/{id}', [demandeController::class, 'deleteDemande']);
    Route::get('/getDemandes/{idEtudiant}', [demandeController::class, 'getAllDemandes']);
    Route::get('/getDemandeById/{id}', [demandeController::class, 'getDemandeById']);
    Route::get('/getDemandeByOfferId/{offerId}', [demandeController::class, 'getDemandeByOfferId']);
    Route::get('/Demandes', [demandeController::class, 'Demandes']);
    Route::post('/addOffre', [offreController::class, 'addOffre']);
    Route::get('/getOffres/{idEntreprise}', [offreController::class, 'getAllOffres']);
    Route::get('/allOffres', [offreController::class, 'AllOffres']);
    Route::get('/offreDetail/{idEntreprise}/{id}', [offreController::class, 'getOffreDetail']);
    Route::get('/offreDetail2/{id}', [offreController::class, 'OffreDetail']);
    Route::post('/updateOffre', [offreController::class, 'updateOffre']);
    Route::post('/deleteOffre', [offreController::class, 'deleteOffre']);

});


Route::group(['middleware' => 'cors'], function () {
    Route::post('/notification', [notificationController::class, 'notification']);
    Route::get('/getAllNotifications', [notificationController::class, 'getAllNotifications']);
    Route::post('/attestation', [attestationController::class, 'addAttestation']);
    Route::get('/getAttestation/{idEtudiant}', [attestationController::class, 'getAttestationByEtudiant_Offer']);

});


Route::group(['middleware' => 'cors'], function () {
    Route::get('/states', [adminController::class,'states']);
    Route::get('/getAllOffreAdmin', [adminController::class, 'getAllOffresAdmin']);
    Route::post('/updateOfferStatus/{id}', [adminController::class, 'updateOfferStatus']);
    Route::delete('/deleteOffer/{id}', [adminController::class, 'deleteOffer']);
    Route::post('/admin', [adminController::class, 'signUpAdmin']);
    Route::get('/enterprisesAdmin', [adminController::class, 'getAllEnterprises']);
    Route::delete('/enterprisesAdmin/{id}', [adminController::class, 'deleteEntreprise']);
    Route::get('/studentsAdmin', [adminController::class, 'getAllStudents']);
    Route::delete('/deleteStudentAdmin/{id}', [adminController::class, 'deleteStudent']);
});
