package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.StudentTransferDao;
import com.fadsan.model.StudentTransfer;

@Transactional
@Repository("studentTransferDao")
public class StudentTransferDaoImpl extends DAOImpl<Integer, StudentTransfer>
		implements StudentTransferDao {

	@Override
	public StudentTransfer getTcfortudent(String studentId) {
		return (StudentTransfer) sessionFactory.getCurrentSession()
				.createCriteria(StudentTransfer.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("student.studentAdmissionNo", studentId))
				.uniqueResult();
	}

}
