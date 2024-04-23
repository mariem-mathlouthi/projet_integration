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
            'idEtudiant' => $this->faker->randomNumber(),
            'idOffreDeStage' => $this->faker->randomNumber(),
            'statut' => $this->faker->numberBetween(0, 1),
            'DateSoumission' => $this->faker->date(),
            'cv' => $this->faker->imageUrl(),
        ];
    }
}
