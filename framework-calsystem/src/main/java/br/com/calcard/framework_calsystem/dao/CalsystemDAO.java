package br.com.calcard.framework_calsystem.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.calcard.framework_calsystem.entity.CalsystemEntity;
import br.com.calcard.framework_calsystem.exception.DAOException;

public abstract class CalsystemDAO<T> {

	@PersistenceContext(unitName = "entityManager")
	private EntityManager em;

	public abstract Class<T> doGetClass();

	public T doRegistrar(T entity) throws DAOException {
		try {

			if (entity == null)
				throw new IllegalArgumentException("Entidade enviada � NULA");

			Date data = new Date();

			((CalsystemEntity) entity).setDataAtualizacao(data);
			((CalsystemEntity) entity).setDataRegistro(data);

			this.em.persist(entity);

			return entity;

		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel inserir a Entidade no banco de dados", e);
		}
	}

	public T doAtualizar(T entity) throws DAOException {
		try {

			if (entity == null)
				throw new IllegalArgumentException("Parametro enviado NULO");

			((CalsystemEntity) entity).setDataAtualizacao(new Date());

			return this.em.merge(entity);

		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel atualizar a Entidade no banco de dados",
					e);
		}
	}

	public Criteria getCriteria() {

		return ((Session) em.getDelegate()).createCriteria(doGetClass());

	}

	public void doRemover(T entity) throws DAOException {
		try {

			this.em.remove(this.em.merge(entity));

		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel deletar a Entidade no banco de dados", e);
		}
	}

	public T doProcurar(Integer primaryKey) throws DAOException {
		try {

			if (primaryKey == null)
				throw new IllegalArgumentException(
						"O ID da entidade n�o foi informado!");

			return this.em.find(doGetClass(), primaryKey);
		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel consultar a Entidade no banco de dados",
					e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> doListar() throws DAOException {
		try {
			CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(doGetClass()));
			return this.em.createQuery(cq).getResultList();
		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel consultar a Entidade no banco de dados",
					e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List<T> doGetResultList(String namedQuery, Map parametros)
			throws DAOException {
		try {

			Query q = this.em.createNamedQuery(namedQuery, doGetClass());

			if (parametros != null) {
				Iterator it = parametros.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry parametro = (Map.Entry) it.next();
					q.setParameter((String) parametro.getKey(),
							parametro.getValue());
				}
			}

			return q.getResultList();

		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel consultar a Entidade no banco de dados",
					e);
		}

	}

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// protected Object doGetResultList(String namedQuery, Class classe,
	// Map parametros) {
	// // logger.info("M�todo: doGetResultList");
	//
	// Query q = this.entityManager.createNamedQuery(namedQuery, classe);
	//
	// if (parametros != null) {
	// Iterator it = parametros.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry parametro = (Map.Entry) it.next();
	// q.setParameter((String) parametro.getKey(),
	// parametro.getValue());
	// }
	// }
	//
	// try {
	// return q.getResultList();
	// } catch (NoResultException e) {
	// return null;
	// }
	// }

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// protected Object doGetResultList(StringBuilder query, Class classe,
	// Map parametros) {
	// // logger.info("M�todo: doGetResultList");
	//
	// Query q = this.entityManager.createQuery(query.toString(), classe);
	//
	// if (parametros != null) {
	// Iterator it = parametros.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry parametro = (Map.Entry) it.next();
	// q.setParameter((String) parametro.getKey(),
	// parametro.getValue());
	// }
	// }
	//
	// try {
	// return q.getResultList();
	// } catch (NoResultException e) {
	// return null;
	// }
	// }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected T doGetSingleResult(String namedQuery,
			Map<String, Object> parametros) throws DAOException {
		try {

			Query q = this.em.createNamedQuery(namedQuery, doGetClass());

			if (parametros != null) {
				Iterator it = parametros.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry parametro = (Map.Entry) it.next();
					q.setParameter((String) parametro.getKey(),
							parametro.getValue());
				}
			}

			return (T) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(
					"N�o foi poss�vel consultar a Entidade no banco de dados",
					e);
		}

	}

	public EntityManager getEm() {
		return em;
	}

	// @SuppressWarnings("rawtypes")
	// protected Object doGetResultList(StringBuilder query, Map parametros) {
	// // logger.info("M�todo: doGetResultList");
	//
	// Query q = this.entityManager.createQuery(query.toString());
	//
	// Iterator it = parametros.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry parametro = (Map.Entry) it.next();
	// q.setParameter((String) parametro.getKey(), parametro.getValue());
	// }
	//
	// try {
	// return q.getResultList();
	// } catch (NoResultException e) {
	// return null;
	// }
	// }

	// protected Object doGetResultList(StringBuilder query) {
	// // logger.info("M�todo: doGetResultList");
	//
	// Query q = this.entityManager.createQuery(query.toString());
	//
	// try {
	// return q.getResultList();
	// } catch (NoResultException e) {
	// return null;
	// }
	// }

	// @SuppressWarnings("rawtypes")
	// protected Object doGetSingleResult(StringBuilder query, Map parametros) {
	//
	// Query q = this.entityManager.createQuery(query.toString());
	//
	// Iterator it = parametros.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry parametro = (Map.Entry) it.next();
	// q.setParameter((String) parametro.getKey(), parametro.getValue());
	// }
	//
	// try {
	// return q.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }
	//
	// }

	// protected Object doGetSingleResult(StringBuilder query) {
	//
	// Query q = this.entityManager.createQuery(query.toString());
	//
	// try {
	// return q.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }
	//
	// }

	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// protected Object doGetSingleResult(StringBuilder query, Class classe,
	// Map<String, Object> parametros) {
	//
	// Query q = this.entityManager.createQuery(query.toString(), classe);
	//
	// Iterator it = parametros.entrySet().iterator();
	// while (it.hasNext()) {
	// Map.Entry parametro = (Map.Entry) it.next();
	// q.setParameter((String) parametro.getKey(), parametro.getValue());
	// }
	//
	// try {
	// return q.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }
	//
	// }

	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// protected Object doGetSingleResult(StringBuilder query, Class classe) {
	//
	// Query q = this.entityManager.createQuery(query.toString(), classe);
	//
	// try {
	// return q.getSingleResult();
	// } catch (NoResultException e) {
	// return null;
	// }
	//
	// }

	// public EntityManager getEntityManager() {
	// return entityManager;
	// }
	//
	// public void setEntityManager(EntityManager entityManager) {
	// this.entityManager = entityManager;
	// }
}
