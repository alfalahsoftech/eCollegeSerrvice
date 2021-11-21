package com.fadsan.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.DocumentsCategory;

@Transactional
public interface DocumentCategoryDao extends DAO<Integer,DocumentsCategory>{

	List<DocumentsCategory> getDocumentByType(String type);

}
