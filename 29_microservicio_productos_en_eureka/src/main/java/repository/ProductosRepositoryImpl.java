package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Producto;
@Repository
public class ProductosRepositoryImpl implements ProductosRepository {
	@Autowired
	ProductosJpaRepository repository;
	
	@Override
	public List<Producto> findAll() {
		return repository.findAll();
	}

	@Override
	public void updateProducto(Producto prod) {
		repository.save(prod);

	}

	@Override
	public Producto findByCodigo(int codigoProducto) {
		return repository.findById(codigoProducto).orElse(null);  
	}

	@Override
	public void saveProducto(Producto producto) {
		repository.save(producto);
		
	}

}
