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
        Schema::create('demandes', function (Blueprint $table) {
            $table->id();
<<<<<<< HEAD:laravel/Backend/database/migrations/2024_04_22_214431_create_demandes_table.php
            $table->unsignedBigInteger('idEtudiant'); // foreign
            $table->unsignedBigInteger('idOffreDeStage'); // foreign
            $table->integer('statut');
            $table->date('DateSoumission');
            $table->String('cv');
=======
            $table->foreignId('idEtudiant'); // foreign
            $table->foreignId('idOffreDeStage'); // foreign
            $table->integer('statut');
            $table->date('DateSoumission');
            $table->string('cv');
>>>>>>> fafd86d718ff14aed71d4b4fc067464c61a3a5fb:laravel/Backend/database/migrations/2024_04_12_190544_create_demandes_table.php
            $table->foreign('idEtudiant')->references('id')->on('etudiants')->onDelete('cascade')->onUpdate('cascade');
            $table->foreign('idOffreDeStage')->references('id')->on('offres')->onDelete('cascade')->onUpdate('cascade');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('demandes');
    }
};
