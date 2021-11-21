package com.fadsan.service;

import com.fadsan.model.SchoolRegistration;
import com.fadsan.models.dto.SchoolRegistrationDTO;

public interface SchoolRegistraionService extends CRUDService<Integer, SchoolRegistration> {

	String registerSchool(SchoolRegistrationDTO schoolRegistrationDTO);

	SchoolRegistrationDTO getSchoolList();

	String updateRegisteredSchool(SchoolRegistrationDTO schoolRegistrationDTO);

	String deleteRegisteredSchool(int id);

}
