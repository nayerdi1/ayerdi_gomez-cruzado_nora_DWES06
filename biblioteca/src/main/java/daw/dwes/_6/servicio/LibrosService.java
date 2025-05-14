package daw.dwes._6.servicio;

import java.util.List;

import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;

public interface LibrosService {

	public List<Libro> getLibros();
	
	public Libro getLibroById(int id);
	
	public Libro aniadirLibro(Libro newLibro);
	
	public Libro modificarLibro(Libro modLibro, int id);
	
	public void borrarLibro(int id);
	
	public Prestamo crearPrestamo(int id);
	
	public Prestamo aniadirDevolucion(int id);
}
