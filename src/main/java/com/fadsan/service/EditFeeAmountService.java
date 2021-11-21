package com.fadsan.service;

import java.util.List;

import com.fadsan.model.EditFeeAmount;
import com.fadsan.models.dto.EditFeeAmountDTO;

public interface EditFeeAmountService extends
		CRUDService<Integer, EditFeeAmount> {
	public List<EditFeeAmountDTO> getEditFeeAmountDTOs(int classId,
			int sectionId, int sessionId, int feeCategoryId, int monthId,
			String studentId, double allottedAmount);

	public void createEditFeeAmount(EditFeeAmountDTO editFeeAmountDTO);
}
