package com.fadsan.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.model.StudentTransfer;
import com.fadsan.models.dto.StudentTransferDTO;

@Transactional
@Service
public interface StudentTransferService extends CRUDService<Integer, StudentTransfer> {

	void saveTransferData(StudentTransferDTO studentTransferDTO) throws ParseException;

	StudentTransferDTO generateTC(String studentId);

}
