package com.fadsan.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.MonthDao;
import com.fadsan.model.Month;
import com.fadsan.models.dto.MonthDTO;
import com.fadsan.service.MonthService;

@Transactional
@Service("monthService")
public class MonthServiceImpl extends CRUDServiceImpl<Integer, Month, MonthDao>
		implements MonthService {
	@Autowired
	public MonthServiceImpl(MonthDao dao) {
		super(dao);
	}

	@Override
	public List<MonthDTO> getMonthInOrderToSerialNo() {
		List<MonthDTO> monthDTOs = new ArrayList<MonthDTO>();
		List<Month> months = dao.findAll(Month.class);
		for (Month month : months) {
			MonthDTO monthDTO = new MonthDTO();
			monthDTO.setMonthId(month.getMonthId());
			monthDTO.setMonthName(month.getMonthName());
			monthDTO.setMonthSerialNo(month.getSerialNo());
			monthDTOs.add(monthDTO);
		}
		if (monthDTOs.size() > 0) {
			Collections.sort(monthDTOs, new Comparator<MonthDTO>() {
				@Override
				public int compare(MonthDTO o1, MonthDTO o2) {
					return o1.getMonthSerialNo().compareTo(
							o2.getMonthSerialNo());
				}
			});
		}
		return monthDTOs;
	}

	@Override
	public List<MonthDTO> getMonthInOrder() {
		List<MonthDTO> monthDTOs = new ArrayList<MonthDTO>();
		List<Month> months = dao.getMonthInserial();
		for (Month month : months) {
			MonthDTO monthDTO = new MonthDTO();
			monthDTO.setMonthId(month.getMonthId());
			monthDTO.setMonthName(month.getMonthName());
			monthDTO.setMonthSerialNo(month.getSerialNo());
			monthDTOs.add(monthDTO);
		}
		return monthDTOs;
	}

}
