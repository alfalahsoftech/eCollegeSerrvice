package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.EditFeeAmount;

public interface EditFeeAmountDao extends DAO<Integer, EditFeeAmount> {
	public List<Integer> getEditFeeAmountDTOs(int classId, int sectionId,
			int sessionId, int feeCategoryId, String studentId);

	EditFeeAmount getDiscountAmountBySessionMonthCategoryId(int sessionId,
			int monthId, int feeCategoryId, int admissionNo);
	
	public EditFeeAmount getEditFeeAmountDTOs(int classId, int sectionId,
			int sessionId, int feeCategoryId, String studentId, int monthId);

	public List<EditFeeAmount> getEditFeeAmountDTOsLast(int classId,
			int sectionId, int sessionId, int feeCategoryId, String studentId);

}
