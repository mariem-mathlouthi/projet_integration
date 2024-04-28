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

    public function uploadFile(Request $request) {
        /* request param :
           {
              data...
              'file' : file input value
              'filetype' : acceptable file extension
           }
        */
        $nomFichier = $request->file('file')->getClientOriginalName();
        // Validate the uploaded file
        if (strpos($request->all()['filetype'], $request->file('file')->getClientOriginalExtension()) !==false) {
            $request->file('file')->storeAs('public/files',$nomFichier);
            return response()->json([
                'message' => "File uploaded successfully",
                'check' => true,
            ]);
        }
        else {
            return response()->json([
                'error' => "File extention must be .".$request->all()['filetype'],
                'check' => false,
            ]);
        }
    }

    public function getFilePath($nomFichierComplete) {
        $path = storage_path('app/public/files/' . $nomFichierComplete);

        if (file_exists($path)) {
            return response()->file($path);
        } 
        else {
            abort(404);
        }
    }
}