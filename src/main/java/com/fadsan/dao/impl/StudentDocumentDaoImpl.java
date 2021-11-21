package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fadsan.dao.StudentDocumentDao;
import com.fadsan.model.StudentDocument;

@Repository("studentDocumentDao")
public class StudentDocumentDaoImpl extends DAOImpl<Integer, StudentDocument>
		implements StudentDocumentDao {

	@Override
	public StudentDocument findStudentDocument(Integer documentCategoryId,
			String id) {
		return (StudentDocument) sessionFactory.getCurrentSession()
				.createCriteria(StudentDocument.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("document.documentCategoryId", documentCategoryId))
				.add(Restrictions.eq("student", id)).uniqueResult();
	}

}
