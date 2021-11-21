package com.fadsan.service;

import java.util.List;

import com.fadsan.model.City;
import com.fadsan.models.dto.CityDTO;

public interface CityService extends CRUDService<Integer, City> {
	void addCity(CityDTO cityDTO);

	void updateCity(CityDTO cityDTO);

	List<CityDTO> getCityByStateIdAndcountryId(int id, int countryId);

	List<CityDTO> getCityByStateId(int id);
	CityDTO getCityByStateIdAndcountryId(int id, int countryId,String cityName);
	CityDTO getCityById(int cityId);
}
