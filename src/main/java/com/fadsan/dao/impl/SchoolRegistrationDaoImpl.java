package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.SchoolRegistrationDao;
import com.fadsan.model.SchoolRegistration;

@Transactional
@Repository("schoolRegistrationDao")
public class SchoolRegistrationDaoImpl extends DAOImpl<Integer, SchoolRegistration>
implements SchoolRegistrationDao {

	@Override
	public SchoolRegistration getRegisterSchool() {
		
		return (SchoolRegistration) sessionFactory.getCurrentSession()
				.createCriteria(SchoolRegistration.class)
				.add(Restrictions.eq("active", true)).uniqueResult();
	}

}
