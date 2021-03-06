package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadsan.dao.DocumentCategoryDao;
import com.fadsan.model.DocumentsCategory;
import com.fadsan.models.dto.DocumentCategoryDTO;
import com.fadsan.service.DocumentCategoryService;

@Service("documentCategoryService")
public class DocumentCategoryServiceImpl extends
		CRUDServiceImpl<Integer, DocumentsCategory, DocumentCategoryDao>
		implements DocumentCategoryService {

	@Autowired
	public DocumentCategoryServiceImpl(DocumentCategoryDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DocumentCategoryDTO> getDocumentByType(String type) {
		List<DocumentsCategory> lists = dao.getDocumentByType(type);
		List<DocumentCategoryDTO> listdto = new ArrayList<DocumentCategoryDTO>();
		for (DocumentsCategory document : lists) {
			DocumentCategoryDTO dto = new DocumentCategoryDTO();
			dto.setDocumentCategoryId(document.getDocumentCategoryId());
			dto.setDocumentName(document.getDocumentCategoryName());
			dto.setDocumentType(document.getDocumentType());
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public void addDocumentCategory(DocumentCategoryDTO documentCategoryDTO) {
		DocumentsCategory document = new DocumentsCategory();
		document.setActive(true);
		document.setDocumentCategoryName(documentCategoryDTO.getDocumentName());
		document.setDocumentType(documentCategoryDTO.getDocumentType());
		dao.create(document);

	}

	@Override
	public void editDocumentCategory(DocumentCategoryDTO documentCategoryDTO) {
		DocumentsCategory document = dao.get(documentCategoryDTO.getDocumentCategoryId());
		document.setActive(true);
		document.setDocumentCategoryName(documentCategoryDTO.getDocumentName());
		document.setDocumentType(documentCategoryDTO.getDocumentType());
		
		
	}

	@Override
	public void deleteCategory(int id) {
		DocumentsCategory document=dao.get(id);
		document.setActive(false);
		
	}

}
