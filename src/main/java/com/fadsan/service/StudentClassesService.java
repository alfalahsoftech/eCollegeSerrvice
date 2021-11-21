package com.fadsan.service;

import java.util.List;

import com.fadsan.model.StudentClasses;
import com.fadsan.models.dto.StudentClassesDTO;

public interface StudentClassesService extends
		CRUDService<Integer, StudentClasses> {

	List<StudentClassesDTO> getAllClass();

	StudentClassesDTO getClassById(int classId);

	public List<StudentClassesDTO> getAssignClassByEmpId(int employeeId);
	StudentClassesDTO getClassByName(String className);
		
}
