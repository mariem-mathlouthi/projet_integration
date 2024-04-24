<?php

namespace App\Http\Controllers\Stage;

use App\Http\Controllers\Controller;
use App\Models\Stage;
use App\Models\Offre;
use Illuminate\Http\Request;

class StageController extends Controller
{
    public function GetAllStage()
    {
        $stages = Offre::select('offres.titre', 'offres.description', 'entreprises.name')
                        ->join('stages', 'stages.id', '=', 'offres.id')
                        ->join('entreprises', 'entreprises.id', '=', 'offres.idEntreprise')
                        ->get();
        return $stages;
        //return response()->json(["data" => $stages], 200);
    }

     static public function selectStage($idOffre) {
        $offre = Offre::select('dateDebut','dateFin')->where('id',$idOffre)->get();
        if (!count($offre)) {
            return response()->json([
                'message' => "offre doesn't exist",
                'check' => false,
            ]);
        }
        else {
            $stage = new Stage();
            $stage->id = $idOffre;
            $stage->dateDebut = $offre[0]->dateDebut;
            $stage->dateFin = $offre[0]->dateFin;
            $stage->save();

            return response()->json([
                'message' => "stage is added successfully",
                'check' => true,
            ]);
        }
     }
}
