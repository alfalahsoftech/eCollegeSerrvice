package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fadsan.dao.IssueBookDao;
import com.fadsan.dao.StudentsAdmissionDao;
import com.fadsan.model.IssueBook;
import com.fadsan.models.dto.IssueBookDTO;

@Transactional
@Repository("issueBookDao")
public class IssueBookDaoImpl extends DAOImpl<Integer, IssueBook> implements
		IssueBookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<IssueBook> getIssuedBookByStudentId(String studentId) {
		
		
		return sessionFactory.getCurrentSession()
				.createCriteria(IssueBook.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("student.studentAdmissionNo", studentId))
				.list();
	}

	

}
