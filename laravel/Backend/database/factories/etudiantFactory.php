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
            'fullname' => $this->faker->name,
            'niveau' => $this->faker->randomElement(['BAC', 'Licence', 'Master', 'Doctorat']),
            'cin' => $this->faker->unique()->numerify('########'),
            'email' => $this->faker->unique()->safeEmail,
            'password' => bcrypt('password'),
            'domaine' => $this->faker->word,
            'typeStage' => $this->faker->word,
            'specialite' => $this->faker->word,
            'etablissement' => $this->faker->company,
            'image' => $this->faker->imageUrl(),
        ];
    }
}
