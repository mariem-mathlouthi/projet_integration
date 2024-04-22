<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\entreprise>
 */
class entrepriseFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'numeroSIRET' => $this->faker->unique()->numerify('##############'),
            'email' => $this->faker->unique()->safeEmail,
            'password' => bcrypt('password'), // hash password
            'name' => $this->faker->company,
            'secteur' => $this->faker->word,
            'logo' => $this->faker->imageUrl(),
            'description' => $this->faker->paragraph,
            'link' => $this->faker->url,
        ];
    }
}
