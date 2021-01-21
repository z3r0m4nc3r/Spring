package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Registro;
import repository.ContagiosMongoRepository;
@Service
public class ContagiosServiceImpl implements ContagiosService {

	@Autowired
	ContagiosMongoRepository repository;
	
	@Override
	public void nuevoRegistro(Registro registro) {
		repository.save(registro);

	}

	@Override
	public List<Registro> RegistrosPorPais(String pais) {
		return repository.findByPais(pais);
	}

	@Override
	public List<Registro> RegistrosEntreFechas(LocalDate fecha1, LocalDate fecha2) {
		return repository.findByFechaBetween(fecha1, fecha2);
	}

}
