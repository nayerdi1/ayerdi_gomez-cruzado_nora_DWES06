package daw.dwes._6.dao;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;
import daw.dwes._6.exceptions.ApiExceptions;

@Repository
public class LibroDAOImpl implements LibroDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Libro> getListaLibros() {
		// Obtener la sesión de Hibernate
		Session currentSession= entityManager.unwrap(Session.class);
		// Crear la consulta HQL
		Query<Libro> consulta= currentSession.createQuery("from Libro",Libro.class);
		// Ejecutar la consulta y obtener los resultados
		List<Libro> libros = consulta.getResultList();
		return libros;
	}

	// Devuelve todos los libros
	@Override
	@Transactional
	public Libro getLibroById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
        Libro libro = currentSession.get(Libro.class, id);

        return libro;
	}

	// Devuelve un libro por su ID
	@Override
	@Transactional
	public Libro aniadirLibro(Libro nuevoLibro) {
		Session currentSession = entityManager.unwrap(Session.class);

        currentSession.persist(nuevoLibro);
        return nuevoLibro;

	}

	// Modifica el libro que se le pasa por parametro
	@Override
	@Transactional
	public Libro modificarLibro(Libro modLibro, int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		modLibro.setId(id);
		currentSession.merge(modLibro);
        return modLibro;

	}

	// Borra el libro de la BBDD
	@Override
	@Transactional
	public void borrarLibro(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Libro libro = currentSession.get(Libro.class, id);
		if (libro != null) {
	        currentSession.remove(libro);
	    } else {
	    	throw new ApiExceptions(HttpStatus.NOT_FOUND, "Libro con id " + id + " no encontrado");
	    }
	}

	// Crea un nuevo prestamo en la BBDD
	@Override
	@Transactional
	public Prestamo crearPrestamo(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		 Prestamo nuevoPrestamo = new Prestamo(id);

		 // Guardarlo en la base de datos
		 currentSession.persist(nuevoPrestamo);
		 
		 return nuevoPrestamo;

	}

	// Añade la fecha de devolucion a un prestamo ya existente
	@Override
	@Transactional
	public Prestamo aniadirDevolucion(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Prestamo prestamo = currentSession.get(Prestamo.class, id);
		
		if (prestamo == null) {
	        throw new ApiExceptions(HttpStatus.NOT_FOUND, "Préstamo con id " + id + " no encontrado");
	    }
		if(prestamo.getFecha_devolucion() != null) {
			throw new ApiExceptions(HttpStatus.BAD_REQUEST, "La devolución ya ha sido procesada para el préstamo con id " + id);
		}
		
		prestamo.setFecha_devolucion(LocalDate.now());		
		currentSession.merge(prestamo);
		
		return prestamo;
	}

	// Cambia la disponibilidad de un libro 
	@Override
	@Transactional
	public boolean cambiarDisponible(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Libro libro = currentSession.get(Libro.class, id);
		//Libro libro = entityManager.find(Libro.class, id);
		
		if (libro == null) {
	        throw new ApiExceptions(HttpStatus.NOT_FOUND, "Libro con id " + id + " no encontrado");
	    }
		// Cambiar disponibilidad
		libro.setDisponible(!libro.getDisponible());
		
		
        // Guardar los cambios en la base de datos
        currentSession.merge(libro);
        currentSession.flush();

	    
	    
	    return true;
	}
}
