package controle;

import java.util.Date;

import modelo.Extensao;
import dao.ExtensaoDAO;

public class ExtensaoControle extends ControleBase<Extensao, ExtensaoDAO> {

	public ExtensaoControle(ExtensaoDAO d) {
		super(new ExtensaoDAO(Extensao.class));
	}

	public Extensao extensao;

	public void ExensaoControle() {
	}
	
	public Boolean criarExtensao(Extensao extensao) {
		return null;
	}
	
	public static void main(String[] args) {
		ExtensaoControle controle = new ExtensaoControle(null);
		Extensao extensao = new Extensao();
		extensao.setExtensao(".pdf");
		extensao.setDataCadastro(new Date());
		controle.criar(extensao);
		controle.pesquisarPorId(Long.valueOf("1")).getExtensao();
	}
}