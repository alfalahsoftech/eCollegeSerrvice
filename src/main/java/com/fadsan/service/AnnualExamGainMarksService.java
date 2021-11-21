package com.fadsan.service;

import java.util.List;

import com.fadsan.model.AnnualExamGainMarks;
import com.fadsan.models.dto.AnnualExamReportDTO;

public interface AnnualExamGainMarksService extends
		CRUDService<Integer, AnnualExamGainMarks> {
	public List<AnnualExamReportDTO> getAnnualExamGainMarksList(int sessionId,
			int classId, int sectionId, String studentId, String annualExamType,
			String examType);

}
