<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

use Illuminate\Support\Facades\DB;
use Faker\Factory as Faker;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
       // delete old data
       DB::table('user')->delete();
       DB::table('etudiant')->delete();
       DB::table('entreprise')->delete();
       DB::table('offre')->delete();
       DB::table('demande')->delete();
       DB::table('stage')->delete();
        
       $faker = Faker::create();

       // format : columnName => $faker-> someVarTypeSettings
       foreach (range(1, 10) as $index) {
        DB::table('user')->insert([
            'id' => $faker->unique()->numberBetween(1, 100),
            'nom' => $faker->name,
            'email' => $faker->unique()->safeEmail,
            'mdp' => $faker->sha256(), // return hashed password
            'role' => $faker->jobTitle(),
        ]);
       }

       foreach (range(1, 10) as $index) {
        DB::table('etudiant')->insert([
            'nce' => $faker->unique()->numberBetween(1, 100),
            'idUser' => $faker->randomElement(DB::table('user')->pluck('id')),
            'domaineEtude' => $faker->text(10),
            'typeStage' => $faker->randomElement(['initiation', 'perfectionnement', 'PFE']),
            'specialite' => $faker->text(10),
            'niveau' => $faker->text(10),
            'ncin' => $faker->numberBetween(11111111,99999999),
        ]);
       }

       foreach (range(1, 10) as $index) {
        DB::table('entreprise')->insert([
            'numeroSIRET' => $faker->unique()->text(15),
            'idUser' => $faker->randomElement(DB::table('user')->pluck('id')),
            'secteurActivite' => $faker->bs,
        ]);
       }

       foreach (range(1, 10) as $index) {
        DB::table('offre')->insert([
            'id' => $faker->unique()->numberBetween(1, 100),
            'idEntreprise' => $faker->numberBetween(1, 100),
            'status' => $faker->randomElement(['disponible', 'non disponible']),
            'titre' => $faker->jobTitle,
            'description' => $faker->text(20), // return hashed password
            'domaine' => $faker->text(20),
            'dateDebut' => $faker->date,
            'dateFin' => $faker->date,
            'typeOffre' => $faker->text(20),
            'cahierCharge' => $faker->url,
        ]);
       }

       foreach (range(1, 10) as $index) {
        DB::table('demande')->insert([
            'id' => $faker->unique()->numberBetween(1, 100),
            'idEtudiant' => $faker->randomElement(DB::table('etudiant')->pluck('nce')),
            'idOffreDeStage' => $faker->randomElement(DB::table('offre')->pluck('id')),
            'idCandidature' => $faker->numberBetween(1, 100),
            'statut' => $faker->randomElement([1,0]),
            'DateSoumission' => $faker->date,
            'cv' => $faker->randomElement([1,0]),
        ]);
       }

       foreach (range(1, 10) as $index) {
        DB::table('stage')->insert([
            'id' => $faker->unique()->numberBetween(1, 100),
            'dateDebut' => $faker->date,
            'dateFin' => $faker->date,
        ]);
       }
    }
}
