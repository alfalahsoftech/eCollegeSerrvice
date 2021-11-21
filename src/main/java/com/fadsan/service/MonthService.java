package com.fadsan.service;

import java.util.List;

import com.fadsan.model.Month;
import com.fadsan.models.dto.MonthDTO;

public interface MonthService  extends CRUDService<Integer, Month>{
	public List<MonthDTO> getMonthInOrderToSerialNo();

	public List<MonthDTO> getMonthInOrder();

}
