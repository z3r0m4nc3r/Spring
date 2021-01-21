package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Registro;
import service.ContagiosService;

@Api("Servicio de Contagios")
@RestController
public class ContagiosController {
	@Autowired
	ContagiosService service;
	
	@ApiOperation("Devuelve la lista de Registros por pais")
	@GetMapping(value="contagios/{pais}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Registro>> registrosPorPais(@ApiParam("Pais del registro") @PathVariable("pais") String pais){
		List<Registro> registros= service.RegistrosPorPais(pais);
		HttpHeaders headers=new HttpHeaders();
		headers.add("totalRegistros", registros.size()+"");
		return new ResponseEntity<List<Registro>>(registros,headers,HttpStatus.OK);
		
	}
	
	@ApiOperation("Devuelve la lista de Registros entre dos fechas")
	@GetMapping(value="registros/{fecha1}/{fecha2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Registro>> registrosEntreFechas(@ApiParam("Fecha inicial") @PathVariable("fecha1") String fecha1, @ApiParam("Fecha final") @PathVariable("fecha2") String fecha2){
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.UK);
		LocalDate f1 = LocalDate.parse(fecha1, format);
		LocalDate f2 = LocalDate.parse(fecha2, format);
		List<Registro> registros = service.RegistrosEntreFechas(f1, f2);
		HttpHeaders headers=new HttpHeaders();
		headers.add("totalRegistros", registros.size()+"");
		return new ResponseEntity<List<Registro>>(registros,headers,HttpStatus.OK);
		
	}
	
	@ApiOperation("Añade nuevo registro")
	@PostMapping(value="nuevo",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> agregar(@ApiParam("Registro a añadir") @RequestBody Registro registro) {
		service.nuevoRegistro(registro);
		return new ResponseEntity<Void>(null,null,HttpStatus.OK );
	}

}
