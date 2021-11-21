package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.NewStudentTransferDao;
import com.fadsan.model.NewStudentTransfer;
@Transactional
@Repository("NewStudentTransferDao")
public class NewStudentTransferDaoImpl extends DAOImpl<Integer, NewStudentTransfer>implements NewStudentTransferDao{

	@Override
	public NewStudentTransfer getTCForStudent(String studentId) {
		return  (NewStudentTransfer) sessionFactory.getCurrentSession()
				.createCriteria(NewStudentTransfer.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("student.studentAdmissionNo", studentId))
				.uniqueResult();
	}



}
