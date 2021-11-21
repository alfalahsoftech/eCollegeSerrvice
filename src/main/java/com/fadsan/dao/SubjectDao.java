package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Subjects;

public interface SubjectDao extends DAO<Integer, Subjects>{

	List<Subjects> getSubjectList(int classId, int sectionId, int sessionId);
	public Subjects getSubjects(int classId, int sectionId, String subjectName,int sessionId);
	List<Subjects> getSubjectforclass(int classId, Integer sessionId);

}
