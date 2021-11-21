package com.fadsan.dao;

import com.fadsan.model.StudentClasses;

public interface StudentClassesDao extends DAO<Integer, StudentClasses>{
	StudentClasses getClassByName(String className);

}
