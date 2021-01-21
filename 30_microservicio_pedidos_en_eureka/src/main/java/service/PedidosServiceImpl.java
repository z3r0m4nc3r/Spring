package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pedido;
import repository.PedidosRepository;
@Service
public class PedidosServiceImpl implements PedidosService {
	@Autowired
	PedidosRepository repository;
	@Autowired
	RestTemplate template;
	String url="http://servicio-productos";

	@Override
	public List<Pedido> allPedidos() {
		return repository.findAll();
	}

	@Override
	public void savePedido(Pedido pedido) {
		pedido.setFechaPedido(new Date());
		//obtiene el total del pedido
		pedido.setTotal(obtenerTotal(pedido));
		repository.savePedido(pedido);
		//actualizar stock de productos
		template.put(url+"/producto/{cod}/{unit}", null, pedido.getCodigoProducto(),pedido.getUnidades());		
	}
	//llama de nuevo al servicio de productos para obtener el precio
	//del producto elegido y calcular el total
	private double obtenerTotal(Pedido pedido) {
		String precio=template.getForObject(url+"/precio/{cod}", String.class,pedido.getCodigoProducto());
		double pUnitario= Double.parseDouble(precio);
		return pUnitario*pedido.getUnidades();
		
	}
}
