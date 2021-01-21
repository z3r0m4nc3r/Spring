package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Alumno;

@Repository("alumnosSpringDataJpa")
public class AlumnosRepositorySpringDataJpaImpl implements AlumnosRepository {
	@Autowired
	AlumnosJpaRepository repository;
	
	
	@Override
	public void guardarAlumno(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		return repository.findById(usuario).orElse(null);
		
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		
		return repository.findByIdCurso(idCurso);
	}

	@Override
	public List<Alumno> todosAlumnos() {
		return repository.findAll();
	}

	@Override
	public Alumno buscarAlumnoMatricular(String usuario) {
		// Consulta personalizada para que traiga todos los cursos del alumno
		return repository.findAlumno(usuario);
	}

}
