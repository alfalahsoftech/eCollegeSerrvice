package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.AnnualExamGainMarksDao;
import com.fadsan.dao.AnnualExamReportDao;
import com.fadsan.model.AnnualExamGainMarks;
import com.fadsan.model.AnnualExamReport;
import com.fadsan.models.dto.AnnualExamReportDTO;
import com.fadsan.service.AnnualExamGainMarksService;

@Service
@Transactional
public class AnnualExamGainMarksServiceImpl extends
		CRUDServiceImpl<Integer, AnnualExamGainMarks, AnnualExamGainMarksDao>
		implements AnnualExamGainMarksService {
	@Autowired
	public AnnualExamGainMarksServiceImpl(AnnualExamGainMarksDao dao) {
		super(dao);
	}

	@Autowired
	private AnnualExamReportDao annualExamReportDao;

	@Override
	public List<AnnualExamReportDTO> getAnnualExamGainMarksList(int sessionId,
			int classId, int sectionId, String studentId,
			String annualExamType, String examType) {
		List<AnnualExamReportDTO> annualExamReports = new ArrayList<AnnualExamReportDTO>();
		AnnualExamReport annualExamReport = annualExamReportDao
				.getAnnualExamReport(sessionId, classId, sectionId, studentId,
						annualExamType, examType);
		if (annualExamReport != null) {
			for (AnnualExamGainMarks annualExamGainMarks : annualExamReport
					.getAnnualExamGainMarks()) {
				AnnualExamReportDTO annualExamReportDTO = new AnnualExamReportDTO();
				annualExamReportDTO.setSubjectName(annualExamGainMarks
						.getSubjects().getSubjectName());
				annualExamReportDTO.setGainMarks(annualExamGainMarks
						.getGainMarks());
				annualExamReportDTO.setRollno(annualExamReport.getStudents().getRollNo());
				annualExamReportDTO.setFatherName(annualExamReport.getStudents().getFatherName());
				annualExamReports.add(annualExamReportDTO);
			}
		}
		return annualExamReports;
	}

}
