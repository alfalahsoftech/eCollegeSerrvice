package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.fadsan.dao.AnnualExamGainMarksDao;
import com.fadsan.model.AnnualExamGainMarks;

@Service
public class AnnualExamGainMarksDaoImpl extends
		DAOImpl<Integer, AnnualExamGainMarks> implements AnnualExamGainMarksDao {

	@Override
	public AnnualExamGainMarks getAnnualExamGainMarks(int subjectId,
			int annualExamReportId) {
		return (AnnualExamGainMarks) sessionFactory
				.getCurrentSession()
				.createCriteria(AnnualExamGainMarks.class)
				.add(Restrictions.eq("subjects.subjectsId", subjectId))
				.add(Restrictions.eq("annualExamReport.annualExamReportId",
						annualExamReportId)).uniqueResult();
	}

}
