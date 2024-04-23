<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('etudiants', function (Blueprint $table) {
            $table->id();
            $table->string('fullname');
            $table->string('niveau');
            $table->string('cin')->unique();
            $table->string('email')->unique();
            $table->string('password');
            $table->string('domaine');
            $table->string('typeStage');
            $table->string('specialite');
            $table->string('etablissement');
            $table->string('image');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('etudiants');
    }
};
