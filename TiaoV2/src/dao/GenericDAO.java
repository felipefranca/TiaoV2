package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Level;

import Util.LogUtils;
import modelo.EntidadeBase;

public abstract class GenericDAO<T extends EntidadeBase> {

	private final static String UNIT_NAME = "tiao-pu";

	private EntityManagerFactory factory;
	private EntityManager entityManager;
	
	@SuppressWarnings("unused")
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
			LogUtils.log(Level.FATAL, e);
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
			LogUtils.log(Level.FATAL, e);
			getEmEntityManager().getTransaction().rollback();
		}
	}

	public T update(T entity) {
		try {
			getEmEntityManager().getTransaction().begin();
			return getEmEntityManager().merge(entity);
		} catch (Exception e) {
			LogUtils.log(Level.FATAL, e);
			getEmEntityManager().getTransaction().rollback();
			return null;
		}
	}

	public T saveOrUpdate(T entity) {
		try {
			getEmEntityManager().getTransaction().begin();
			return getEmEntityManager().merge(entity);
		} catch (Exception e) {
			LogUtils.log(Level.FATAL, e);
			getEmEntityManager().getTransaction().rollback();
			return null;
		}
	}
	
	
}