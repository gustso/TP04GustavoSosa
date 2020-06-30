package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Reportero;

@Repository
public interface IReporteroRepository extends CrudRepository<Reportero, Integer>{

}
