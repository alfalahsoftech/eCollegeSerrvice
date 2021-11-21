package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.StudentClassesDao;
import com.fadsan.model.StudentClasses;

@Transactional
@Repository("StudentClassesDao")
public class StudentClassesDaoImpl extends DAOImpl<Integer, StudentClasses>
		implements StudentClassesDao {

	@Override
	public StudentClasses getClassByName(String className) {
		return (StudentClasses) sessionFactory.getCurrentSession()
				.createCriteria(StudentClasses.class)
				.add(Restrictions.eq("className", className)).uniqueResult();
	}

}
