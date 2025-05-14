package daw.dwes._6.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="prestamos")
public class Prestamo {
	 
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "libro_id", nullable = false)
	private int libro_id;

	
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fecha_inicio;
	 
	@Column(name = "fecha_devolucion", nullable = true)
	private LocalDate fecha_devolucion;
	
	public Prestamo(int libro_id) {
		this.libro_id = libro_id;
		this.fecha_inicio = LocalDate.now();
	}
	public Prestamo() {
		    // Constructor por defecto necesario para JPA
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLibro_id() {
		return libro_id;
	}
	public void setLibro_id(int libro_id) {
		this.libro_id = libro_id;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_devolucion = fecha_fin;
	}
	
}

