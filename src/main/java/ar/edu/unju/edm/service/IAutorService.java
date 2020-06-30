package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Autor;

@Service
public interface IAutorService {
	public void guardarAutorEncontrado(Autor unAutor);
	public void guardarAutor(Autor unAutor);
	public Autor buscarAutor(String apellido) throws Exception;
	public List<Autor> buscarTodosAutores();
	public void borrarTodosAutores();	

}
