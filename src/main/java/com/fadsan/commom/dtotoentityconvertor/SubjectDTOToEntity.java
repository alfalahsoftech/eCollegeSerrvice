package com.fadsan.commom.dtotoentityconvertor;

import com.fadsan.model.Section;
import com.fadsan.model.Session;
import com.fadsan.model.StudentClasses;
import com.fadsan.model.Subjects;
import com.fadsan.models.dto.SubjectDTO;

public class SubjectDTOToEntity {
	private static final SubjectDTOToEntity subjectDTOToEntity = new SubjectDTOToEntity();

	public static final SubjectDTOToEntity getInstance() {
		return subjectDTOToEntity;
	}

	public Subjects getInstance(SubjectDTO subjectDTO) {
	
		Subjects subjects = new Subjects();
		if (subjectDTO.getActive().equals("true"))
			subjects.setActive(true);
		else{
			subjects.setActive(false);
		}
		subjects.setSubjectName(subjectDTO.getSubjectName());
		StudentClasses studentClasses=new StudentClasses();
		studentClasses.setClassId(subjectDTO.getClassId());
		subjects.setStudentClasses(studentClasses);
		Section section=new Section(); 
		section.setSectionId(subjectDTO.getSectionId());
		subjects.setSection(section);
		Session session=new Session();
		session.setSessionId(subjectDTO.getSessionId());
		subjects.setSession(session);
		return subjects;
	}
}
