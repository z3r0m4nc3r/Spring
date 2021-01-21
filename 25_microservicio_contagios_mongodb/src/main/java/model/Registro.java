package model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

@Document(collection="registros")
public class Registro {
	
@Id
private String Id;
private String pais;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Madrid")
private LocalDate fecha;
private int contagios;

public Registro() {
	super();
}
public Registro(String id, String pais, LocalDate fecha, int contagios) {
	super();
	Id = id;
	this.pais = pais;
	this.fecha = fecha;
	this.contagios = contagios;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	
	this.fecha = fecha;
}
public int getContagios() {
	return contagios;
}
public void setContagios(int contagios) {
	this.contagios = contagios;
}



}
