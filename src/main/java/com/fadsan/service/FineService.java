package com.fadsan.service;

import com.fadsan.model.Fine;
import com.fadsan.models.dto.FineDTO;

public interface FineService extends CRUDService<Integer, Fine> {
	public FineDTO getFineByName(String Name, Integer integer);

	public void createFine(FineDTO fine);

	public void updateFine(FineDTO fine);
}
