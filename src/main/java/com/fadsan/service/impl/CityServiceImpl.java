package com.fadsan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.dtotoentityconvertor.CityDTOToEntity;
import com.fadsan.commom.entitytodtoconvertor.CityEntityToDTO;
import com.fadsan.dao.CityDao;
import com.fadsan.model.City;
import com.fadsan.models.dto.CityDTO;
import com.fadsan.service.CityService;

@Transactional
@Service("cityService")
public class CityServiceImpl extends CRUDServiceImpl<Integer, City, CityDao>
		implements CityService {
	@Autowired
	public CityServiceImpl(CityDao dao) {
		super(dao);
	}

	@Transactional
	public void addCity(CityDTO cityDTO) {
		CityDTOToEntity citDTOToEntity = new CityDTOToEntity();
		dao.create(citDTOToEntity.convertCityFromDtoToEntity(cityDTO));
	}

	@Transactional
	public void updateCity(CityDTO cityDTO) {
		City city = read(cityDTO.getId());
		city.setCityName(cityDTO.getCityName());
		//city.setCityCode(cityDTO.getCityCode());
		dao.update(city);
	}

	@Override
	public List<CityDTO> getCityByStateIdAndcountryId(int id, int countryId) {
		CityEntityToDTO dto = new CityEntityToDTO();
		return dto.getCityListFromCityEntityToDto(dao
				.getCityByStateIdAndcountryId(id, countryId));

	}

	@Override
	public List<CityDTO> getCityByStateId(int id) {
		CityEntityToDTO dto = new CityEntityToDTO();
		return dto.getCityListFromCityEntityToDto(dao.getCityByStateId(id));
	}

	@Override
	public CityDTO getCityByStateIdAndcountryId(int id, int countryId,
			String cityName) {
		CityEntityToDTO dto = CityEntityToDTO.getInstance();
		return dto.getInstance(dao.getCityByStateIdAndcountryId(id, countryId,
				cityName));
	}

	@Override
	public CityDTO getCityById(int cityId) {
		CityEntityToDTO cityEntityToDTO = new CityEntityToDTO();
		CityDTO cityDTO = new CityDTO();
		cityDTO = cityEntityToDTO.getInstance(dao.get(cityId));
		return cityDTO;
	}
}
