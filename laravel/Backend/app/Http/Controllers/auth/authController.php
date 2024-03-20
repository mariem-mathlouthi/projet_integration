<?php

namespace App\Http\Controllers\auth;

use App\Http\Controllers\Controller;
use App\Models\Entreprise;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class authController extends Controller
{
    //
    public function singUp(Request $request){

        $idEntreprise=null;
        if($request->EntrepriseInfo){
        $logo_name = time() . '_' . $request->logo->getClientOriginalName();
        $logo = $request->file('logo')->storeAs('images', $logo_name, 'public');
            $entreprise=new Entreprise();
            $entreprise->name=$request->EntrepriseInfo['nom_ent'];
            $entreprise->logo='/storage/' . $logo;
            $entreprise->description=$request->EntrepriseInfo['desc'];
            $entreprise->secteur=$request->EntrepriseInfo['sec'];
            $entreprise->link=$request->EntrepriseInfo['link'];
            $entreprise->save();
            $idEntreprise=$entreprise->id;

        }

        $file_name = time() . '_' . $request->photo->getClientOriginalName();
        $image = $request->file('photo')->storeAs('images', $file_name, 'public');
  
        $user=User::create([
           "name"=>$request->name,
           "email"=>$request->email,
           "password"=>bcrypt($request->password),
           "role"=>$request->role,

           "entreprise_id"=>$idEntreprise,
           "image"=>'/storage/' . $image,
        ]);
        return response()->json(["data"=>$user],201);
     }

     public function LoginUser(Request $request)
     {
         if (Auth::attempt(['email' => $request->email, 'password' => $request->password])) {
             $user = Auth::user();
             $token = $user->createToken('api_token')->plainTextToken;
             $entreprise=Entreprise::where("id",$user->entreprise_id)->first();
             $respnose = [
                 'token' => $token,
                 'user' => $user,
                 'role' => $user->role,
                 'entreprise'=>$entreprise
             ];
             return response()->json(['data' => $respnose], 200);
         } else {
             return response()->json(['data' => "Utilisateur non trouvé", 'status' => "user"], 401);
         }
     }


    
}
