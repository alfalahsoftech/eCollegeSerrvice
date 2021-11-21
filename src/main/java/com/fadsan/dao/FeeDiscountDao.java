package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.FeeDiscount;

public interface FeeDiscountDao extends DAO<Integer, FeeDiscount> {
	public List<FeeDiscount> getFeeDiscountDTOs(int classId, int sectioId,
			String studentAdmissionNo, Date fromDate, Date toDate);

	public List<FeeDiscount> getFeeDiscountDTOs(int classId, int sectioId,
			String studentAdmissionNo, Date lastDate);

	public List<FeeDiscount> getDiscountAmountByMonth(Date frmDate, Date toDate);
}
