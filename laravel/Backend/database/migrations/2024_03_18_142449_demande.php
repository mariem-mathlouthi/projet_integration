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
        Schema::create('demande', function ($table) {
            $table->id();
            $table->unsignedBigInteger('idEtudiant'); // foreign
            $table->unsignedBigInteger('idCandidature'); // foreign
            $table->unsignedBigInteger('idOffreDeStage'); // foreign
            $table->integer('statut');
            $table->date('DateSoumission');
            $table->integer('cv');
            // linking the foreign key
            $table->foreign('idEtudiant')->references('nce')->on('etudiant')->onDelete('cascade')->onUpdate('cascade');
            $table->foreign('idOffreDeStage')->references('id')->on('offre')->onDelete('cascade')->onUpdate('cascade');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('demande');
    }
};
