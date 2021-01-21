package repository;

import java.util.List;

import model.Pedido;

public interface PedidosRepository {
	List<Pedido> findAll();
	void savePedido(Pedido prod);
	
}
