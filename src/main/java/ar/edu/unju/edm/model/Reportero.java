package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Reportero {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Integer idReportero;
	
	@Column
	private String apellido;
	
	@Autowired
	@Column
	private Noticia noticia;
	
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

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
}
