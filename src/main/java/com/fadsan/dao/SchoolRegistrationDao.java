package com.fadsan.dao;

import com.fadsan.model.SchoolRegistration;

public interface SchoolRegistrationDao extends DAO<Integer, SchoolRegistration> {

	SchoolRegistration getRegisterSchool();

}
