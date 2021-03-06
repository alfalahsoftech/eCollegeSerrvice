package com.fadsan.service;

import java.util.Map;

import com.fadsan.model.AnnualExamReport;
import com.fadsan.models.dto.AnnualExamReportDTO;

public interface AnnualExamReportService extends
		CRUDService<Integer, AnnualExamReport> {
	public void saveAnnualExamReport(AnnualExamReportDTO annualExamReportDTO);

	public Map<String, Object> getDataForGenerateReportCard(int sessionId,
			int classId, int sectionId, String StudentId);

	public Map<String, Object> getAnnualExamReport(int sessionId, int classId,
			int sectionId, String examType, String annualExamType);

	public Double getMaxMarksforExam(int sessionId, int classId, int sectionId,
			String examType, String annualExamType);

}
