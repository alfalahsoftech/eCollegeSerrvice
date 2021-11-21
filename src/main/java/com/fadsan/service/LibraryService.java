package com.fadsan.service;

import java.util.List;

import com.fadsan.model.Library;
import com.fadsan.models.dto.LibraryDTO;

public interface LibraryService extends CRUDService<Integer, Library> {

	public void addBook(LibraryDTO libraryDTO);
	public List<LibraryDTO> getSubjectByClass(Integer classId);

	public List<LibraryDTO> getSubjectDetails(Integer classId,
			String subjectName);
	public void updateLibraryBook(int bookId, int classId);
	

	
	
}
