package com.fadsan.service;

import java.util.List;

import com.fadsan.model.State;
import com.fadsan.models.dto.StateDTO;

public interface StateService extends CRUDService<Integer, State> {
	void addState(StateDTO stateDTO);

	void updateState(StateDTO stateDTO);

	List<StateDTO> getStateByCountryId(int id);

	List<StateDTO> getStateById(int id);
	
	StateDTO getStateByName(int countryId,String stateName);
	StateDTO getStateByStateId(int stateId);
}
