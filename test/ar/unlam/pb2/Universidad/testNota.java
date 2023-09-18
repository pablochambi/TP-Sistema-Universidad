package ar.unlam.pb2.Universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class testNota {

	@Test
	public void queSePuedaCargarUnaNotaDePrimerParcialQueEsteEntre1y10() {
		
		TipoParcial tipoParcial = TipoParcial.PRIMER_PARCIAL;
		Integer valor = 7;
		
		
		Nota nota = new Nota(tipoParcial,valor);
		
		assertEquals(valor,nota.getValor());
		assertEquals(TipoParcial.PRIMER_PARCIAL, nota.getTipoParcial());
	}
	
	@Test
	public void queNoSePuedaCargarUnaNotaDePrimerParcialQueSeaMayorA10() {
		
		TipoParcial tipoParcial = TipoParcial.PRIMER_PARCIAL;
		Integer valor = 11;
		Nota nota = new Nota(tipoParcial,valor);
		
		Integer ve = 0;
		Integer vo = nota.getValor();
		assertEquals(ve,vo);
		assertEquals(TipoParcial.PRIMER_PARCIAL, nota.getTipoParcial());
	}
	
	@Test
	public void queSePuedaAprobarUnSegundoParcial() {
		
		TipoParcial tipoParcial = TipoParcial.SEGUNDO_PARCIAL;
		Integer valor = 7;
		Nota nota = new Nota(tipoParcial,valor);
		
		Boolean resultado = nota.getAprobado();
		assertTrue(resultado);
		
	}
	
	@Test
	public void queSePuedaDesaprobarUnSegundoParcial() {
		
		TipoParcial tipoParcial = TipoParcial.SEGUNDO_PARCIAL;
		Integer valor = 6;
		Nota nota = new Nota(tipoParcial,valor);
		
		Boolean resultado = nota.getAprobado();
		assertFalse(resultado);
		
	}
	
	
	
	

}
