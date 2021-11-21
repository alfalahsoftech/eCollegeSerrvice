package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.EmployeeRoleDao;
import com.fadsan.model.EmployeeRole;

@Transactional
@Repository("EmployeeRoleDao")
@SuppressWarnings("unchecked")
public class EmployeeRoleDaoImpl extends DAOImpl<Integer, EmployeeRole>
		implements EmployeeRoleDao {

	@Override
	public List<EmployeeRole> getAllActiveEmployeeRole() {
		return sessionFactory.getCurrentSession()
				.createCriteria(EmployeeRole.class)
				.add(Restrictions.eq("active", true)).list();
	}

	@Override
	public EmployeeRole getgetRoleDTOByRole(String roleName) {
		return (EmployeeRole) sessionFactory.getCurrentSession()
				.createCriteria(EmployeeRole.class)
				.add(Restrictions.eq("roleName", roleName).ignoreCase())
				.add(Restrictions.eq("active", true)).uniqueResult();
	}

}
