package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.EmployeeRole;

public interface EmployeeRoleDao extends DAO<Integer, EmployeeRole> {
	public List<EmployeeRole> getAllActiveEmployeeRole();
	public EmployeeRole getgetRoleDTOByRole(String roleName);
}
