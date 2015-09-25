package cn.membership.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.membership.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> classt;
	
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public void saveEntry(T t) {
		this.getSession().save(t);		
	}

	
	public void deleteEntry(Integer id) {
		T t = this.getEntry(id);
		this.getSession().delete(t);
	}

	
	public void updateEntry(T t) {
		this.getSession().update(t);		
	}

	
	public Collection<T> getAllEntry() {
		String hql = "from " + this.classt.getName() + " a order by a.id";
		return this.getSession().createQuery(hql).list();
	}

	
	public T getEntry(Integer id) {
		return (T) this.getSession().get(this.classt, id);
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Class<T> getClasst() {
		return classt;
	}
	public void setClasst(Class<T> classt) {
		this.classt = classt;
	}

}
