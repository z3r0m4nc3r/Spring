package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Producto;
import repository.ProductosRepository;
@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductosRepository repository;
	
	@Override
	public List<Producto> allProductos() {
		return repository.findAll();
	}

	@Override
	public void updateStock(int codigoProducto, int unidades) {
		Producto prod=repository.findByCodigo(codigoProducto);
		if(prod!=null&&prod.getStock()>=unidades) {
			prod.setStock(prod.getStock()-unidades);
			repository.updateProducto(prod);
		}

	}

	@Override
	public void guardarProducto(Producto producto) {
		if(producto!=null) {
			repository.saveProducto(producto);
		}
		
	}

}
