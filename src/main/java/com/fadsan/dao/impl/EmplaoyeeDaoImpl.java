package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.EmployeeDao;
import com.fadsan.model.Employees;

@Transactional
@Repository("employeeDao")
@SuppressWarnings("unchecked")
public class EmplaoyeeDaoImpl extends DAOImpl<Integer, Employees> implements
		EmployeeDao {

	@Override
	@Transactional
	public Employees finddetailsbyUserId(Integer id) {
		return (Employees) (sessionFactory.getCurrentSession().createCriteria(
				Employees.class).add(Restrictions.eq("user.id", id)))
				.uniqueResult();
	}

	@Override
	@Transactional
	public List<Employees> getEmployee(String firstName) {
		return (List<Employees>) (sessionFactory.getCurrentSession()
				.createCriteria(Employees.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.like(
				"firstName", firstName + "%"))).list();
	}

	@Override
	public List<Employees> getEmployee(Boolean Active) {
		return (List<Employees>) (sessionFactory.getCurrentSession()
				.createCriteria(Employees.class).add(Restrictions.eq("active",
				true))).list();
	}

}
