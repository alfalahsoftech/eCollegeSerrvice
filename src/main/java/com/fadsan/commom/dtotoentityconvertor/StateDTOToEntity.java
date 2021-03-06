package com.fadsan.commom.dtotoentityconvertor;

import java.util.Date;

import com.fadsan.model.Country;
import com.fadsan.model.State;
import com.fadsan.models.dto.StateDTO;

public class StateDTOToEntity {
	private static final StateDTOToEntity stateDTOToEntity = new StateDTOToEntity();

	public static final StateDTOToEntity getInstance() {
		return stateDTOToEntity;
	}

	public State convertStateFromDtoToEntity(StateDTO stateDTO) {
		Date date = new Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		State state = new State();
		state.setActive(true);
		//state.setStateCode(stateDTO.getStateCode());
		state.setStateName(stateDTO.getStateName());
		Country country = new Country();
		country.setId(stateDTO.getCountryId());
		state.setCountry(country);
		state.setCreatedAt(date2);
		state.setUpdatedAt(date2);
		return state;
	}
}
