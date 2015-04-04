package dao;

import modelo.Arquivo;

public class ArquivoDAO extends GenericDAO<Arquivo> {

	public ArquivoDAO(Class<Arquivo> entityClass) {
		super(Arquivo.class);
	}

}
