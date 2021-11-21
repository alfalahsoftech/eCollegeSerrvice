package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Month;

public interface MonthDao extends DAO<Integer, Month> {
	List<Integer> getMonthId();

	Month getMonthBySerialno(int serialNo);

	List<Month> getMonthInserial();

	List<Month> findSomeMonths(int months1);
}
