package daw.dwes._6.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import daw.dwes._6.dao.LibroDAO;
import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;

@Service
public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	public LibroDAO libroDAO;

	@Override
	public List<Libro> getLibros() {
		List<Libro> listaLibros = libroDAO.getListaLibros();
		return listaLibros;
	}

	@Override
	public Libro getLibroById(int id) {
		Libro libro = libroDAO.getLibroById(id);
		return libro;
	}

	@Override
	public Libro aniadirLibro(Libro nuevoLibro) {
		return libroDAO.aniadirLibro(nuevoLibro);
		
	}

	@Override
	public Libro modificarLibro(Libro modLibro, int id) {
		return libroDAO.modificarLibro(modLibro, id);
		
	}

	@Override
	public void borrarLibro(int id) {
		libroDAO.borrarLibro(id);
		
	}

	@Override
	public Prestamo crearPrestamo(int id) {
		
		return libroDAO.crearPrestamo(id);
		
	}

	@Override
	public Prestamo aniadirDevolucion(int id) {
		return libroDAO.aniadirDevolucion(id);
	}

	@Override
	public boolean cambiarDisponible(int id) {
	
		return libroDAO.cambiarDisponible(id);
	}

}
