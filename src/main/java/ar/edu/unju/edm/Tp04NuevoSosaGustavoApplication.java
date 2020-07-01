package ar.edu.unju.edm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.EquipoFutbol;

@SpringBootApplication
public class Tp04NuevoSosaGustavoApplication {
	
	private static EquipoFutbol equipo;

	public static void main(String[] args) {
		SpringApplication.run(Tp04NuevoSosaGustavoApplication.class, args);
		equipo = new EquipoFutbol("GyEJujuy");
		System.out.println("Nombre del equipo: " + equipo);
	}

}
