package daw.dwes._6.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import daw.dwes._6.entity.Libro;
import daw.dwes._6.entity.Prestamo;
import daw.dwes._6.servicio.LibrosService;
import daw.dwes._6.utils.ValidarDato;



@RestController
@RequestMapping("/api")
public class LibrosController {
	
	@Autowired
	private LibrosService librosServicio;
	
	@Autowired
    private ValidarDato datoValidator;
	
	@GetMapping("/getLibros")
	public List<Libro> getLibros(){
		return librosServicio.getLibros();
	} 

	@GetMapping("/getLibro/{id}")
	public Libro getLibro(@PathVariable int id){
	
        return datoValidator.validarExistencia(id);
	} 
	
	@PostMapping("/create")
	public Libro aniadirLibro(@RequestBody Libro nuevoLibro){
		return librosServicio.aniadirLibro(nuevoLibro);
	} 
	
	@PutMapping("/update/{id}")
	public Libro modificarLibro(@RequestBody Libro libro, @PathVariable int id){
		datoValidator.validarExistencia(id);
		return librosServicio.modificarLibro(libro, id);
	} 
	
	@DeleteMapping("/delete/{id}")
	public String borrarLibro(@PathVariable int id){
		datoValidator.validarExistencia(id);
		librosServicio.borrarLibro(id);
	      
		return "libro borrado";
	} 
	
	@PostMapping("/prestamo")
	public Prestamo crearPrestamo(@RequestBody Map<String, Object> data){
		int id = (int) data.get("libro_id");
		return librosServicio.crearPrestamo(id);
	} 
	
	@PutMapping("/devolucion/{id}")
	public Prestamo aniadirPrestamo(@PathVariable int id){
		return librosServicio.aniadirDevolucion(id);
	} 
	
	@PutMapping("/cambiarDisp/{id}")
	public boolean cambiarDisponible(@PathVariable int id){
		return librosServicio.cambiarDisponible(id);
	} 
	
}
