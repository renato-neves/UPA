package daw.upa.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daw.upa.jpa.JPAUtil;
import daw.upa.modelo.Usuario;

public class UsuarioDAO {
	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery("FROM Usuario u WHERE u.login = :pLogin AND u.senha=:pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		em.close();
		return encontrado;
	}
}
