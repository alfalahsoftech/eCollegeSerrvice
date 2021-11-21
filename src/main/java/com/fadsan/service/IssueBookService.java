package com.fadsan.service;

import java.util.List;

import com.fadsan.model.IssueBook;
import com.fadsan.models.dto.IssueBookDTO;

public interface IssueBookService extends CRUDService<Integer,IssueBook> {

	List<IssueBookDTO> getIssuedBookByStudentId(String studentId);
	
	List<IssueBookDTO> getIssuedBookByStudentBookId(String bookId);

	void issueBookToStudent(int bookId, int admissionNo,String isbn);

	List<IssueBookDTO> getIssueBookToStudent(String bookName, int bookId,
			int admissionNo);

	void returnBookToLibarary(int bookId);
	
	

}
