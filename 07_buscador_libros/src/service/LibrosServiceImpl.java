package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {
	
private List<Libro> libros;
	
	public LibrosServiceImpl() {
		libros=new ArrayList<>();
		libros.add(new Libro(1111,"Microservicios Spring Boot","Web"));
		libros.add(new Libro(2222,"Java EE","Programación"));
		libros.add(new Libro(3333,"Python básico","Programación"));
		libros.add(new Libro(4444,"Cisco","Redes"));
	}


	@Override
	public List<Libro> todosLibros() {
		
		return libros;
	}

	@Override
	public List<Libro> librosPortematica(String tematica) {
		
		return libros.stream()
				.filter(l -> l.getTematica().toLowerCase()
						.contains(tematica.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public Libro libroPorIsbn(int isbn) {
		
		return libros.stream()
				.filter(l -> l.getIsbn()==isbn)
				.findFirst().orElse(null);
	}


	@Override
	public void nuevoLibro(Libro libro) {
		libros.add(libro);
		
	}


	@Override
	public Libro actualizarLibro(Libro libro) {
		if(libroPorIsbn(libro.getIsbn())!=null) {
		libros.remove(libroPorIsbn(libro.getIsbn()));
		libros.add(libro);
		}else libros.add(libro);
		return libro;
	}


	@Override
	public void eliminarLibro(int isbn) {
		if(libroPorIsbn(isbn)!=null) {
		libros.remove(libroPorIsbn(isbn));
		}
	}

}
