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
        'api/modifyStudent',
        'api/modifyEntreprise',
        'api/addDemande',
        'api/addOffre',
        'api/UpdateOffre',
        'api/DeleteOffre',
        'api/acceptDemande'
        
    ];
}
