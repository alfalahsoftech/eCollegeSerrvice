package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.LastDateDao;
import com.fadsan.model.LastDate;

@Transactional
@Repository("lastDateDao")
public class LastDateDaoImpl extends DAOImpl<Integer, LastDate> implements
		LastDateDao {

	@Override
	public LastDate getLastDatebyMonth(int monthId, int sessionId) {
		return (LastDate) sessionFactory.getCurrentSession()
				.createCriteria(LastDate.class)
				.add(Restrictions.eq("month.monthId", monthId))
				.add(Restrictions.eq("session.sessionId", sessionId))
				.uniqueResult();
	}

	@Override
	public LastDate getLastDatebyMonth(int monthId) {
		return (LastDate) sessionFactory.getCurrentSession()
				.createCriteria(LastDate.class)
				.add(Restrictions.eq("month.monthId", monthId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LastDate> getLastDatesBySessionId(Integer sessionId) {
		return (List<LastDate>) sessionFactory.getCurrentSession()
				.createCriteria(LastDate.class)
				.add(Restrictions.eq("session.sessionId", sessionId)).list();
	}

}
