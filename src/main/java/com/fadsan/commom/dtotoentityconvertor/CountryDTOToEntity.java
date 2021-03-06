package com.fadsan.commom.dtotoentityconvertor;

import java.util.Date;

import com.fadsan.model.Country;
import com.fadsan.models.dto.CountryDTO;

public class CountryDTOToEntity {
	private static final CountryDTOToEntity countryEntityToDto = new CountryDTOToEntity();

	public static final CountryDTOToEntity getInstance() {
		return countryEntityToDto;
	}

	public Country convertCountryFromDtoToEntity(CountryDTO countryDTO) {
		Date date = new Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		Country country = new Country();
		country.setActive(true);
		country.setCountryName(countryDTO.getCountryName());
		//country.setCountryCode(countryDTO.getCountryCode());
		country.setCreatedAt(date2);
		country.setUpdatedAt(date2);
		return country;
	}
}
