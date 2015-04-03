package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.EntidadeBase;
import modelo.Extensao;

//TODO Implementar logs

public abstract class GenericDAO<T extends EntidadeBase> {

	private final static String UNIT_NAME = "tiao-pu";

	private EntityManagerFactory factory;
	private EntityManager entityManager;
	
	private Class<T> entityClass; 

	public EntityManager getEmEntityManager() {
		if (entityManager == null) {
			factory = Persistence.createEntityManagerFactory(UNIT_NAME);
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T entity) {
		try {
			getEmEntityManager().getTransaction().begin();
			getEmEntityManager().persist(entity);
			getEmEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEmEntityManager().getTransaction().rollback();
		}
	}

	protected void delete(Object id, Class<T> classe) {
		try {
			getEmEntityManager().getTransaction().begin();
			T entityToBeRemoved = getEmEntityManager().getReference(classe, id);
			getEmEntityManager().remove(entityToBeRemoved);
			getEmEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEmEntityManager().getTransaction().rollback();
		}
	}

	public T update(T entity) {
		try {
			getEmEntityManager().getTransaction().begin();
			return getEmEntityManager().merge(entity);
		} catch (Exception e) {
			getEmEntityManager().getTransaction().rollback();
			System.out.println(e);
			return null;
		}
	}

	public T saveOrUpdate(T entity) {
		try {
			getEmEntityManager().getTransaction().begin();
			entity = (T) getEmEntityManager().merge(entity);
			getEmEntityManager().getTransaction().commit();
			return entity;
		} catch (Exception e) {
			getEmEntityManager().getTransaction().rollback();
			return null;
		}
	}
	
	public T pesquisarPorId(Long id){
		try {
			HashMap<String, Object> parametros = new HashMap<>();
			parametros.put("id", id);
			return (T) getEmEntityManager().find(entityClass,id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<T> pesquisarPorParametros(HashMap<String, Object> parametros){
		try {
			return (List<T>) getEmEntityManager().find(entityClass, parametros);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		ExtensaoDAO dao = new ExtensaoDAO(Extensao.class);
		Extensao extensao = new Extensao();
		extensao.setExtensao(".pdf");
		extensao.setDataCadastro(new Date());
		dao.saveOrUpdate(extensao);
		dao.pesquisarPorId(Long.valueOf("1")).getExtensao();
	}
}