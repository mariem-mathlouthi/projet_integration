<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;

use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Artisan;
use Illuminate\Http\Request;

class Controller extends BaseController
{
    use AuthorizesRequests, ValidatesRequests;

    function InitializeDB() {
        Artisan::call('migrate');
    }

    function deleteTables() {
        Artisan::call('migrate:rollback');
    }

    function SeedDB() {
        if (!DB::select('select COUNT(id) as Ntables FROM migrations')[0]->Ntables) {
                 $this->InitializeDB();
        };
        Artisan::call('db:seed');
    }

    // function InitializeDB() {
    //     $dbName = 'laravel_database';
    //     // Create database if it doesn't exist
    //     DB::statement("CREATE DATABASE IF NOT EXISTS $dbName CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci';");
    //     // Create the tables or replace
    //     $this->createTables();
    // }
}