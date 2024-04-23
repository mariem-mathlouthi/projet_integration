<?php

namespace App\Http\Middleware;

use Illuminate\Foundation\Http\Middleware\VerifyCsrfToken as Middleware;

class VerifyCsrfToken extends Middleware
{
    /**
     * The URIs that should be excluded from CSRF verification.
     *
     * @var array<int, string>
     */
    protected $except = [
        //
        'api/singupEtudiant',
        'api/signupEntreprise',
        'api/admin',
        'api/login',
        'api/GetAllOffre',
        'api/ GetoffreById',
        'api/GetAllStage',
        'api/AddDemande',
        'api/modifyStudent',
<<<<<<< HEAD
        'api/modifyEntreprise',
        'api/addDemande',
        'api/addOffre',
=======
        'api/AddOffre',
        'api/UpdateOffre',
        'api/DeleteOffre',
        'api/acceptDemande'
>>>>>>> fafd86d718ff14aed71d4b4fc067464c61a3a5fb
        
    ];
}
