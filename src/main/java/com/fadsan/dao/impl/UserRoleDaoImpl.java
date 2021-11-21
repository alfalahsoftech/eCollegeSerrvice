package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.UserRoleDao;
import com.fadsan.model.UserRole;
import com.fadsan.model.UserRoleId;

@Transactional
@Repository("userRoleDao")
public class UserRoleDaoImpl extends DAOImpl<UserRoleId, UserRole> implements
		UserRoleDao {

	@Transactional
	public UserRole getByUserIdAndRoleId(int userId, int roleId) {
		return (UserRole) (sessionFactory.getCurrentSession()
				.createCriteria(UserRole.class)
				.add(Restrictions.eq("userRolePrimaryKey.role.id", roleId))
				.add(Restrictions.eq("userRolePrimaryKey.user.id", userId)))
				.uniqueResult();
	}

}
