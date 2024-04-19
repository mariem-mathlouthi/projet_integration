<?php

namespace App\Http\Controllers\Stage;

use App\Http\Controllers\Controller;
use App\Models\Stage;
use Illuminate\Http\Request;

class StageController extends Controller
{
    public function GetAllStage()
    {
        $stages = Stage::all();
        return response()->json(["data" => $stages], 200);
    }
}
