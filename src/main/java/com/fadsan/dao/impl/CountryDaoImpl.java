package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.CountryDao;
import com.fadsan.model.Country;

@Transactional
@Repository("CountryDao")
public class CountryDaoImpl extends DAOImpl<Integer, Country> implements
		CountryDao {

	@Override
	public Country getCountryByName(String countryName) {
	
		return  (Country) sessionFactory.getCurrentSession()
				.createCriteria(Country.class)
				.add(Restrictions.eq("countryName", countryName))
				.add(Restrictions.eq("active", true)).uniqueResult();
	}

}
