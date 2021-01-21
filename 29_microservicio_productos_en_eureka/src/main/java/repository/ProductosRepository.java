package repository;

import java.util.List;

import model.Producto;

public interface ProductosRepository {
	List<Producto> findAll();
	void updateProducto(Producto prod);
	Producto findByCodigo(int codigoProducto);
	void saveProducto(Producto producto);
}
