package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		
		String nombre = "Pb2";
		Integer codigo = 1212;
		Materia materia = new Materia(codigo, nombre);
		 
		assertNotNull(materia);
		assertEquals(nombre,materia.getNombre());
		
	}

}
