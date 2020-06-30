package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Autor;
import ar.edu.unju.edm.repository.IAutorRepository;

@Service
public class IAutorServiceImp implements IAutorService{
	@Autowired
	IAutorRepository iAutorRepository;
	private List<Autor> listadoAuxiliar = new ArrayList<>();
	
	@Override
	public void guardarAutorEncontrado(Autor unAutor) {
		// TODO Auto-generated method stub
		//iAutorRepository.save(unAutor);		
		listadoAuxiliar.add(unAutor);		
	}
	
	@Override
	public void guardarAutor(Autor unAutor) {
		// TODO Auto-generated method stub
		iAutorRepository.save(unAutor);		
		listadoAuxiliar.add(unAutor);		
	}

	@Override
	public Autor buscarAutor(String apellido) throws Exception {
		// TODO Auto-generated method stub		
		return iAutorRepository.findByApellido(apellido).orElseThrow(()-> new Exception("El Autor no Existe"));
	}

	@Override
	public List<Autor> buscarTodosAutores() {
		// TODO Auto-generated method stub		
		//return iAutorRepository.findAll();		
		return listadoAuxiliar;
	}

	@Override
	public void borrarTodosAutores() {
		// TODO Auto-generated method stub
		listadoAuxiliar = new ArrayList<>();
	}

}
