<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
//use App\Models\Libro;
//use App\DTO\LibroDTO;
use Illuminate\Support\Facades\DB;
use Error;
use App\Utils\Errors;
use Illuminate\Support\Facades\Http;
use Illuminate\Http\JsonResponse;

class Libros_controller extends Controller
{
    private string $baseUrl;
    private Errors $error;

     
    // Constructor. Inicializa la URL base de la API
    public function __construct(Errors $error)
    {
        $this->baseUrl = env('LIBROS_API_URL') . '/api'; //Variable de entorno configurada en .env
        $this->error = $error;
    }
    // Devuelve todos los libros con una llamada GET al microservicio
    public function getLibros(){  
        try {
            $libros = Http::get($this->baseUrl . '/getLibros');
            return response()->json($libros->json(), $libros->status());
        } catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
    }

    // Devuelve un libro de la BD
    public function getLibroId($id){
        try{
            $libro =  Http::get($this->baseUrl . '/getLibro' . '/' . $id);
            return response()->json($libro->json(), $libro->status());   
        } catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
        
    }

    // Añade un nuevo libro a la BD
    function aniadirLibro(Request $request) {
        try{
            $libro = Http::post($this->baseUrl . '/create', $request->json()->all());

            return response()->json([
                'mensaje' => 'Libro añadido correctamente:',
                'libro' => $libro->json()
            ], 201);
        } catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
    }

    // Comprueba que el usuario tenga la sesion iniciada y sea administrador
    // Modifica libro de la BD
    function modificarLibro(int $id, Request $request) {
        try{
            $libroModificado = Http::put($this->baseUrl . '/update' . '/' . $id, $request->all());    
            return response()->json($libroModificado->json(), $libroModificado->status());
   
        } catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
    }

    // Borra libro de la BD
    function borrarLibro($id, Request $request) {
        try{
            $libroBorrado = Http::delete($this->baseUrl . '/delete' . '/' . $id);
            return response()->json($libroBorrado->json(), $libroBorrado->status());

        } catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
    }
 
}
