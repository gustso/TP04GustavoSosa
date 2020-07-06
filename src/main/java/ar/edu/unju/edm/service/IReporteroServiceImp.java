package ar.edu.unju.edm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Reportero;
import ar.edu.unju.edm.repository.IReporteroRepository;

@Service
public class IReporteroServiceImp implements IReporteroService{

	@Autowired
	IReporteroRepository reporteroRepository;
	
	@Override
	public Iterable<Reportero> buscarTodosReporteror() {
		// TODO Auto-generated method stub
		return reporteroRepository.findAll();
	}

	@Override
	public void agregarReportero(Reportero unReportero) {
		// TODO Auto-generated method stub
		reporteroRepository.save(unReportero);
	}

}
