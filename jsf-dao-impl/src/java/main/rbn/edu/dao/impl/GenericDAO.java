package rbn.edu.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
	Session session = null;
	try {
	    session = sessionFactory.getCurrentSession();
	} catch (HibernateException e) {
	    session = sessionFactory.openSession();
	}
	return session;
    }

    public void add(T obj) {
	getSession().save(obj);
    }

    public void update(T obj) {
	getSession().merge(obj);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
	Criteria criteria = getSession().createCriteria(getPersistenceClass());
	criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public T getById(long id) {
	Criteria criteria = getSession().createCriteria(getPersistenceClass());
	criteria.add(Restrictions.eq("id", id));
	criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	return (T) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void remove(long id) {
	Criteria criteria = getSession().createCriteria(getPersistenceClass());
	criteria.add(Restrictions.eq("id", id));
	criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	T prod = (T) criteria.uniqueResult();
	getSession().delete(prod);
    }

    protected abstract Class<T> getPersistenceClass();
}
