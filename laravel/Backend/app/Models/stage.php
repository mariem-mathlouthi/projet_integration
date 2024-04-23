<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Stage extends Model
{
    protected $guarded=[];
    public $timestamps = false; // prevent creating created_at & updated_at columns
}
