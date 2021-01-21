package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCurso;
import dto.Utilidades;
import model.Curso;
import service.CursosService;

@RestController
public class CursosController {
	@Autowired
	CursosService service;
	@GetMapping(value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DtoCurso> obtenerCursos(){
		return service.obtenerCursos()
			.stream()
			.map(c->Utilidades.convertirADtoCurso(c))
			.collect(Collectors.toList());
	}
	@PostMapping(value="curso",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
}
