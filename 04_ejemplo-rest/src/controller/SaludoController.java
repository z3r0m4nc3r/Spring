package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

	@GetMapping(value="saludo", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Bienvenido a REST";
	}
	
	@GetMapping(value="saludo/{nombre}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable("nombre") String nombre) {
		return "Bienvenido a REST "+nombre;
	}
	
	@GetMapping(value="saludopersonal",produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@RequestParam("name") String nombre, 
						  @RequestParam("age") int edad) {
		return "Bienvenido a REST sr/a "+nombre+" tienes "+edad+" a�os";
	}
}
