package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.AnnualExamTotalGainMarks;

public interface AnnualExamTotalGainMarksDao extends
		DAO<Integer, AnnualExamTotalGainMarks> {
	public AnnualExamTotalGainMarks getAnnualExamTotalGainMarks(int sessionId,
			int classId, int sectionId, String studentId, String annualExamType);

	public List<AnnualExamTotalGainMarks> getMaxAnnualExamTotalGainMarks(
			int sessionId, int classId, int sectionId, String annualExamType);

}
