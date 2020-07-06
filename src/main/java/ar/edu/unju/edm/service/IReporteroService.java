package ar.edu.unju.edm.service;

import ar.edu.unju.edm.model.Reportero;

public interface IReporteroService {
	public Iterable<Reportero> buscarTodosReporteror(); 
	public void agregarReportero(Reportero unReportero);
}
