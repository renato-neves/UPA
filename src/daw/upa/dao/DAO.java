package daw.upa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import daw.upa.jpa.JPAUtil;

public class DAO<T> {
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}
	
	public void adicionar(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void remover(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void alterar(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<T> getLista() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> list  = entityManager.createQuery(query).getResultList();
		entityManager.close();
		
		return list;
	}
	
	public T idPesquisa(Long id) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		return (T) entityManager.find(classe, id);
	}
}
