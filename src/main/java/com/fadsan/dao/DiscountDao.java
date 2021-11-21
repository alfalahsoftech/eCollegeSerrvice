package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.Discount;

public interface DiscountDao extends DAO<Integer, Discount> {

	List<Discount> getDiscountAmountByMonth(Date frmDate, Date toDate);

	Discount getDiscountbyFeeSubId(Integer studentFeeSubmissionDetailsId);

}
