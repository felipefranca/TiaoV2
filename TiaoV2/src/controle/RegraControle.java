package controle;

import modelo.Arquivo;
import modelo.Regra;
import dao.ArquivoDAO;
import dao.GenericDAO;
import dao.RegraDAO;

public class RegraControle extends ControleBase<Regra, RegraDAO> {
	
	private ArquivoControle arquivoControle = new ArquivoControle(new ArquivoDAO(Arquivo.class));
	
	public RegraControle(GenericDAO<Regra> obj) {
		super(new RegraDAO(Regra.class));
	}

	public Regra regra;

	public Boolean verificarArquivoEmUso(Arquivo arquivo) {
		return null;
	}
	
	public void moverArquivo(Regra regra){
		if(isRegraValida(regra)){
			//TODO implementar corretamente a ideia do arquivo
			getArquivoControle().criarArquivo(regra.getDiretorioOrigem());
			
		}
	}

	private boolean isRegraValida(Regra regra) {
		return regra != null && regra.getArquivo() != null && regra.getDiretorioDestino() != null;
	}

	public ArquivoControle getArquivoControle() {
		return arquivoControle;
	}
	
}