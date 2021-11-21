package com.fadsan.commom.dtotoentityconvertor;

import java.util.Date;

import com.fadsan.model.Month;
import com.fadsan.model.MonthlyExamReport;
import com.fadsan.model.Section;
import com.fadsan.model.Session;
import com.fadsan.model.StudentClasses;
import com.fadsan.model.Students;
import com.fadsan.model.Subjects;
import com.fadsan.models.dto.MonthlyExamReportDTO;

public class MonthlyExamReportDTOToEntity {
	public static final MonthlyExamReportDTOToEntity monthlyExamReportDTOToEntity = new MonthlyExamReportDTOToEntity();

	public static final MonthlyExamReportDTOToEntity getInstance() {
		return monthlyExamReportDTOToEntity;
	}

	public MonthlyExamReport convertEntityToDTO(
			MonthlyExamReportDTO monthlyExamReportDTO) {
		MonthlyExamReport monthlyExamReport = new MonthlyExamReport();
		Session session = new Session();
		session.setSessionId(monthlyExamReportDTO.getSessionId());
		StudentClasses studentClasses = new StudentClasses();
		studentClasses.setClassId(monthlyExamReportDTO.getClassId());
		Section section = new Section();
		section.setSectionId(monthlyExamReportDTO.getSectionId());
		Students students = new Students();
		students.setStudentAdmissionNo(monthlyExamReportDTO.getStudentId());
		Subjects subjects = new Subjects();
		subjects.setSubjectsId(monthlyExamReportDTO.getSubjectId());
		Month month = new Month();
		month.setMonthId(monthlyExamReportDTO.getMonthId());
		monthlyExamReport.setCreatedAt(new Date());
		monthlyExamReport.setMarks(monthlyExamReportDTO.getMarks());
		monthlyExamReport.setMaxMarks(monthlyExamReportDTO.getMaxMarks());
		monthlyExamReport.setMonth(month);
		monthlyExamReport.setSection(section);
		monthlyExamReport.setSession(session);
		monthlyExamReport.setStudentClasses(studentClasses);
		monthlyExamReport.setStudents(students);
		monthlyExamReport.setSubjects(subjects);
		monthlyExamReport.setUpdatedAt(new Date());
		monthlyExamReport.setMonthlyExamReportId(monthlyExamReportDTO.getMonthlyExamReportId());
		return monthlyExamReport;
	}
}
