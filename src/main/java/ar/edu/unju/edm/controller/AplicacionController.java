package ar.edu.unju.edm.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Autor;
import ar.edu.unju.edm.model.Noticia;
import ar.edu.unju.edm.model.Reportero;
import ar.edu.unju.edm.repository.IReporteroRepository;
import ar.edu.unju.edm.service.IAutorService;
import ar.edu.unju.edm.service.INoticiaService;


@Controller
public class AplicacionController {
	
	@Autowired
	INoticiaService iNoticiaService;
	@Autowired
	IAutorService iAutorService;
	@Autowired
	Noticia unaNoticia;
	@Autowired
	Autor unAutor;
	@Autowired
	IReporteroRepository iRepository;
	@Autowired
	Noticia unaNoticiaIntermedio;

	@GetMapping("/home")
	public String iniciarAplicacion() {
		return "index";
	}
	
	@GetMapping("/servicio")
	public String mostrarServicio(Model model) {
		//LocalDate fecha = LocalDate.parse("2020-06-16");
		Noticia unaNoticia = new Noticia ();
		//unaNoticia.setFecha(fecha);
		unaNoticia.setResumen("Resumen02");
		unaNoticia.setTitulo("Titulo02");
		Reportero unReportero = new Reportero();
		unReportero.setApellido("Sosa");
		unReportero.setNoticia(unaNoticia);
		iRepository.save(unReportero);		
		//iNoticiaService.guardarNoticia(unaNoticia);	
		
		//model.addAttribute("noticiaDeLaVista", unaNoticia);
		model.addAttribute("todasLasNoticias", iNoticiaService.buscarTodasNoticias());
		//model.addAttribute("formTab", "active");
		return "servicio";
	}
	
	@GetMapping("/agregarNoticia")
	public String crearNoticia(Model model) {	
		model.addAttribute("noticiaDelForm",unaNoticia);				
		model.addAttribute("autores",iAutorService.buscarTodosAutores());
		model.addAttribute("autorDelForm", unAutor);
		return "noticiaForm";
	}
		
	@PostMapping("/agregarNoticia")
	public String crearNoticiaFinal(@ModelAttribute("noticiaDelForm") Noticia noticia, Model model) {
			noticia.setAutores(iAutorService.buscarTodosAutores());
			try {				
				iNoticiaService.guardarNoticia(noticia);		
			} catch (Exception e) {
				// TODO Auto-generated catch block			
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}	
		iAutorService.borrarTodosAutores();
		return "redirect:/agregarNoticia";
	}
	
	@PostMapping("/agregarAutor")
	public String crearAutor(@ModelAttribute("autorDelForm") Autor autor,  Model model) throws Exception {			
			try {			
				iAutorService.guardarAutor(autor);
			} catch (Exception f) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", f.getMessage());				
			}
					
	return "redirect:/agregarNoticia";
}
	
	@PostMapping("/buscarAutor")
	public String buscarAutor(@ModelAttribute("autorDelForm") Autor autor,  Model model) throws Exception {	
		try {
			Autor autorEncontrado = iAutorService.buscarAutor(autor.getApellido());
			try {			
				iAutorService.guardarAutorEncontrado(autorEncontrado);
			} catch (Exception e) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}
		}catch(Exception e) {			
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}			
	return crearNoticia(model);
}
	
	@PostMapping("/buscarNoticiasAutor")
	public String buscarNoticiasAutor(@ModelAttribute("autorDelForm") Autor autor,  Model model) throws Exception {	
		try {
			Autor autorEncontrado = iAutorService.buscarAutor(autor.getApellido());
			try {			
				model.addAttribute("noticias",iNoticiaService.buscarNoticiasDelAutor(autorEncontrado));
			} catch (Exception e) {
				// TODO Auto-generated catch block				 
				model.addAttribute("formAutorErrorMessage", e.getMessage());				
			}
		}catch(Exception e) {			
			model.addAttribute("formAutorErrorMessage", e.getMessage());
		}			
	return crearNoticia(model);
}
}