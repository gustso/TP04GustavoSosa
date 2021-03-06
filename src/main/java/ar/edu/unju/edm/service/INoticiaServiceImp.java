package ar.edu.unju.edm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Autor;
import ar.edu.unju.edm.model.Noticia;
import ar.edu.unju.edm.repository.INoticiaRepository;

@Service
public class INoticiaServiceImp implements INoticiaService{

	@Autowired
	INoticiaRepository iNoticiaRepository;
	
	@Override
	public void guardarNoticia(Noticia unaNoticia) {
		// TODO Auto-generated method stub
		unaNoticia.setFecha(LocalDate.now());		
		iNoticiaRepository.save(unaNoticia);		
	}

	@Override
	public Noticia buscarNoticia(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Noticia> buscarTodasNoticias() {
		// TODO Auto-generated method stub		
		return iNoticiaRepository.findAll();
		
	}

	@Override
	public void borrarNoticia(Noticia unaNoticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Noticia> buscarNoticiasDelAutor(Autor autor) {
		// TODO Auto-generated method stub
		List<Noticia> noticiasDelAutor = new ArrayList<>();
		for (Noticia noticia : iNoticiaRepository.findAll()) {
			for (Autor unAutor: noticia.getAutores()) {
				if(unAutor.getId() == autor.getId()) {
					noticiasDelAutor.add(noticia);
			}				
			}
		}		
		return noticiasDelAutor; 
	}

}
