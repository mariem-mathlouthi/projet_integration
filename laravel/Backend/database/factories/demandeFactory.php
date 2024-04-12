<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\demande>
 */
class demandeFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'id' => fake()->unique()->numberBetween(1, 100),
            'idEtudiant' => fake()->randomElement(DB::table('etudiant')->pluck('nce')),
            'idOffreDeStage' => fake()->randomElement(DB::table('offre')->pluck('id')),
            'idCandidature' => fake()->numberBetween(1, 100),
            'statut' => fake()->randomElement([1,0]),
            'DateSoumission' => fake()->date,
            'cv' => fake()->randomElement([1,0]),
        ];
    }
}
