<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Notification;
class notificationController extends Controller
{
    //
    public function notification(Request $request){
        $requestData = $request->all();
        $new = new Notification();
        $new->idEtudiant =$requestData['idEtudiant'];
        $new->idEntreprise = $requestData['idEntreprise'];
        $new->message= $requestData['message'];
        $new->destination= $requestData['destination'];
        $new->type= $requestData['type'];
        $new->visibility=$requestData['visibility'];
        $date = $requestData['date'];;
        $formattedDate = date('Y-m-d', strtotime($date));
        $new->date = $formattedDate;
        $new->save();

        return response()->json([
            'message' => 'Notification Added successfully',
            'check' => true,
        ]);
        

    }


    public function getAllNotifications()
    {
        $notifications = Notification::all();
        return response()->json([
            'notifications' => $notifications,
            'message' => 'notifications  fetched successfully',
            'check' => true,
        ]);
    }









}
