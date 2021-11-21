package com.fadsan.service;

import java.util.List;

import com.fadsan.model.ClassWiseFee;
import com.fadsan.models.dto.ClassWiseFeeDTO;

public interface ClassWiseFeeService extends CRUDService<Integer, ClassWiseFee> {

	String saveClassWiseFee(ClassWiseFeeDTO classWiseFeeDTO);

	List<ClassWiseFeeDTO> getClassWiseFee(int sessionId, int classId, Integer[] monthId,
			int categoryId);

	List<ClassWiseFeeDTO> getAllClassFees();

	void setActiveById(int classWiseFeeId);

	List<ClassWiseFeeDTO> getAllotedFeesByClassId(int classId, int sessionId);

	String deleteAllotedFeesCategory(int classId, int monthId,
			int classWiseFeeId);

	

}
