package com.fadsan.service;

import com.fadsan.model.NewStudentTransfer;
import com.fadsan.models.dto.NewStudentTransferDTO;

public interface NewStudentTransferService extends CRUDService<Integer, NewStudentTransfer>{

	void saveNewStudentTransfer(NewStudentTransferDTO newStudentTransferDTO);

	NewStudentTransferDTO getneweGeneratedTC(String studentId);
	
	

}
