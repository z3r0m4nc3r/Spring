package service;

import java.time.LocalDate;
import java.util.List;

import model.Registro;

public interface ContagiosService {

	void nuevoRegistro (Registro registro);
	List<Registro> RegistrosPorPais(String pais);
	List<Registro> RegistrosEntreFechas(LocalDate fecha1 , LocalDate fecha2);
}
