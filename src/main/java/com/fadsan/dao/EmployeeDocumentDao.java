package com.fadsan.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.EmployeeDocument;

@Transactional
public interface EmployeeDocumentDao extends DAO<Integer,EmployeeDocument>{

	EmployeeDocument findEmployeeDocument(Integer documentCategoryId, int id);

}
