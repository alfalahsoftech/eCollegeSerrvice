package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.MonthlyExamReport;

public interface MonthlyExamReportDao extends DAO<Integer, MonthlyExamReport> {
	public MonthlyExamReport getMonthlyExamReport(int sessionId, int classId,
			int sectionId, String studentId, int subjectId, int monthId);

	public List<MonthlyExamReport> maxMonthId(int sessionId, int classId,
			int sectionId, String studentId);

	public List<MonthlyExamReport> getMonthIdBeetweenJanToMarch(int sessionId,
			int classId, int sectionId, String studentId);

	public List<MonthlyExamReport> getMonthlyExamReports(int sessionId, int classId,
			int sectionId, String studentId, int monthId);

	public MonthlyExamReport getMaxMarks(int classId, int sessionId,
			int sectionId, int monthId,int subjectId);

}
