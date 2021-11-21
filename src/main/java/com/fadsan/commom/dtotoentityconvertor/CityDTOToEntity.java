package com.fadsan.commom.dtotoentityconvertor;

import java.util.Date;

import com.fadsan.model.City;
import com.fadsan.model.Country;
import com.fadsan.model.State;
import com.fadsan.models.dto.CityDTO;

public class CityDTOToEntity {
	
	private static final CityDTOToEntity cityDTOToEntity = new CityDTOToEntity();

	public static final CityDTOToEntity getInstance() {
		return cityDTOToEntity;
	}

	public City convertCityFromDtoToEntity(CityDTO cityDTO) {
		Date date = new Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		City city = new City();
		city.setActive(true);
		//city.setCityCode(cityDTO.getCityCode());
		city.setCityName(cityDTO.getCityName());
		Country country = new Country();
		State state = new State();
		country.setId(cityDTO.getCountryId());
		state.setStateId(cityDTO.getStateId());
		city.setCountry(country);
		city.setState(state);
		city.setCreatedAt(date2);
		city.setUpdatedAt(date2);
		return city;
	}
}
