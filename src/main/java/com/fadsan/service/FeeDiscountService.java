package com.fadsan.service;

import java.util.List;

import com.fadsan.model.FeeDiscount;
import com.fadsan.models.dto.FeeDiscountDTO;

public interface FeeDiscountService extends CRUDService<Integer, FeeDiscount> {
	public void createFeeDiscount(int classId, int sectioId,
			String studentAdmissionNo, String feeDiscountName,
			Double feeDiscountAmount,String lastDate,String fromDate,String toDate);

	public void updateFeeDiscount(int feeDiscountId, String feeDiscountName,
			Double feeDiscountAmount);

	public List<FeeDiscountDTO> getFeeDiscountDTOs(int classId, int sectioId,
			String studentAdmissionNo,String fromDate,String toDate);

	FeeDiscountDTO getFeeDiscountById(int feeDiscountId);
}
