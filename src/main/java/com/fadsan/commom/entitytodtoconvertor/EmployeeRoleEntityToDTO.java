package com.fadsan.commom.entitytodtoconvertor;

import com.fadsan.model.EmployeeRole;
import com.fadsan.models.dto.RoleDTO;

public class EmployeeRoleEntityToDTO {
	private static final EmployeeRoleEntityToDTO employeeRoleEntityToDTO = new EmployeeRoleEntityToDTO();

	public static final EmployeeRoleEntityToDTO getInstance() {
		return employeeRoleEntityToDTO;
	}

	public RoleDTO convertEntityToDTO(EmployeeRole employeeRole) {
		RoleDTO roleDTO = null;
		if (employeeRole != null) {
			roleDTO = new RoleDTO();
			roleDTO.setDelete(employeeRole.isActive());
			roleDTO.setId(employeeRole.getEmployeeRoleId());
			roleDTO.setRoleName(employeeRole.getRoleName());
		}
		return roleDTO;
	}
}
