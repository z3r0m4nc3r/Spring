package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCurso;
import dto.Utilidades;
import model.Curso;
import service.CursosService;

@RestController
public class FormacionController {

	@Autowired
	CursosService cursosService;
	
	@PostMapping(value="nuevoCurso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaCurso(@RequestBody Curso curso){
		cursosService.altaCurso(curso);
		return new ResponseEntity<Void>(null,null,HttpStatus.OK);
		
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DtoCurso>> listaCursos(){
		
		List<DtoCurso> DtoCursos = cursosService.obtenerCursos().stream()
				.map(c -> Utilidades.convertirADtoCurso(c))
				.collect(Collectors.toList());
		return new ResponseEntity<List<DtoCurso>>(DtoCursos,null,HttpStatus.OK);
	}
}
