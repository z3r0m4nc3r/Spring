package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	List<Producto> allProductos();
	void updateStock(int codigoProducto, int unidades);
	void guardarProducto(Producto producto);
}
