package com.fadsan.service;

import java.util.Date;

import com.fadsan.model.StudentFine;
import com.fadsan.models.dto.StudentFeeSubmissionDetailsDTO;
import com.fadsan.models.dto.StudentFineDTO;

public interface StudentFineService extends CRUDService<Integer, StudentFine> {

	void createStudentFine(
			StudentFeeSubmissionDetailsDTO studentFeeSubmissionDetailsDTO);

	StudentFineDTO getStudentFineById(int studentFineId);

	StudentFineDTO getStudentFineFromToDate(String studentAdmissionNo,
			int sectionId, int classId, String fromDate, String toDate);

	void updateStudentFine(int studentFineId, String fineName, String fineAmount);
}
