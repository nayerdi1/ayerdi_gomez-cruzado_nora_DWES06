<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
//use App\Models\Usuario;
//use App\Models\Prestamo;
use App\Models\Libro;
use Illuminate\Support\Facades\DB;
use Error;
use App\Utils\Errors;
use Illuminate\Support\Facades\Http;
use Illuminate\Http\JsonResponse;

class Prestamos_controller extends Controller
{

    private string $baseUrl;
    private Errors $error;

     
    // Constructor. Inicializa la URL base de la API
    public function __construct(Errors $error)
    {
        $this->baseUrl = env('LIBROS_API_URL') . '/api';
        $this->error = $error;
    }
    // Crea un prestamo y lo añade en la BD
    // Cambia la disponibilidad del libro
    public function prestamo(Request $request){
        try{
            $response = Http::get($this->baseUrl . '/getLibro' . '/' . $request->libro_id);

            $libro = $response->json();
            
            if ($libro['disponible']) {
                // Si el libro está disponible, realiza el préstamo
                $respuestaPrestamo = Http::post($this->baseUrl . '/prestamo', $request->all());

                if ($respuestaPrestamo->successful()) {
                    // Cambia disponibilidad del libro
                    if(Http::put($this->baseUrl . '/cambiarDisp' . '/' . $libro['id'])){
                        $prestamo = $respuestaPrestamo->json();
                        return response()->json([
                        'mensaje' => 'Prestamo añadido correctamente.',
                        'numero de prestamo' => $prestamo['id']
                        ], 201);
                    } return response()->json([
                        'mensaje' => 'Hubo un error al cambiar la disponibilidad del libro.'
                    ], 500);
                    
                } else {
                    // Manejar el caso en que la solicitud falla
                    return response()->json([
                        'mensaje' => 'Hubo un error al procesar el préstamo del libro.'
                    ], 500);
                }
            } else {
                // Si el libro no está disponible
                return response()->json([
                    'mensaje' => 'El libro no está disponible.'
                ], 400);
            }
        }catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }

    }

    // Modifica el prestamo añadiendole una fecha de devolucion
    // Cambia la disponibilidad del libro
    function devolucion($id) {
  
        try{
            $devolucionResp = Http::put($this->baseUrl . '/devolucion' . '/' . $id);
            if($devolucionResp->successful()){
                $devolucion = $devolucionResp->json();
                $cambioDisp = Http::put($this->baseUrl . '/cambiarDisp' . '/' . $devolucion['libro_id']); 
            }
           
            return response()->json($devolucionResp->json(), $devolucionResp->status());
        
        }catch (\Exception $e) {
            return $this->error->serviceUnavailable();
        }
    }
    
}
