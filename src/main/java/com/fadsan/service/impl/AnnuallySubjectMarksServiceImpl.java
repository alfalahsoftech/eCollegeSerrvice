package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.AnnuallySubjectMarksDao;
import com.fadsan.dao.SectionDao;
import com.fadsan.dao.SessionDao;
import com.fadsan.dao.StudentClassesDao;
import com.fadsan.dao.SubjectDao;
import com.fadsan.model.AnnuallySubjectMarks;
import com.fadsan.model.Subjects;
import com.fadsan.models.dto.AnnuallySubjectMarksDTO;
import com.fadsan.service.AnnuallySubjectMarksService;

@Service
@Transactional
public class AnnuallySubjectMarksServiceImpl extends
		CRUDServiceImpl<Integer, AnnuallySubjectMarks, AnnuallySubjectMarksDao>
		implements AnnuallySubjectMarksService {
	@Autowired
	public AnnuallySubjectMarksServiceImpl(AnnuallySubjectMarksDao dao) {
		super(dao);
	}

	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private StudentClassesDao studentClassesDao;
	@Autowired
	private SectionDao sectionDao;

	@Override
	public List<AnnuallySubjectMarksDTO> getAnnuallySubjectMarks(int sessionId,
			int classId, int sectionId, String examType, String annualExamType) {
		List<AnnuallySubjectMarksDTO> annuallySubjectMarksDTOs = new ArrayList<AnnuallySubjectMarksDTO>();
		List<Subjects> subjectsList = subjectDao.getSubjectList(classId,
				sectionId, sessionId);
		for (Subjects subjects : subjectsList) {
			AnnuallySubjectMarks annuallySubjectMarks = dao
					.getAnnuallySubjectMarks(sessionId, classId, sectionId,
							subjects.getSubjectsId(), examType, annualExamType);
			if (annuallySubjectMarks != null)
				annuallySubjectMarksDTOs
						.add(convertEntityToDTO(annuallySubjectMarks));
			else {
				annuallySubjectMarksDTOs.add(getDTOFormData(subjects));
			}
		}
		return annuallySubjectMarksDTOs;
	}

	private AnnuallySubjectMarksDTO getDTOFormData(Subjects subjects) {
		AnnuallySubjectMarksDTO annuallySubjectMarksDTO = new AnnuallySubjectMarksDTO();
		annuallySubjectMarksDTO.setSubjectsId(subjects.getSubjectsId());
		annuallySubjectMarksDTO.setSubjectsName(subjects.getSubjectName());
		annuallySubjectMarksDTO.setMaxMarks("");
		return annuallySubjectMarksDTO;
	}

	private AnnuallySubjectMarksDTO convertEntityToDTO(
			AnnuallySubjectMarks annuallySubjectMarks) {
		AnnuallySubjectMarksDTO annuallySubjectMarksDTO = null;
		if (annuallySubjectMarks != null) {
			annuallySubjectMarksDTO = new AnnuallySubjectMarksDTO();
			annuallySubjectMarksDTO
					.setAnnuaallySubjectMarksId(annuallySubjectMarks
							.getAnnuaallySubjectMarksId());
			annuallySubjectMarksDTO.setClassId(annuallySubjectMarks
					.getStudentClasses().getClassId());
			annuallySubjectMarksDTO.setClassName(annuallySubjectMarks
					.getStudentClasses().getClassName());
			annuallySubjectMarksDTO.setExamReportType(annuallySubjectMarks
					.getExamReportType());
			annuallySubjectMarksDTO.setExamType(annuallySubjectMarks
					.getExamType());
			annuallySubjectMarksDTO.setSectionId(annuallySubjectMarks
					.getSection().getSectionId());
			annuallySubjectMarksDTO.setSectionName(annuallySubjectMarks
					.getSection().getSectionName());
			annuallySubjectMarksDTO.setSessionId(annuallySubjectMarks
					.getSession().getSessionId());
			annuallySubjectMarksDTO.setSessionName(annuallySubjectMarks
					.getSession().getSessionDuration());
			annuallySubjectMarksDTO.setSubjectsId(annuallySubjectMarks
					.getSubjects().getSubjectsId());
			annuallySubjectMarksDTO.setSubjectsName(annuallySubjectMarks
					.getSubjects().getSubjectName());
			annuallySubjectMarksDTO.setMaxMarks(annuallySubjectMarks
					.getMaxMarks());
		}
		return annuallySubjectMarksDTO;
	}



}
