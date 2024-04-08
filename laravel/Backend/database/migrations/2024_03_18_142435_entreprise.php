<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('entreprise', function ($table) {
            $table->string('numeroSIRET')->primary();
            $table->unsignedBigInteger('idUser'); // foreign
            $table->string('secteurActivite');
            // linking the foreign key
            $table->foreign('idUser')->references('id')->on('user')->onDelete('cascade')->onUpdate('cascade');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('entreprise');
    }
};
