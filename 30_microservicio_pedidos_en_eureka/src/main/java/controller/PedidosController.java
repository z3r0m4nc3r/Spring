package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidosService;
@CrossOrigin(origins = "*")
@RestController
public class PedidosController {
	@Autowired
	PedidosService service;
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos(){
		return service.allPedidos();
	}
	
	
	@PostMapping(value="pedido",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarProducto(@RequestBody Pedido pedido) {
		service.savePedido(pedido);
	}
}
