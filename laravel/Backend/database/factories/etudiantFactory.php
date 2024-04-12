<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\etudiant>
 */
class etudiantFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nce' => fake()->unique()->numberBetween(1, 100),
            'idUser' => fake()->randomElement(DB::table('user')->pluck('id')),
            'domaineEtude' => fake()->text(10),
            'typeStage' => fake()->randomElement(['initiation', 'perfectionnement', 'PFE']),
            'specialite' => fake()->text(10),
            'niveau' => fake()->text(10),
            'ncin' => fake()->numberBetween(11111111,99999999),
        ];
    }
}
