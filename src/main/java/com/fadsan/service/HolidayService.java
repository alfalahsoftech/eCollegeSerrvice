package com.fadsan.service;

import java.util.Map;

import com.fadsan.model.Holiday;
import com.fadsan.models.dto.HolidayDTO;

public interface HolidayService extends CRUDService<Integer, Holiday> {
   Map<String, Object> getDataForCreateHoliday(int monthId,int year) throws Exception;
   public void crateHolidays(HolidayDTO holidayDTO)throws Exception;
   public HolidayDTO checkHolidays(String holidayDate)throws Exception;
   public void editHolidays(HolidayDTO holidayDTO)throws Exception;
   
}
