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
        Schema::create('offre', function ($table) {
            $table->id();
            $table->unsignedBigInteger('idEntreprise'); // foreign
            $table->enum('status',['disponible','non disponible']); // modif to apply later
            $table->string('titre');
            $table->string('description',255);
            $table->string('domaine');
            $table->date('dateDebut');
            $table->date('dateFin');
            $table->string('typeOffre');
            $table->string('cahierCharge'); // file path?
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('offre');
    }
};
