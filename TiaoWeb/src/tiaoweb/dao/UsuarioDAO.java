package tiaoweb.dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import tiaoweb.model.Usuario;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long> implements Serializable {
	private static final long serialVersionUID = 2404360457246388280L;

}