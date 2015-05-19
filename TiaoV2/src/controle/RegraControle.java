package controle;

import modelo.Arquivo;
import modelo.Regra;
import dao.ArquivoDAO;
import dao.GenericDAO;
import dao.RegraDAO;

public class RegraControle extends ControleBase<Regra, RegraDAO> {
	
	public Regra regra;
	private ArquivoControle arquivoControle = new ArquivoControle(new ArquivoDAO(Arquivo.class));
	
	public RegraControle(GenericDAO<Regra> obj) {
		super(new RegraDAO(Regra.class));
	}

	public Boolean executarRegraPadrao(){
		
		return true;
	}
	
	public Boolean executarRegra(Regra regra){
		
		return false;
	}
	
	private boolean isRegraValida(Regra regra) {
		return regra != null && regra.getArquivo() != null && regra.getDiretorioDestino() != null;
	}

	public ArquivoControle getArquivoControle() {
		return arquivoControle;
	}
	
}