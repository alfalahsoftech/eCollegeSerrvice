package com.fadsan.dao;

import com.fadsan.model.UserRole;
import com.fadsan.model.UserRoleId;

public interface UserRoleDao extends DAO<UserRoleId, UserRole> {

	UserRole getByUserIdAndRoleId(int userId,int roleId);
}
