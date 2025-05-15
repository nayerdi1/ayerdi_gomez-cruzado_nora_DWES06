package daw.dwes._6.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import daw.dwes._6.entity.Libro;
import daw.dwes._6.exceptions.ApiExceptions;
import daw.dwes._6.servicio.LibrosService;

@Component
public class ValidarDato {
	
	@Autowired
    private LibrosService librosServicio;

    public Libro validarExistencia(int id) {
        Libro libro = librosServicio.getLibroById(id);
        if (libro == null) {
            throw new ApiExceptions(HttpStatus.NOT_FOUND, "No existe el libro: " + id);
        //	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el libro: " + id);
        }
        return libro;
    }

}
