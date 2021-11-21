package com.fadsan.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.EmployeeDocument;
import com.fadsan.models.dto.EmployeeDocumentDTO;

@Transactional
public interface EmployeeDocumentService extends
		CRUDService<Integer, EmployeeDocument> {

	List<EmployeeDocumentDTO> findDocumentsforEmployee(int id);

	void saveDocuments(EmployeeDocumentDTO employeeDocumentDTO);

	void saveDocuments(List<EmployeeDocumentDTO> documentList);

}
