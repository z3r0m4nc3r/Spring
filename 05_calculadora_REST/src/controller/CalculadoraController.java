package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

	@GetMapping(value="suma/{a}/{b}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String suma(@PathVariable("a") int a, @PathVariable("b") int b) {
		
		return String.valueOf(a+b);
	}
	
	@GetMapping(value="multiplica/{a}/{b}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String multiplica(@PathVariable("a") int a, @PathVariable("b")int b) {
		return String.valueOf(a*b);
		
	}
	
	@GetMapping(value="cuadrado/{x}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String cuadrado(@PathVariable("x") int x) {
		return String.valueOf(x*x);
	}
}
