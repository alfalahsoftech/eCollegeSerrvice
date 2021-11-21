package com.fadsan.service;

import java.util.List;

import com.fadsan.model.AnnuallySubjectMarks;
import com.fadsan.models.dto.AnnuallySubjectMarksDTO;

public interface AnnuallySubjectMarksService extends
		CRUDService<Integer, AnnuallySubjectMarks> {
	public List<AnnuallySubjectMarksDTO> getAnnuallySubjectMarks(int sessionId,
			int classId, int sectionId, String examType, String annualExamType);


}
