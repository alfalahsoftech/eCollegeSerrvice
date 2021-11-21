package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.StudentCategoryDao;
import com.fadsan.model.StudentCategory;

@Transactional
@Repository("studentCategoryDao")
public class StudentCategoryDaoImpl extends DAOImpl<Integer, StudentCategory>
		implements StudentCategoryDao {

	@Override
	public StudentCategory getStudentCategory(String studentCategory) {
		return (StudentCategory) sessionFactory.getCurrentSession()
				.createCriteria(StudentCategory.class)
				.add(Restrictions.eq("studentCategoriesName", studentCategory).ignoreCase())
				.uniqueResult();
	}

}
