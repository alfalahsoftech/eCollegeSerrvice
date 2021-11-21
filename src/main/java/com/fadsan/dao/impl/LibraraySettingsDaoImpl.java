package com.fadsan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.LibraraySettingsDao;
import com.fadsan.model.LibraraySettings;
@Transactional
@Repository("LibraraySettingsDao")
public class LibraraySettingsDaoImpl extends DAOImpl<Integer, LibraraySettings>
implements LibraraySettingsDao{

	@Override
	public LibraraySettings checkData(int sessionId) {
		return (LibraraySettings) sessionFactory.getCurrentSession()
				.createCriteria(LibraraySettings.class)
				.add(Restrictions.eq("session.sessionId", sessionId))
				.add(Restrictions.eq("active", true)).uniqueResult();
				

}
}
