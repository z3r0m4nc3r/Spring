package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	private int codigoProducto;
	private String producto;
	private double precioUnitario;
	private int stock;
	public Producto(int codigoProducto, String producto, double precioUnitario, int stock) {
		super();
		this.codigoProducto = codigoProducto;
		this.producto = producto;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}
	public Producto() {
		super();
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
