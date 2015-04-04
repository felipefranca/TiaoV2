package controle;

import java.util.Date;

import dao.GenericDAO;
import modelo.EntidadeBase;

public abstract class ControleBase<T extends EntidadeBase, DAOGenerico extends GenericDAO<T>> {
	
	private GenericDAO<T> dao;
	
	public ControleBase(GenericDAO<T> obj){
		dao = obj;
	}
	
	public void criar(T t) {
		if(t.getDataCadastro() == null){
			t.setDataCadastro(new Date());
		}
		dao.save(t);
	}

	public void alterar(T t) {
		if(t.getDataAlteracao() == null){
			t.setDataAlteracao(new Date());
		}
		dao.saveOrUpdate(t);
	}

	public void excluir(T t) {
		dao.deleteById(t.getId());
	}

	public T pesquisarPorId(Long id) {
		return dao.pesquisarPorId(id);
	}

	public void pesquisarPorParametros() {
	}

}