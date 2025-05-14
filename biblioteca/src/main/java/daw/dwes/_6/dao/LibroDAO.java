package daw.dwes._6.dao;

import java.util.List;

import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;

public interface LibroDAO {
	public List<Libro> getListaLibros();
	
	public Libro getLibroById(int id);
	
	public Libro aniadirLibro(Libro newLibro);
	
	public Libro modificarLibro(Libro modLibro, int id);
	
	public void borrarLibro(int id);
	
	public Prestamo crearPrestamo(int id);
	
	public Prestamo aniadirDevolucion(int id);

}
