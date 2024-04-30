<?php

namespace App\Http\Controllers;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;
use App\Models\Admin;
class adminController extends Controller
{
    //
    public function signUpAdmin(Request $request){
        $requestData = $request->all();
        // Check if email already exists
        $existingAdmin = Admin::where('email', $requestData['email'])->first();
        if ($existingAdmin) {
            return response()->json([
                'message' => 'Email already exists',
                'check' => false,
            ]);
        }
       
        // Create a new admin
        $newAdmin = new Admin();
        $newAdmin->email = $requestData['email'];
        $newAdmin->password = Hash::make($requestData['password']);
        $newAdmin->save();

        return response()->json([
            'message' => 'Account created successfully',
            'check' => true,
        ]);
    }






}
