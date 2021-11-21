package com.fadsan.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.DocumentsCategory;
import com.fadsan.models.dto.DocumentCategoryDTO;

@Transactional
public interface DocumentCategoryService extends
		CRUDService<Integer, DocumentsCategory> {

	List<DocumentCategoryDTO> getDocumentByType(String type);

	void addDocumentCategory(DocumentCategoryDTO documentCategoryDTO);

	void editDocumentCategory(DocumentCategoryDTO documentCategoryDTO);

	void deleteCategory(int id);

}
