package tiaoweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tiaoweb.model.EntidadeBase;
 
@SuppressWarnings("unchecked")
public class GenericDAO<T extends EntidadeBase, PK> {
	
    @PersistenceContext(unitName="tiaoWeb-pu")
    protected EntityManager entityManager;
 
    public void persist(T entity) {
    	if(entity.getId() != null){
    		entity.setDataAlteracao(new Date());
    	} else {
    		entity.setDataCadastro(new Date());
    	}
        entityManager.persist(entity);
    }
 
    public void merge(T entity) {
        entityManager.merge(entity);
    }
 
    public void remove(T entity) {
        entityManager.remove(entity);
    }
 
    public void removeById(PK id) {
        T entity = getById(id);
        entityManager.remove(entity);
    }
 
    public T getById(PK id) {
        return entityManager.find(getTypeClass(), id);
    }
 
    public Collection<T> findAll() {
        return entityManager.createQuery("FROM " + getTypeClass().getName())
                .getResultList();
    }
 
    public Query createQuery(String query, Object... parameters) {
        Query q = entityManager.createQuery(query);
 
        for (int i = 1; i <= parameters.length; i++) {
            q.setParameter(i, parameters[i]);
        }
         
        return q;
    }
 
    private Class<T> getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}