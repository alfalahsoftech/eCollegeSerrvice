package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.SessionDao;
import com.fadsan.model.Session;

@Transactional
@Repository("sessionDao")
public class SessionDaoImpl extends DAOImpl<Integer, Session> implements
		SessionDao {

	@Override
	public Session findCurrentSession() {
		return (Session) sessionFactory.getCurrentSession()
				.createCriteria(Session.class)
				.add(Restrictions.eq("currentSession", true)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> findallsessions() {
		return (List<Session>) sessionFactory.getCurrentSession()
				.createCriteria(Session.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("currentSession", false)).list();
	}

	@Override
	public Session getSessionByName(String sessionName) {
		return (Session) sessionFactory.getCurrentSession()
				.createCriteria(Session.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("sessionDuration", sessionName).ignoreCase())
				.uniqueResult();
	}

}
