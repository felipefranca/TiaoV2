package tiaoweb.view;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import tiaoweb.dao.UsuarioDAO;
import tiaoweb.model.Usuario;

@ManagedBean
public class UsuarioController {

	@Inject
	private UsuarioDAO dao;
	
	private Usuario usuario;
	
	@PostConstruct
	private void inicializar(){
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvar() {
		dao.persist(usuario);
	}
	
}