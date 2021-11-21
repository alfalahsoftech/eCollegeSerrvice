package com.fadsan.service;

import java.util.Collection;

import com.fadsan.model.AssignClass;
import com.fadsan.models.dto.AssignClassDTO;
import com.fadsan.models.dto.StudentClassesDTO;

public interface AssignClassService extends CRUDService<Integer, AssignClass> {

	Collection<AssignClassDTO> getAssignTeacherByClassId(int employeeId);

	void assignClassToTeacher(AssignClassDTO assignClassDTO);

	String checkAssignClassesForTecher(int sectionId, int classId);

	Boolean deleteAssignedClassById(int classAssignId);

	StudentClassesDTO getAssignClassAndSection(int employeeId);
}