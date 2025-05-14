package daw.dwes._6.dao;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;

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

	@Override
	@Transactional
	public Libro getLibroById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

        Libro libro = currentSession.get(Libro.class, id);

        return libro;
	}

	@Override
	@Transactional
	public Libro aniadirLibro(Libro nuevoLibro) {
		Session currentSession = entityManager.unwrap(Session.class);

        currentSession.persist(nuevoLibro);
        return nuevoLibro;

	}

	@Override
	@Transactional
	public Libro modificarLibro(Libro modLibro, int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		modLibro.setId(id);
		currentSession.merge(modLibro);
        return modLibro;

	}

	@Override
	@Transactional
	public void borrarLibro(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Libro libro = currentSession.get(Libro.class, id);
		if (libro != null) {
	        currentSession.remove(libro);
	    } else {
	        throw new RuntimeException("Libro con id " + id + " no encontrado");
	    }
	}

	@Override
	@Transactional
	public Prestamo crearPrestamo(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		 Prestamo nuevoPrestamo = new Prestamo(id);

		 // Guardarlo en la base de datos
		 currentSession.persist(nuevoPrestamo);
		 
		 return nuevoPrestamo;

	}

	@Override
	@Transactional
	public Prestamo aniadirDevolucion(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Prestamo prestamo = currentSession.get(Prestamo.class, id);
		prestamo.setFecha_fin(LocalDate.now());
		
		currentSession.merge(prestamo);
		
		return prestamo;
	}
}
