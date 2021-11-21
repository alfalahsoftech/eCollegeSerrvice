package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.IssueBook;
import com.fadsan.models.dto.IssueBookDTO;


public interface IssueBookDao extends DAO<Integer, IssueBook>{

	List<IssueBook> getIssuedBookByStudentId(String studentId);

	

}
