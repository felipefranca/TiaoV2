package controle;

import java.io.File;

import dao.ArquivoDAO;
import dao.GenericDAO;
import modelo.Arquivo;
import modelo.Regra;

public class ArquivoControle extends ControleBase<Arquivo, ArquivoDAO> {

	public ArquivoControle(GenericDAO<Arquivo> obj) {
		super(new ArquivoDAO(Arquivo.class));
	}
	
	public Boolean moverArquivo(Regra regra){
		File arquivoOrigemTemp = new File(regra.getDiretorioOrigem());
		File arquivoDestinoTemp = new File(regra.getDiretorioDestino());
		if(arquivoOrigemTemp.isFile()){
			if(verificarArquivoEmUso(arquivoOrigemTemp)){
				Arquivo arquivo = criarArquivo(arquivoOrigemTemp);
				criar(arquivo);
				criarDiretorio(arquivoDestinoTemp);
				arquivoOrigemTemp.renameTo(arquivoDestinoTemp);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private Arquivo criarArquivo(File file) {
		Arquivo arquivo = new Arquivo();
		arquivo.setTamanho(file.getUsableSpace());
		arquivo.setDescricao(file.getName());
		arquivo.setDiretorioOrigem(file.getAbsolutePath());
		return arquivo;
	}
	
	public Boolean verificarArquivoEmUso(File arquivo) {
		if(arquivo.canWrite()){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean criarDiretorio(File arquivo){
		if(!arquivo.exists() && arquivo.isDirectory()){
			arquivo.mkdir();
			return true;
		} else {
			return false;
		}
	}
	
}
