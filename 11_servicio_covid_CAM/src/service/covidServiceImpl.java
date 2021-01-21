package service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Conjunto;
import model.Item;

@Service
public class covidServiceImpl implements CovidService {

	@Autowired
	RestTemplate template;
	
	private String url="https://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/download/covid19_tia_muni_y_distritos_s.json";
	
	private Stream<Item> recuperarStream(){
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		return 
			Arrays.stream(conjunto.getData());
	}
	
	@Override
	public List<Item> casosMunicipio(String municipio) {
		return 
			recuperarStream()
			.filter(i -> i.getMunicipio_distrito().equals(municipio))
			.collect(Collectors.toList());
	}

	@Override
	public List<Item> casosoEntreFechas(Date fecha1, Date fecha2) {
		return 
			recuperarStream()
			.filter(i -> i.getFecha_informe().getTime()>=fecha1.getTime()&&i.getFecha_informe().getTime()<=fecha2.getTime())
			.collect(Collectors.toList());
	}

	@Override
	public int casosTotalesAcumulados() {
		
			Date fechaMaxima = recuperarStream().max((i1,i2) -> i1.getFecha_informe().getTime()>i2.getFecha_informe().getTime()?1:0)
					.get().getFecha_informe();  
			
			return
			recuperarStream().filter(i -> i.getFecha_informe().getTime()==fechaMaxima.getTime())
			.mapToInt(i -> i.getCasos_confirmados_totales())
			.sum();
	}

}
