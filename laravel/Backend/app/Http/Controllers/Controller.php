<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;

use Illuminate\Http\Request;
use Illuminate\Http\Response;
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
        if ($request->file('file')->getClientOriginalExtension() == $request->all()['filetype']) {
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
            ],Response::HTTP_BAD_REQUEST);
        }
    }
}