package com.fadsan.commom.dtotoentityconvertor;

import com.fadsan.model.AnnualExamReport;
import com.fadsan.model.Section;
import com.fadsan.model.Session;
import com.fadsan.model.StudentClasses;
import com.fadsan.model.Students;
import com.fadsan.model.Subjects;
import com.fadsan.models.dto.AnnualExamReportDTO;

public class AnnualExamReportDTOToEntity {
	public static final AnnualExamReportDTOToEntity annualExamReportDTOToEntity = new AnnualExamReportDTOToEntity();

	public static final AnnualExamReportDTOToEntity getInstance() {
		return annualExamReportDTOToEntity;
	}

	public AnnualExamReport convertEntityToDTO(
			AnnualExamReportDTO annualExamReportDTO) {
		AnnualExamReport annualExamReport = new AnnualExamReport();
		Session session = new Session();
		session.setSessionId(annualExamReportDTO.getSessionId());
		StudentClasses studentClasses = new StudentClasses();
		studentClasses.setClassId(annualExamReportDTO.getClassId());
		Section section = new Section();
		section.setSectionId(annualExamReportDTO.getSectionId());
		Students students = new Students();
		students.setStudentAdmissionNo(annualExamReportDTO.getStudentId());
		Subjects subjects = new Subjects();
		subjects.setSubjectsId(annualExamReportDTO.getSubjectId());
		annualExamReport.setMaxMarks(annualExamReportDTO.getMaxMarks());
		annualExamReport.setSection(section);
		annualExamReport.setSession(session);
		annualExamReport.setStudentClasses(studentClasses);
		annualExamReport.setStudents(students);
		annualExamReport.setAnnualExamType(annualExamReportDTO.getAnnualExamType());
		annualExamReport.setExamType(annualExamReportDTO.getExamType());
		return annualExamReport;
	}
}

