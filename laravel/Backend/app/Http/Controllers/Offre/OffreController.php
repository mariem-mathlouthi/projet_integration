<?php

namespace App\Http\Controllers\Offre;

use App\Http\Controllers\Controller;
use App\Models\Offre;
use Illuminate\Http\Request;

class OffreController extends Controller
{
    public function GetAllOffre()
    {
        $ofres = Offre::all();
        return response()->json(["data" => $ofres], 200);
    }
}
