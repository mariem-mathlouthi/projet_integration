<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('entreprise', function ($table) {
            $table->id('entreprise_id');
            $table->string('numeroSIRET');
            $table->string('email')->unique();
            $table->string('password');
            $table->string('name');
            $table->string('secteur');
            $table->string('logo');
            $table->text('description');
            $table->string('link');
            $table->timestamps();
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
