package com.fadsan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.StudentCategoryDao;
import com.fadsan.model.StudentCategory;
import com.fadsan.models.dto.StudentCategoryDTO;
import com.fadsan.service.StudentCategoryService;

@Transactional
@Service("studentCategoryService")
public class StudentCategoryServiceImpl extends
		CRUDServiceImpl<Integer, StudentCategory, StudentCategoryDao> implements
		StudentCategoryService {

	@Autowired
	public StudentCategoryServiceImpl(StudentCategoryDao dao) {
		super(dao);
	}

	@Override
	public StudentCategory getCategoryById(Integer id) {
		return dao.get(id);
	}

	@Transactional
	public void setActiveById(int id) {
		dao.get(id).setActive(false);

	}

	@Override
	public StudentCategoryDTO getCategory(String studentCategory) {
		return converEntityToDTO(dao.getStudentCategory(studentCategory));
	}

	private StudentCategoryDTO converEntityToDTO(StudentCategory studentCategory) {
		StudentCategoryDTO studentCategoryDTO = null;
		if (studentCategory != null) {
			studentCategoryDTO = new StudentCategoryDTO();
			studentCategoryDTO.setActive(studentCategory.isActive());
			studentCategoryDTO.setStudentCategoriesId(studentCategory
					.getStudentCategoriesId());
			studentCategoryDTO.setStudentCategoriesName(studentCategory
					.getStudentCategoriesName());
		}
		return studentCategoryDTO;
	}

}
