package com.fadsan.dao;

import com.fadsan.model.Country;

public interface CountryDao extends DAO<Integer, Country> {
	public Country getCountryByName(String countryName);
}
