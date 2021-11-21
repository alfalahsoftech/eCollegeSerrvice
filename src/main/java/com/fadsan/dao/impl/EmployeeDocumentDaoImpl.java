package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fadsan.dao.EmployeeDocumentDao;
import com.fadsan.model.EmployeeDocument;

@Repository("employeeDocumentDao")
public class EmployeeDocumentDaoImpl extends DAOImpl<Integer, EmployeeDocument>
		implements EmployeeDocumentDao {

	@Override
	public EmployeeDocument findEmployeeDocument(Integer documentCategoryId,
			int id) {
		return (EmployeeDocument) sessionFactory.getCurrentSession()
				.createCriteria(EmployeeDocument.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("document.documentCategoryId", documentCategoryId))
				.add(Restrictions.eq("employees.employeeId", id)).uniqueResult();
	}

}
