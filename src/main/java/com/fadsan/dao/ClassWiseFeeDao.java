package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.ClassWiseFee;
import com.fadsan.model.EditFeeAmount;

public interface ClassWiseFeeDao extends DAO<Integer, ClassWiseFee> {
	List<ClassWiseFee> getClassWiseFee(int sessionId, int classId,
			Integer[] monthId, int categoryId);

	List<ClassWiseFee> getFeeAllotement(int sessionId, int classId, int monthId);

	List<ClassWiseFee> getClassWiseFeeAllotementByMonth(int MonthId);

	List<ClassWiseFee> getClassWiseFeeAllotementBySessionId(int sessionId);

	List<ClassWiseFee> getAllotedFeesByClassId(int classId, int sessionId);

	List<EditFeeAmount> getDiscountAfterEdit(int monthId);

	List<EditFeeAmount> getDiscountAfterEditBySessionId(int sessionId);
}
