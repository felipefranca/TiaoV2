package tiaoweb.facade;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tiaoweb.dao.UsuarioDAO;

@Stateless
public class UsuarioFacade implements Serializable {

	private static final long serialVersionUID = 1270681488032943659L;
	
	@Inject
	private UsuarioDAO dao;
	
	
	
}
