<?php

namespace App\Utils;

use Illuminate\Http\JsonResponse;

class Errors{
    
    // Maneja los errores cuando el servicio no está disponible. 
    public function serviceUnavailable(): JsonResponse{
        return response()->json([
                'status' => 'error',
                'code' => 503,
                'message' => 'Service unavailable',
                'data' => null,
            ], 503
        );
    }
}