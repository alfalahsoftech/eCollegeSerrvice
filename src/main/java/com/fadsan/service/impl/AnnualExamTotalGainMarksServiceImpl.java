package com.fadsan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.AnnualExamReportDao;
import com.fadsan.dao.AnnualExamTotalGainMarksDao;
import com.fadsan.model.AnnualExamGainMarks;
import com.fadsan.model.AnnualExamReport;
import com.fadsan.model.AnnualExamTotalGainMarks;
import com.fadsan.model.Section;
import com.fadsan.model.Session;
import com.fadsan.model.StudentClasses;
import com.fadsan.model.Students;
import com.fadsan.models.dto.AnnualExamReportDTO;
import com.fadsan.service.AnnualExamTotalGainMarksService;

@Service
@Transactional
public class AnnualExamTotalGainMarksServiceImpl
		extends
		CRUDServiceImpl<Integer, AnnualExamTotalGainMarks, AnnualExamTotalGainMarksDao>
		implements AnnualExamTotalGainMarksService {
	@Autowired
	public AnnualExamTotalGainMarksServiceImpl(AnnualExamTotalGainMarksDao dao) {
		super(dao);
	}

	@Autowired
	private AnnualExamTotalGainMarksDao annualExamTotalGainMarksDao;
	@Autowired
	private AnnualExamReportDao annualExamReportDao;

	@Override
	public void saveAnnualExamTotalGainMarks(
			AnnualExamReportDTO annualExamReportDTO) {
		Double totalMarks = 0.0;
		Double totalGain = 0.0;
		AnnualExamTotalGainMarks annualExamTotalGainMarks = annualExamTotalGainMarksDao
				.getAnnualExamTotalGainMarks(
						annualExamReportDTO.getSessionId(),
						annualExamReportDTO.getClassId(),
						annualExamReportDTO.getSectionId(),
						annualExamReportDTO.getStudentId(),
						annualExamReportDTO.getAnnualExamType());
		List<AnnualExamReport> annualExamReports = annualExamReportDao
				.getAnnualExamReport(annualExamReportDTO.getSessionId(),
						annualExamReportDTO.getClassId(),
						annualExamReportDTO.getSectionId(),
						annualExamReportDTO.getStudentId(),
						annualExamReportDTO.getAnnualExamType());
		if (!annualExamReports.isEmpty()) {
			for (AnnualExamReport annualExamReport : annualExamReports) {
				List<AnnualExamGainMarks> annualExamGainMarksList = annualExamReport
						.getAnnualExamGainMarks();
				totalMarks += annualExamReport.getMaxMarks()
						* annualExamGainMarksList.size();
				for (AnnualExamGainMarks annualExamGainMarks : annualExamGainMarksList) {
					totalGain += annualExamGainMarks.getGainMarks();
				}
			}
			if (annualExamTotalGainMarks == null) {
				AnnualExamTotalGainMarks annualExamTotalGainMarksNew = new AnnualExamTotalGainMarks();
				Session session = new Session();
				session.setSessionId(annualExamReportDTO.getSessionId());
				StudentClasses studentClasses = new StudentClasses();
				studentClasses.setClassId(annualExamReportDTO.getClassId());
				Section section = new Section();
				section.setSectionId(annualExamReportDTO.getSectionId());
				Students students = new Students();
				students.setStudentAdmissionNo(annualExamReportDTO
						.getStudentId());
				annualExamTotalGainMarksNew.setSection(section);
				annualExamTotalGainMarksNew.setSession(session);
				annualExamTotalGainMarksNew.setStudentClasses(studentClasses);
				annualExamTotalGainMarksNew.setStudents(students);
				annualExamTotalGainMarksNew.setTotalGainMarks(totalGain);
				annualExamTotalGainMarksNew.setTotalMarks(totalMarks);
				annualExamTotalGainMarksNew
						.setAnnualExamType(annualExamReportDTO
								.getAnnualExamType());
				dao.create(annualExamTotalGainMarksNew);
			} else {
				annualExamTotalGainMarks.setTotalGainMarks(totalGain);
				annualExamTotalGainMarks.setTotalMarks(totalMarks);
				dao.update(annualExamTotalGainMarks);
			}

		}
	}

}
