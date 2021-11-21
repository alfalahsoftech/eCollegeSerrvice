package com.fadsan.service;

import com.fadsan.model.Parents;
import com.fadsan.models.dto.ParentsDTO;

public interface ParentsService extends CRUDService<Integer, Parents> {

	String parentsRegistration(ParentsDTO dto) throws Exception;
}
