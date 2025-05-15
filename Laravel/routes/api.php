<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Http;
use App\Http\Controllers\Libros_controller;


//Route::get('/libros', [Libros_controller::class, 'getLibros']);
Route::get('libros', 'App\Http\Controllers\Libros_controller@getLibros')->name('libros_ruta');

Route::get('libros/{id}', 'App\Http\Controllers\Libros_controller@getLibroId')->name('libroId_ruta');

Route::post('prestamo', 'App\Http\Controllers\Prestamos_controller@prestamo')->name('prestamo_ruta');

Route::put('devolucion/{id}', 'App\Http\Controllers\Prestamos_controller@devolucion')->name('devolucion_ruta');

Route::post('create', 'App\Http\Controllers\Libros_controller@aniadirLibro')->name('create_ruta');

Route::put('update/{id}', 'App\Http\Controllers\Libros_controller@modificarLibro')->name('update_ruta');

Route::delete('delete/{id}', 'App\Http\Controllers\Libros_controller@borrarLibro')->name('delete_ruta');

Route::fallback(function () {
    return response()->json([
        'error' => 'Ruta no encontrada. Verifica la URL e inténtalo de nuevo.'
    ], 404);
});