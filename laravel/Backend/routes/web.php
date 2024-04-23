<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\dbController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});


// creating or deleting tables
Route::get('/db/init', [dbController::class,"InitializeDB"]);
Route::get('/db/deletetables', [dbController::class,"deleteTables"]);
// filling the database
Route::get('/db/seed', [dbController::class,"SeedDB"]);