package com.fadsan.dao;

import com.fadsan.model.StudentCategory;

public interface StudentCategoryDao extends DAO<Integer, StudentCategory> {
public StudentCategory getStudentCategory(String studentCategory);
	
}
