package com.fadsan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.entitytodtoconvertor.EmployeeRoleEntityToDTO;
import com.fadsan.dao.EmployeeRoleDao;
import com.fadsan.model.EmployeeRole;
import com.fadsan.models.dto.RoleDTO;
import com.fadsan.service.EmployeeRoleService;

@Transactional
@Service("employeeRoleService")
public class EmployeeServiceImpl extends
		CRUDServiceImpl<Integer, EmployeeRole, EmployeeRoleDao> implements
		EmployeeRoleService {
	@Autowired
	public EmployeeServiceImpl(EmployeeRoleDao dao) {
		super(dao);
	}

	@Transactional
	public void addEmployeeRole(RoleDTO dto) {
		EmployeeRole role = new EmployeeRole();
		role.setRoleName(dto.getRoleName());
		role.setActive(true);
		dao.create(role);
	}

	@Override
	public RoleDTO getRoleDTOById(int RoleId) {
		EmployeeRole role = dao.get(RoleId);
		EmployeeRoleEntityToDTO employeeRoleEntityToDTO = EmployeeRoleEntityToDTO
				.getInstance();
		return employeeRoleEntityToDTO.convertEntityToDTO(role);
	}

	@Override
	public void updateEmployeeRole(RoleDTO dto) {
		EmployeeRole role = dao.get(dto.getId());
		role.setRoleName(dto.getRoleName());
		dao.update(role);

	}

	@Override
	public List<EmployeeRole> getAllActiveEmployeeRole() {
		return dao.getAllActiveEmployeeRole();
	}

	@Override
	public void deletedEmployeeRole(int RoleId) {
		EmployeeRole role = dao.get(RoleId);
		role.setActive(false);
		dao.update(role);
	}

	@Override
	public RoleDTO getgetRoleDTOByRole(String roleName) {
		EmployeeRole role = dao.getgetRoleDTOByRole(roleName);
		EmployeeRoleEntityToDTO employeeRoleEntityToDTO = EmployeeRoleEntityToDTO
				.getInstance();
		return employeeRoleEntityToDTO.convertEntityToDTO(role);
	}
}
