package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.fadsan.dao.FineDao;
import com.fadsan.model.Fine;

@Service
public class FineDaoImpl extends DAOImpl<Integer, Fine> implements FineDao {

	@Override
	public Fine getFineByName(String Name, int sessionId) {
		return (Fine) sessionFactory.getCurrentSession()
				.createCriteria(Fine.class)
				.add(Restrictions.eq("session.sessionId", sessionId))
				.add(Restrictions.eq("fineName", Name)).uniqueResult();
	}

}
