package com.fadsan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.fadsan.dao.VisitorsDetailsDao;
import com.fadsan.model.VisitorsDetails;

@Service
@SuppressWarnings("unchecked")
public class VisitorsDetailsDaoImpl extends DAOImpl<Integer, VisitorsDetails>
		implements VisitorsDetailsDao {
	@Override
	public List<VisitorsDetails> getVisitorsDetailsByDate(Date date) {
		return sessionFactory.getCurrentSession()
				.createCriteria(VisitorsDetails.class)
				.add(Restrictions.eq("visitDate", date))
				.add(Restrictions.eq("active", true)).list();
	}

	@Override
	public List<VisitorsDetails> getVisitorsDetailsByName(String visitorName) {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(VisitorsDetails.class)
				.add(Restrictions.like("visitorName", visitorName + "%"))
				.add(Restrictions.eq("active", true)).list();
	}

}
