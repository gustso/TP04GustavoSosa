package ar.edu.unju.edm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Reportero {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Integer idReportero;
	
	@Column
	private String apellido;
		
	@OneToMany(mappedBy = "reportero")
	private List<Noticia> noticias;
	
	public Reportero() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdReportero() {
		return idReportero;
	}

	public void setIdReportero(Integer idReportero) {
		this.idReportero = idReportero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

		
}
