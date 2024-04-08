<?php

use App\Http\Controllers\Controller;

use Illuminate\Support\Facades\Route;

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

// creating or deleting tables
Route::get('/', [Controller::class,"InitializeDB"]);
Route::get('/deletetables', [Controller::class,"deleteTables"]);
// filling the database
Route::get('/seeddb', [Controller::class,"SeedDB"]);
