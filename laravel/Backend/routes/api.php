<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\authController;
use App\Http\Controllers\studentController;
use App\Http\Controllers\entrepriseController;
use App\Http\Controllers\demandeController;
use App\Http\Controllers\adminController;
use App\Http\Controllers\offreController;

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
    Route::post('/addDemande', [demandeController::class, 'addDemande']);
    Route::post('/addOffre', [offreController::class, 'addOffre']);

});
