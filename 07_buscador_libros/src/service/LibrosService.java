package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	List<Libro> todosLibros();
	List<Libro> librosPortematica(String tematica);
	Libro libroPorIsbn(int isbn);
	
	void nuevoLibro(Libro libro);
	Libro actualizarLibro(Libro libro);
	void eliminarLibro(int isbn);

}
