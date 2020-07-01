package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Autor;
import ar.edu.unju.edm.model.Noticia;

@Service
public interface INoticiaService {

	public void guardarNoticia(Noticia unaNoticia);
	public Noticia buscarNoticia(String titulo);
	public Iterable<Noticia> buscarTodasNoticias();
	public void borrarNoticia(Noticia unaNoticia);
	public Iterable<Noticia> buscarNoticiasDelAutor(Autor autor);
}
