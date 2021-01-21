package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin(origins = "*")
@RestController
public class ProductosController {
	@Autowired
	ProductosService service;
	@GetMapping(value="productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.allProductos();
	}
	
	
	@PutMapping(value="producto/{codigo}/{unidades}")
	public void actualizarProducto(@PathVariable("codigo") int codigo,
			@PathVariable("unidades") int unidades) {
		service.updateStock(codigo, unidades);
	}
	
	@GetMapping(value="precio/{codigo}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String consultarPrecio(@PathVariable("codigo") int codigo) {
		return productos()
				.stream()
				.filter(p->p.getCodigoProducto()==codigo)
				.findFirst()
				.get()
				.getPrecioUnitario()+"";
	}
	@PostMapping(value="producto", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void guardarProducto(@RequestBody Producto producto) {
		service.guardarProducto(producto);
	}
}
