package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.fadsan.dao.AnnuallySubjectMarksDao;
import com.fadsan.model.AnnuallySubjectMarks;

@Service
public class AnnuallySubjectMarksDaoImpl extends
		DAOImpl<Integer, AnnuallySubjectMarks> implements
		AnnuallySubjectMarksDao {

	@Override
	public AnnuallySubjectMarks getAnnuallySubjectMarks(int sessionId,
			int classId, int sectionId, int subjectId, String examType,
			String annualExamType) {

		return (AnnuallySubjectMarks) sessionFactory.getCurrentSession()
				.createCriteria(AnnuallySubjectMarks.class)
				.add(Restrictions.eq("session.sessionId", sessionId))
				.add(Restrictions.eq("studentClasses.classId", classId))
				.add(Restrictions.eq("section.sectionId", sectionId))
				.add(Restrictions.eq("subjects.subjectsId", subjectId))
				.add(Restrictions.eq("examType", examType))
				.add(Restrictions.eq("examReportType", annualExamType))
				.uniqueResult();
	}

}
