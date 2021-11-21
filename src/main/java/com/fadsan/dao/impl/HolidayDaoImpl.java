package com.fadsan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.fadsan.dao.HolidayDao;
import com.fadsan.model.Holiday;

@Service
@SuppressWarnings("unchecked")
public class HolidayDaoImpl extends DAOImpl<Integer, Holiday> implements
		HolidayDao {

	@Override
	public List<Holiday> getDataForCreateHoliday(Date fromDate, Date toDate) {
		return sessionFactory.getCurrentSession().createCriteria(Holiday.class)
				.add(Restrictions.between("holidayDate", fromDate, toDate))
				.list();
		/*
		 * .add(Restrictions.ge("holidayDate", fromDate))
		 * .add(Restrictions.le("holidayDate", toDate)).list();
		 */
	}

	@Override
	public Holiday getDataForCreateHoliday(Date date) {
		Date YesterDay = new Date(date.getTime() - (1000 * 60 * 60 * 24));
		Date tommarow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
		return (Holiday) sessionFactory.getCurrentSession()
				.createCriteria(Holiday.class)
				.add(Restrictions.eq("holidayDate",date))
				.uniqueResult();
	}

}
