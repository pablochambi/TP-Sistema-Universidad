package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMateria {

	@Test
	public void queSePuedaCrearMateriasConIdIncremental() {
		
		String nombre = "Pb2";
		Integer codigo = 1212;
		Materia mat = new Materia(codigo, nombre);
		Materia mat2 = new Materia(255, "Bd1");
		Materia mat3 = new Materia(344, "Pw1");
		 
		assertEquals(nombre,mat.getNombre());
		
		assertEquals((Integer)1,mat.getId());
		assertEquals((Integer)2,mat2.getId());
		assertEquals((Integer)3,mat3.getId());
		
		
	}

}
