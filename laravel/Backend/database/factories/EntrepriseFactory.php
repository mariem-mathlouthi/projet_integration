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
            'numeroSIRET' => fake()->unique()->text(15),
            'idUser' => fake()->randomElement(DB::table('user')->pluck('id')),
            'secteurActivite' => fake()->bs,
        ];
    }
}
