package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPersona {

	@Test
	public void queSePuedaCrearUnaPersona() {

		String nombre = "Diego";
		String apellido = "Maradona";
		Integer dni = 22;
		Persona p = new Persona(dni,nombre,apellido);
		assertEquals(nombre,p.getNombre());
		
	}
	@Test
	public void queSePuedaCrearUnProfe() {
		
		String nombre = "Diego";
		String apellido = "Maradona";
		Integer dni = 22;
		Persona p = new Profesor(dni,nombre,apellido);
		assertEquals(nombre,p.getNombre());
		
	}
	@Test
	public void queSePuedaCrearUnAlumno() {
		
		String nombre = "Diego";
		String apellido = "Maradona";
		Integer dni = 22;
		Persona p = new Alumno(dni,nombre,apellido);
		assertEquals(nombre,p.getNombre());
		
	}

}
