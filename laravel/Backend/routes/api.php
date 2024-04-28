<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\authController;
use App\Http\Controllers\Demande\DemandeController;
use App\Http\Controllers\Offre\OffreController;
use App\Http\Controllers\Stage\StageController;
use App\Http\Controllers\studentController;
use App\Http\Controllers\entrepriseController;
use App\Http\Controllers\adminController;
use App\Http\Controllers\Controller;


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
    Route::get('/getuseridbyemail/{email}',[authController::class,'GetUserIdByEmail']);
    // authentification
    Route::post('/singupEtudiant', [authController::class, 'signUpEtudiant']);
    Route::post('/signupEntreprise', [authController::class, 'signUpEntreprise']);
    Route::post('/admin', [adminController::class, 'signUpAdmin']);
    Route::post('/login', [authController::class, 'LoginUser']);
    // stage
    Route::get('/getAllStage',[StageController::class,'GetAllStage']);
    Route::get('/selectStage/{idOffre}', [StageController::class,'selectStage']);
    // offre
        // pay attention to order of variables, to ignore variable set it to "all"
    Route::get('/offre/{idEntreprise}/{domaine}/{description}/{titre}',[OffreController::class,'chercherOffres']);
    Route::get('/getAllOffre',[OffreController::class,'GetAllOffre']);
    Route::get('/getoffreById/{id}',[OffreController::class,'GetoffreById']);
    Route::post('/AddOffre',[OffreController::class,'AddOffre']);
    Route::post('/UpdateOffre/{id}',[OffreController::class,'UpdateOffre']);
    Route::delete('/DeleteOffre/{id}',[OffreController::class,'DeleteOffre']);
    // demande
    Route::post('/addDemande',[DemandeController::class,'AddDemande']);
    Route::put('/acceptDemande/{id}',[DemandeController::class,'acceptDemande']);
    // student
    Route::post('/modifyStudent', [studentController::class, 'ModifyEtudiantInfo']);
    // entreprise
    Route::post('/modifyEntreprise', [entrepriseController::class, 'ModifyEntrepriseInfo']);
    // file management
    Route::get('/download/cahierEntreprise/{nomFichier}', [Controller::class,'downloadCahierEntreprise']);
    Route::post('/uploadfile', [Controller::class,'uploadFile']);
    Route::get('/getpath/{nomFichierComplete}', [Controller::class,'getFilePath']);
});
    

