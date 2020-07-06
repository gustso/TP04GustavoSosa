package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.EquipoFutbol;
import ar.edu.unju.edm.model.Reportero;
import ar.edu.unju.edm.repository.IReporteroRepository;

@SpringBootApplication
public class Tp04NuevoSosaGustavoApplication implements CommandLineRunner{
	
	private static EquipoFutbol equipo;

	@Autowired
	IReporteroRepository reporteroRepository;
	
	Reportero reporteroNuevo;
	
	public static void main(String[] args) {
		SpringApplication.run(Tp04NuevoSosaGustavoApplication.class, args);
		equipo = new EquipoFutbol("GyEJujuy");
		System.out.println("Nombre del equipo: " + equipo);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		reporteroNuevo = new Reportero();
//		reporteroNuevo.setApellido("Apellido1");
//		reporteroRepository.save(reporteroNuevo);
//		reporteroNuevo = new Reportero();
//		reporteroNuevo.setApellido("Apellido2");
//		reporteroRepository.save(reporteroNuevo);
//		reporteroNuevo = new Reportero();
//		reporteroNuevo.setApellido("Apellido3");
//		reporteroRepository.save(reporteroNuevo);
	}

}
