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
            $table->unsignedBigInteger('idEtudiant'); // foreign
            $table->unsignedBigInteger('idOffreDeStage'); // foreign
            $table->enum('statut',['en attente','accepté','rejeté','en execution']);
            $table->date('DateSoumission');
            $table->String('cv');
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
