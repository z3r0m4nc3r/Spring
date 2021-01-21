package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.ItemAlumno;
import model.ItemCurso;
@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	RestTemplate template;
	private String url="http://servicio-formacion/cursos";
	@Override
	public List<ItemCurso> cursos() {
		return Arrays.asList(template.getForObject(url, ItemCurso[].class));
	}

	@Override
	public List<ItemAlumno> alumnosCurso(int codigo) {
		ItemCurso[] cursos=template.getForObject(url, ItemCurso[].class);
		ItemCurso curso=Arrays.stream(cursos)
			.filter(c->c.getCodigoCurso()==codigo)
			.findFirst().orElse(null);
		return curso!=null||curso.getAlumnos().length!=0?Arrays.asList(curso.getAlumnos()):null;
	}

}
