package ar.edu.unju.edm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Autor;

@Repository
public interface IAutorRepository extends CrudRepository<Autor,Long>{
	public Optional<Autor> findByApellido(String apellido);	
}
