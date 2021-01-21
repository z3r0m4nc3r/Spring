package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Pedido;
@Repository
public class PedidosRepositoryImpl implements PedidosRepository {
	@Autowired
	PedidosJpaRepository repository;
	
	@Override
	public List<Pedido> findAll() {		
		return repository.findAll();
	}

	@Override
	public void savePedido(Pedido prod) {
		repository.save(prod);
	}

	

}
