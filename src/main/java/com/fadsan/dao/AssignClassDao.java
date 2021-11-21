package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.AssignClass;

public interface AssignClassDao extends DAO<Integer, AssignClass> {

	List<AssignClass> getAssignClassById(int employeeId);
	 public AssignClass getAssignClassAndSection(int employeeId);
	AssignClass checkAssignClassesForTecher(int employeeId, int classId);

}
