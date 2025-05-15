<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('libros', function (Blueprint $table) {
            $table->id();  // Esto crea una columna 'id' auto-incremental
            $table->string('titulo'); 
            $table->string('autor');  
            $table->string('genero'); 
            $table->boolean('disponible')->default(true);; // Agrega una columna 'disponible' de tipo boolean
            $table->timestamps();  // Agrega las columnas 'created_at' y 'updated_at'
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
       # Schema::dropIfExists('libros');
    }
};
