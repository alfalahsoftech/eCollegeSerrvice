package com.fadsan.service;

import com.fadsan.model.StudentCategory;
import com.fadsan.models.dto.StudentCategoryDTO;

public interface StudentCategoryService extends
		CRUDService<Integer, StudentCategory> {
	public StudentCategory getCategoryById(Integer id);

	public void setActiveById(int id);
	
	public StudentCategoryDTO getCategory(String studentCategory);

}
