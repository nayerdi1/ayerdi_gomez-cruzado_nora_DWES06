package daw.dwes._6.entity;


import jakarta.persistence.*;


import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="libros")
public class Libro {

	 
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	 
	@Column(name = "autor", nullable = false)
	private String autor;
	 
	@Column(name = "genero", nullable = false)
	private String genero;
	 
	@Column(name = "disponible", nullable = false)
	private Boolean disponible;
	 
	public Libro(String titulo, String autor, String genero, Boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.disponible = disponible;
	}
	public Libro() {
		    // Constructor por defecto necesario para JPA
	}
	 
	public int getId() {
			return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

}
