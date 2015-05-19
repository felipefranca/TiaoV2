package teste;

import static org.junit.Assert.*;
import modelo.Regra;

import org.junit.Test;

import controle.RegraControle;
import dao.RegraDAO;

public class RegraTeste {
	
	private RegraControle controle = new RegraControle(new RegraDAO(Regra.class));
	
	@Test
	public void teste(){
		String a = "felipe";
		String b = "felipe";
		assertTrue(a.equals(b));
	}
	
	@Test
	public void executarRegraPadrao(){
		assertTrue(controle.executarRegraPadrao());
	}
	
}
