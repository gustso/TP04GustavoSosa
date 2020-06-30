package ar.edu.unju.edm.repository;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Noticia;

@Repository
public interface INoticiaRepository extends CrudRepository<Noticia,Integer>{
	public Noticia findByFecha(LocalDateTime fecha);	
	public Iterable<Noticia> findByTitulo(String titulo);

}
