package com.fadsan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.GatePassDao;
import com.fadsan.model.GatePass;

@Transactional
@Repository("gatePassDao")
public class GatePassDaoImpl extends DAOImpl<Integer, GatePass> implements
		GatePassDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<GatePass> findPreviousDetailsById(String id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(GatePass.class)
				.add(Restrictions.eq("students.studentAdmissionNo", id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GatePass> findDateWiseDetails(Date leavingDate) {
		return sessionFactory.getCurrentSession()
				.createCriteria(GatePass.class)
				.add(Restrictions.eq("leavingDate", leavingDate)).list();
	}

}
