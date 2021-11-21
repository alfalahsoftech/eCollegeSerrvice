package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.LoginRoleDao;
import com.fadsan.model.LoginRole;

@Transactional
@Repository("roleDao")
public class LoginRoleDaoImpl extends DAOImpl<Integer, LoginRole> implements
		LoginRoleDao {

	@Override
	public LoginRole getUserRoleByName(String name) {
		return (LoginRole) (sessionFactory.getCurrentSession().createCriteria(
				LoginRole.class).add(Restrictions.eq("name", name)))
				.uniqueResult();
	}

}
