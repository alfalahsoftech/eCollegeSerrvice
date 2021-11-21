package com.fadsan.service;

import com.fadsan.model.AnnualExamTotalGainMarks;
import com.fadsan.models.dto.AnnualExamReportDTO;

public interface AnnualExamTotalGainMarksService extends
		CRUDService<Integer, AnnualExamTotalGainMarks> {
	public void saveAnnualExamTotalGainMarks(
			AnnualExamReportDTO annualExamReportDTO);
}
