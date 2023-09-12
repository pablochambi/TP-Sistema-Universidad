package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testAula {

	@Test
	public void crearAula() {

		Integer id = 1;
		Integer cantMax = 5;
		
		Aula aula = new Aula(id,cantMax);
		
		assertEquals(cantMax,aula.getCantMax());
	}
	
	
	
	
	
	
	
	
	

}
