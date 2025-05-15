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
     /*   Schema::create('usuarios', function (Blueprint $table) {
            $table->id();
            $table->timestamps();
        });*/
        Schema::create('usuarios', function (Blueprint $table) {
            $table->id();  // Esto crea una columna 'id' auto-incremental
            $table->string('usuario');
            $table->string('nombre'); 
            $table->string('contrasenia'); 
            $table->enum('rol', ['administrador', 'usuario']);
            $table->boolean('sesion_iniciada')->default(false);; 
            $table->timestamps();  // Agrega las columnas 'created_at' y 'updated_at'
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('usuarios');
    }
};
