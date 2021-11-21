package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.State;

public interface StateDao extends DAO<Integer, State> {
	List<State> getStateByCountryId(int id);

	List<State> getStateById(int id);
	
	public State getStateByName(int countryId,String stateName);
}
