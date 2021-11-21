package com.fadsan.dao;

import com.fadsan.model.LoginRole;

public interface LoginRoleDao extends DAO<Integer, LoginRole> {

	LoginRole getUserRoleByName(String name);
}
