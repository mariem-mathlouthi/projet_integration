<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\authController;
use App\Http\Controllers\Demande\DemandeController;
use App\Http\Controllers\Offre\OffreController;
use App\Http\Controllers\Stage\StageController;

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
    Route::post('/login', [authController::class, 'LoginUser']);
    Route::get('/GetAllStage',[StageController::class,'GetAllStage']);
    Route::get('/GetAllOffre',[OffreController::class,'GetAllOffre']);
    Route::get('/GetoffreById/{id}',[OffreController::class,'GetoffreById']);
});
