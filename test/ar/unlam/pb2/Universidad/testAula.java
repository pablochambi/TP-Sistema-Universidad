package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testAula {

	@Test
	public void crearAulasConIdIncremental() {

		Integer numAula = 100;
		Integer cantMax = 5;
		
		Aula aula = new Aula(numAula,cantMax);
		Aula aula2 = new Aula(122,cantMax);
		Aula aula3 = new Aula(144,cantMax);
		
		assertEquals(cantMax,aula.getCantMax());
		assertEquals((Integer)1,aula.getId());
		assertEquals((Integer)2,aula2.getId());
		assertEquals((Integer)3,aula3.getId());
		
	}
	
	
	
	
	
	
	
	
	

}
