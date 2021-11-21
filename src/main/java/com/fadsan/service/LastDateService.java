package com.fadsan.service;

import java.text.ParseException;
import java.util.List;

import com.fadsan.model.LastDate;
import com.fadsan.models.dto.LastDateDTO;

public interface LastDateService extends CRUDService<Integer, LastDate> {

	List<String> getLastDatecheck(int monthId);

	List<LastDateDTO> getLastDates();

	String changeLastDate(LastDateDTO lastDateDTO) throws ParseException;

	List<LastDateDTO> getLastDatesBySessionId(Integer sessionId);

	Boolean createLastDate(LastDateDTO lastDateDTO) throws ParseException;

}
