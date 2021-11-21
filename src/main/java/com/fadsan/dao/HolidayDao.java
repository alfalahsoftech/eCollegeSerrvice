package com.fadsan.dao;

import java.util.Date;
import java.util.List;

import com.fadsan.model.Holiday;

public interface HolidayDao extends DAO<Integer, Holiday> {
	public List<Holiday> getDataForCreateHoliday(Date fromDate, Date toDate);
	public Holiday getDataForCreateHoliday(Date date);
}
