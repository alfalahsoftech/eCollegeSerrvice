package com.fadsan.dao;

import com.fadsan.model.AnnualExamGainMarks;

public interface AnnualExamGainMarksDao extends
		DAO<Integer, AnnualExamGainMarks> {
	public AnnualExamGainMarks getAnnualExamGainMarks(int subjectId,
			int annualExamReportId);

}
