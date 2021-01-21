package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import service.CovidService;

@RestController
public class CovidController {
	@Autowired
	CovidService service;
	
	@GetMapping(value="casos/{municipio}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> casosMunicipio(@PathVariable("municipio") String municipio){
		return service.casosMunicipio(municipio);
	}
	
	@GetMapping(value="casos/{fecha1}/{fecha2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> casosPorFecha(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2){
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fecha1);
		Date f1 = sdf.parse(fecha1);
		Date f2 = sdf.parse(fecha2);
		return service.casosoEntreFechas(f1, f2);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(value="total", produces=MediaType.APPLICATION_JSON_VALUE)
	public String casosTotales() {
		return String.valueOf(service.casosTotalesAcumulados());
	}
}
