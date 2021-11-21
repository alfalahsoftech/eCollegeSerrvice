package com.fadsan.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.StudentTransfer;

@Transactional
public interface StudentTransferDao extends DAO<Integer, StudentTransfer> {

	StudentTransfer getTcfortudent(String studentId);

}
