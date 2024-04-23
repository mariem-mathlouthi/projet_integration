<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\User;
use App\Models\offre;
use App\Models\etudiant;
use App\Models\Entreprise;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        User::factory()->count(10)->create();
        offre::factory()->count(10)->create();
        etudiant::factory()->count(10)->create();
        Entreprise::factory()->count(10)->create();
    }
}
