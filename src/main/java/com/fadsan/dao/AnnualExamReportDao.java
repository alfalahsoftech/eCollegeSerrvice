package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.AnnualExamReport;

public interface AnnualExamReportDao extends DAO<Integer, AnnualExamReport> {
	public AnnualExamReport getAnnualExamReport(int sessionId, int classId,
			int sectionId, String studentId, String annualExamType,
			String examType);

	public List<AnnualExamReport> getAnnualExamReport(int sessionId,
			int classId, int sectionId, String studentId);

	public List<AnnualExamReport> getAnnualExamReport(int sessionId,
			int classId, int sectionId, String studentId, String annualExamType);

	public AnnualExamReport getAnnualMaxExam(int sessionId, int classId,
			int sectionId, String annualExamType, String examType);
	
}
