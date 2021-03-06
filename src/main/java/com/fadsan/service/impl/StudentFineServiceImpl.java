package com.fadsan.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.entitytodtoconvertor.StudentFineEntityToDTO;
import com.fadsan.dao.StudentFineDao;
import com.fadsan.model.Section;
import com.fadsan.model.StudentClasses;
import com.fadsan.model.StudentFine;
import com.fadsan.model.Students;
import com.fadsan.models.dto.StudentFeeSubmissionDetailsDTO;
import com.fadsan.models.dto.StudentFineDTO;
import com.fadsan.service.StudentFineService;

@Service
@Transactional
public class StudentFineServiceImpl extends
		CRUDServiceImpl<Integer, StudentFine, StudentFineDao> implements
		StudentFineService {
	@Autowired
	public StudentFineServiceImpl(StudentFineDao dao) {
		super(dao);
	}

	@Override
	public void createStudentFine(
			StudentFeeSubmissionDetailsDTO studentFeeSubmissionDetailsDTO) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Students students = new Students();
		students.setStudentAdmissionNo(studentFeeSubmissionDetailsDTO
				.getStudentAdmissionNo());
		StudentClasses studentClasses = new StudentClasses();
		studentClasses.setClassId(studentFeeSubmissionDetailsDTO.getClassId());
		Section section = new Section();
		section.setSectionId(studentFeeSubmissionDetailsDTO.getSectionId());
		StudentFine studentFine = new StudentFine();
		studentFine.setCreatedAt(new Date());
		studentFine.setFineAmount(studentFeeSubmissionDetailsDTO
				.getFineAmount());
		studentFine.setFineName("Late Fee");
		studentFine.setPaid(false);
		studentFine.setStudents(students);
		studentFine.setSection(section);
		studentFine.setStudentClasses(studentClasses);
		try {
			studentFine.setLastDate(sdf.parse(studentFeeSubmissionDetailsDTO
					.getLastDate()));
			studentFine.setFromDate(sdf.parse(studentFeeSubmissionDetailsDTO
					.getFromDate()));
			studentFine.setToDate(sdf.parse(studentFeeSubmissionDetailsDTO
					.getToDate()));
			studentFine.setLastDate(sdf.parse(studentFeeSubmissionDetailsDTO
					.getLastDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentFine.setUpdatedAt(new Date());
		dao.create(studentFine);
	}

	@Override
	public StudentFineDTO getStudentFineById(int studentFineId) {
		StudentFine studentFine = dao.get(studentFineId);
		StudentFineEntityToDTO studentFineEntityToDTO = StudentFineEntityToDTO
				.getInstance();
		return studentFineEntityToDTO.convertEntityToDTO(studentFine);
	}

	@Override
	public void updateStudentFine(int studentFineId, String fineName,
			String fineAmount) {
		StudentFine studentFine = dao.get(studentFineId);
		studentFine.setUpdatedAt(new Date());
		studentFine.setFineAmount(fineAmount);
		studentFine.setFineName(fineName);
		dao.update(studentFine);
	}

	@Override
	public StudentFineDTO getStudentFineFromToDate(String studentAdmissionNo,
			int sectionId, int classId, String fromDate, String toDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date getFromDate = new Date();
		Date getToDate = new Date();
		try {
			getFromDate = sdf.parse(fromDate);
			getToDate = sdf.parse(toDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StudentFineEntityToDTO studentFineEntityToDTO = StudentFineEntityToDTO
				.getInstance();
		StudentFine studentFine = dao.getStudentFineFromToDate(
				studentAdmissionNo, sectionId, classId, getFromDate, getToDate);
		return studentFineEntityToDTO.convertEntityToDTO(studentFine);
	}

}
