package com.fadsan.service;

import java.util.List;

import com.fadsan.model.EmployeeRole;
import com.fadsan.models.dto.RoleDTO;

public interface EmployeeRoleService extends CRUDService<Integer, EmployeeRole> {
	void addEmployeeRole(RoleDTO dto);

	void updateEmployeeRole(RoleDTO dto);

	RoleDTO getRoleDTOById(int RoleId);

	List<EmployeeRole> getAllActiveEmployeeRole();
	
	void deletedEmployeeRole(int RoleId);
	
	RoleDTO getgetRoleDTOByRole(String roleName);
}
