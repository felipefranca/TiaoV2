package controle;

import java.io.File;

import dao.ArquivoDAO;
import dao.GenericDAO;
import modelo.Arquivo;

public class ArquivoControle extends ControleBase<Arquivo, ArquivoDAO> {

	public ArquivoControle(GenericDAO<Arquivo> obj) {
		super(new ArquivoDAO(Arquivo.class));
	}
	
	public Boolean criarArquivo(String caminhoOrigem){
		if(caminhoOrigem != null){
			File arquivoTemp = new File(caminhoOrigem);
			if(arquivoTemp != null && arquivoTemp.isFile()){
				Arquivo arquivo = new Arquivo();
				arquivo.setTamanho(arquivoTemp.getUsableSpace());
				arquivo.setDescricao(arquivoTemp.getName());
				arquivo.setDiretorioOrigem(arquivoTemp.getAbsolutePath());
				criar(arquivo);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}		
	}
	
}
