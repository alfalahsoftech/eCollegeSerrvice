package com.fadsan.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.StudentDocument;
import com.fadsan.models.dto.StudentDocumentDTO;

@Transactional
public interface StudentDocumentService extends CRUDService<Integer,StudentDocument>{

	List<StudentDocumentDTO> getDocumentForStudent(String id);

	void saveDocuments(StudentDocumentDTO studentDocumentDTO);

	void saveUploadDocuments(List<StudentDocumentDTO> documentList);

}
