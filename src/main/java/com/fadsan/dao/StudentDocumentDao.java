package com.fadsan.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.StudentDocument;

@Transactional
public interface StudentDocumentDao extends DAO<Integer,StudentDocument>{

	StudentDocument findStudentDocument(Integer documentCategoryId, String id);

}
