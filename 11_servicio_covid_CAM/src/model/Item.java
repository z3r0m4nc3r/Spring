package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {

	private String municipio_distrito;
	private double tasa_incidencia_acumulada_ultimos_14_dias;
	private int casos_confirmados_totales;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private Date fecha_informe;
	
	public Item() {
		super();
	}
	public Item(String municipio_distrito, double tasa_incidencia_acumulada_ultimos_14_dias,
			int casos_confirmados_totales, Date fecha) {
		super();
		this.municipio_distrito = municipio_distrito;
		this.tasa_incidencia_acumulada_ultimos_14_dias = tasa_incidencia_acumulada_ultimos_14_dias;
		this.casos_confirmados_totales = casos_confirmados_totales;
		this.fecha_informe = fecha;
	}
	public String getMunicipio_distrito() {
		return municipio_distrito;
	}
	public void setMunicipio_distrito(String municipio_distrito) {
		this.municipio_distrito = municipio_distrito;
	}
	public double getTasa_incidencia_acumulada_ultimos_14_dias() {
		return tasa_incidencia_acumulada_ultimos_14_dias;
	}
	public void setTasa_incidencia_acumulada_ultimos_14_dias(double tasa_incidencia_acumulada_ultimos_14_dias) {
		this.tasa_incidencia_acumulada_ultimos_14_dias = tasa_incidencia_acumulada_ultimos_14_dias;
	}
	public int getCasos_confirmados_totales() {
		return casos_confirmados_totales;
	}
	public void setCasos_confirmados_totales(int casos_confirmados_totales) {
		this.casos_confirmados_totales = casos_confirmados_totales;
	}
	public Date getFecha_informe() {
		return fecha_informe;
	}
	public void setFecha_informe(Date fecha) {
		this.fecha_informe = fecha;
	}
	
	
}
