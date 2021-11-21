package com.fadsan.commom.entitytodtoconvertor;

import com.fadsan.model.StudentWiseFee;
import com.fadsan.models.dto.StudentWiseFeeDTO;

public class StudentWiseFeeEntityToDTO {

	private static final StudentWiseFeeEntityToDTO studentWiseFeeEntityToDTO = new StudentWiseFeeEntityToDTO();

	public static final StudentWiseFeeEntityToDTO getInstance() {
		return studentWiseFeeEntityToDTO;
	}

	public StudentWiseFeeDTO convertEntityToDTO(StudentWiseFee studentWiseFee) {
		StudentWiseFeeDTO studentWiseFeeDTO = new StudentWiseFeeDTO();
		if (studentWiseFee == null) {
		} else {
			studentWiseFeeDTO.setActive(studentWiseFee.isActive());
			studentWiseFeeDTO.setClassId(studentWiseFee.getClasses()
					.getClassId());
			studentWiseFeeDTO.setClassName(studentWiseFee.getClasses()
					.getClassName());
			studentWiseFeeDTO.setFeeAmount(String.valueOf(studentWiseFee
					.getFeeAmount()));
			studentWiseFeeDTO.setFeesCategoriesId(studentWiseFee
					.getFeesCategories().getFeeCategoryId());
			studentWiseFeeDTO.setFeesCategoriesName(studentWiseFee
					.getFeesCategories().getFeeCategoryName());
			studentWiseFeeDTO
					.setMonthId(studentWiseFee.getMonth().getMonthId());
			studentWiseFeeDTO.setMonthName(studentWiseFee.getMonth()
					.getMonthName());
			studentWiseFeeDTO.setSectionId(studentWiseFee.getSection()
					.getSectionId());
			studentWiseFeeDTO.setSectionName(studentWiseFee.getSection()
					.getSectionName());
			studentWiseFeeDTO.setStudentWiseFeeId(studentWiseFee
					.getStudentWiseFeeId());
			studentWiseFeeDTO.setSessionId(studentWiseFee.getSession()
					.getSessionId());
			studentWiseFeeDTO.setSessionName(studentWiseFee.getSession()
					.getSessionDuration());
			studentWiseFeeDTO.setStudentAdmissionNo(studentWiseFee
					.getStudents().getStudentAdmissionNo());
			studentWiseFeeDTO.setFirstName(studentWiseFee.getStudents().getFirstName());

		}
		return studentWiseFeeDTO;
	}
}
