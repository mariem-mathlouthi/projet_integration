<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\offre>
 */
class offreFactory extends Factory
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
            'idEntreprise' => fake()->numberBetween(1, 100),
            'status' => fake()->randomElement(['disponible', 'non disponible']),
            'titre' => fake()->jobTitle,
            'description' => fake()->text(20), // return hashed password
            'domaine' => fake()->text(20),
            'dateDebut' => fake()->date,
            'dateFin' => fake()->date,
            'typeOffre' => fake()->text(20),
            'cahierCharge' => fake()->url,
        ];
    }
}
