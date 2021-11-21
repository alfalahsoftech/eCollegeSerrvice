package com.fadsan.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.commom.dtotoentityconvertor.StateDTOToEntity;
import com.fadsan.commom.entitytodtoconvertor.StateEntityToDTO;
import com.fadsan.dao.StateDao;
import com.fadsan.model.State;
import com.fadsan.models.dto.StateDTO;
import com.fadsan.service.StateService;

@Transactional
@Service("stateService")
public class StateServiceImpl extends CRUDServiceImpl<Integer, State, StateDao>
		implements StateService {
	@Autowired
	public StateServiceImpl(StateDao dao) {
		super(dao);

	}

	@Transactional
	public void addState(StateDTO stateDTO) {
		StateDTOToEntity stateDTOToEntity = new StateDTOToEntity();
		dao.create(stateDTOToEntity.convertStateFromDtoToEntity(stateDTO));
	}

	@Transactional
	public void updateState(StateDTO stateDTO) {
		Date date = new Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		State state = read(stateDTO.getId());
		state.setStateName(stateDTO.getStateName());
		//state.setStateCode(stateDTO.getStateCode());
		state.setUpdatedAt(date2);
		dao.update(state);
	}

	@Transactional
	public List<StateDTO> getStateByCountryId(int id) {
		StateEntityToDTO dto = new StateEntityToDTO();
		return dto
				.getStateListFromStateEntityToDto(dao.getStateByCountryId(id));
	}

	public List<StateDTO> getStateById(int id) {
		StateEntityToDTO branchEntityToDTO = new StateEntityToDTO();
		return branchEntityToDTO.getStateListFromStateEntityToDto(dao
				.getStateById(id));
	}

	@Override
	public StateDTO getStateByName(int countryId, String stateName) {
		State state = dao.getStateByName(countryId, stateName);
		StateDTO stateDTO = new StateDTO();
		if (state != null) {
			stateDTO.setCountryId(state.getCountry().getCountryId());
			//stateDTO.setCountryCode(state.getCountry().getCountryCode());
			stateDTO.setCountryName(state.getCountry().getCountryName());
			//stateDTO.setStateCode(state.getStateCode());
			stateDTO.setStateName(state.getStateName());
			stateDTO.setId(state.getStateId());
		}
		return stateDTO;
	}

	@Override
	public StateDTO getStateByStateId(int stateId) {
		State state = dao.get(stateId);
		StateDTO stateDTO = new StateDTO();
		stateDTO.setCountryId(state.getCountry().getCountryId());
		//stateDTO.setCountryCode(state.getCountry().getCountryCode());
		stateDTO.setCountryName(state.getCountry().getCountryName());
		//stateDTO.setStateCode(state.getStateCode());
		stateDTO.setStateName(state.getStateName());
		stateDTO.setId(state.getStateId());
		return stateDTO;
	}
}
