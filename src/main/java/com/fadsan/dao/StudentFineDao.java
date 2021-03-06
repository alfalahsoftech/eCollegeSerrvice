package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.StudentFine;

public interface StudentFineDao extends DAO<Integer, StudentFine> {
	StudentFine getStudentFine(int classId, int sectionId,
			String studentAdmissionNo, Date last);

	public StudentFine getStudentFineFromToDate(String studentAdmissionNo,
			int sectionId, int classId, Date fromDate, Date toDate);

	List<StudentFine> getFineAmountByMonth(Date frmDate, Date toDate);
	StudentFine getStudentFine(int studentFeeSubDetailId);
}
