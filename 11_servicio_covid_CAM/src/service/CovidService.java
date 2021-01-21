package service;

import java.util.Date;
import java.util.List;

import model.Item;

public interface CovidService {
	
	List<Item> casosMunicipio(String municipio);
	List<Item> casosoEntreFechas(Date fecha1, Date fecha2);
	int casosTotalesAcumulados();

}
