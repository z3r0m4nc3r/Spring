package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Registro;

public interface ContagiosMongoRepository extends MongoRepository<Registro, String> {
	
	List<Registro> findByPais(String pais);
	List<Registro> findByFechaBetween(LocalDate fecha1 , LocalDate fecha2);
	

}
