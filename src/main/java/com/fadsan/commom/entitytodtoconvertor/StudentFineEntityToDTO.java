package com.fadsan.commom.entitytodtoconvertor;

import java.text.SimpleDateFormat;

import com.fadsan.model.StudentFine;
import com.fadsan.model.Students;
import com.fadsan.models.dto.StudentFineDTO;

public class StudentFineEntityToDTO {
	private static final StudentFineEntityToDTO studentFineEntityToDTO = new StudentFineEntityToDTO();

	public static final StudentFineEntityToDTO getInstance() {
		return studentFineEntityToDTO;
	}

	public StudentFineDTO convertEntityToDTO(StudentFine studentFine) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StudentFineDTO studentFineDTO = new StudentFineDTO();
		if (studentFine == null) {
		} else {
			Students students = studentFine.getStudents();
			studentFineDTO.setCreatedAt(studentFine.getCreatedAt().toString());
			studentFineDTO.setFineAmount(studentFine.getFineAmount());
			studentFineDTO.setFineName(studentFine.getFineName());
			studentFineDTO.setStudentAdmissionNo(students
					.getStudentAdmissionNo());
			studentFineDTO.setStudentFineId(studentFine.getStudentFineId());
			if (studentFine.isPaid() == true) {
				studentFineDTO.setPaid("yes");
			} else {
				studentFineDTO.setPaid("no");
			}
		}
		return studentFineDTO;
	}
}
