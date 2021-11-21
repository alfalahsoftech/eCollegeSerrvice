package com.fadsan.dao;

import com.fadsan.model.NewStudentTransfer;
public interface NewStudentTransferDao extends DAO<Integer, NewStudentTransfer>{

	NewStudentTransfer getTCForStudent(String studentId);

	
	

}
