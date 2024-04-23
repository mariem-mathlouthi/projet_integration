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

    public function GetoffreById($id){
        $offre=Offre::find($id);
        if($offre){
            return response()->json(["data"=>$offre],200);
        }else{
            return response()->json(["message"=>"NOt Found"],404);
        }
    }
    public function UpdateOffre(Request $request, $id)
    {
        $offre = Offre::find($id);
    
        if ($offre) {
            $offre->update([
                'idEntreprise' => $request->idEntreprise,
                'status' => $request->status,
                'titre' => $request->titre,
                'description' => $request->description,
                'domaine' => $request->domaine,
                'dateDebut' => $request->dateDebut,
                'dateFin' => $request->dateFin,
                'typeOffre' => $request->typeOffre,
                'cahierCharge' => $request->cahierCharge,
            ]);
    
            return response()->json(["message" => "Offre mise à jour"], 200);
        } else {
            return response()->json(["message" => "Offre non trouvée"], 404);
        }
    }
    public function DeleteOffre($id)
{
    $offre = Offre::find($id);

    if ($offre) {
        $offre->delete();
        return response()->json(["message" => "Offre supprimée"], 200);
    } else {
        return response()->json(["message" => "Non trouvé"], 404);
    }
}

    
        static public function chercherOffres($id,$domaine,$type,$titre) {
        if ($id == "all" && $domaine == "all" && $type == "all" && $titre == "all") {
             $data = Offre::all(); 
         }
         else {
             $data = Offre::query()
             ->when($id != "all", function ($query) use ($id) {
                 return $query->where('id', $id);
             })
             ->when($domaine != "all", function ($query) use ($domaine) {
                 return $query->where('domaine', $domaine);
             })
             ->when($type != "all", function ($query) use ($type)  {
                 return $query->where('typeOffre', $type);
             })
             ->when($titre != "all", function ($query) use ($titre) {
                 return $query->where('titre', $titre);
             })->get();
         }
         return $data;
         //print($data); // for testing
     }


     public function AddOffre(Request $request)
{
    $requestData = $request->all();

    $newOffre = new Offre();
    $newOffre->idEntreprise = $requestData['idEntreprise'];
    $newOffre->status = $requestData['status'];
    $newOffre->titre = $requestData['titre'];
    $newOffre->description = $requestData['description'];
    $newOffre->domaine = $requestData['domaine'];
    $newOffre->dateDebut = $requestData['dateDebut'];
    $newOffre->dateFin = $requestData['dateFin'];
    $newOffre->typeOffre = $requestData['typeOffre'];
    $newOffre->cahierCharge = $requestData['cahierCharge'];

    $newOffre->save();

    return response()->json([
        'message' => 'Offre ajoutée avec succès',
        'check' => true,
    ]);
}
}
