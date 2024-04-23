<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;

use Illuminate\Http\Request;

// upload && download management classes
use Illuminate\Support\Facades\Storage;

class Controller extends BaseController
{
    use AuthorizesRequests, ValidatesRequests;

    public function downloadCahierEntreprise($nomFichier) {
        $nomFichier = $nomFichier.'.pdf';
        $path = storage_path('app/public/files/'.$nomFichier);

        if (!Storage::exists('public/files/'.$nomFichier)) {
            return response()->json([
                'message' => "File doesn't exist",
                'check' => false,
            ]);
        }
        else {
            return response()->download($path, $nomFichier, [
                'Content-Type' => 'application/octet-stream',
                'Content-Disposition' => 'attachment',
            ]);
        }
    }

    public function uploadCV(Request $request) {
        /* request param :
           {
              'file' : file input value
              'nomFichier' : file name
           }
        */
        $nomFichier = $request->all()['nomFichier'];
        // Validate the uploaded file
        if ($request->file('file')->getClientOriginalExtension() == 'pdf') {
            $request->file('file')->storeAs('public/files',$nomFichier.'.pdf');
            return response()->json([
                'message' => "File uploaded successfully",
                'check' => true,
            ]);
        }
        else {
            return response()->json([
                'message' => "File extention must be .pdf",
                'check' => false,
            ]);
        }
    }
}