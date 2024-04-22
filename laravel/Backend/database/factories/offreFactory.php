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
            'idEntreprise' => $this->faker->randomNumber(),
            'status' => $this->faker->randomElement(['disponible', 'non disponible']),
            'titre' => $this->faker->sentence,
            'description' => $this->faker->text(255),
            'domaine' => $this->faker->word,
            'dateDebut' => $this->faker->date(),
            'dateFin' => $this->faker->date(),
            'typeOffre' => $this->faker->word,
            'cahierCharge' => $this->faker->sentence,
        ];
    }
}
