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
        Schema::create('etudiant', function ($table) {
            $table->unsignedBigInteger('nce')->primary();
            $table->unsignedBigInteger('idUser'); // foreign
            $table->string('domaineEtude');
            $table->enum('typeStage',['initiation','perfectionnement','PFE']);
            $table->string('specialite');
            $table->string('niveau');
            $table->integer('ncin');
            // linking the foreign key
            $table->foreign('idUser')->references('id')->on('user')->onDelete('cascade')->onUpdate('cascade');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('etudiant');
    }
};
