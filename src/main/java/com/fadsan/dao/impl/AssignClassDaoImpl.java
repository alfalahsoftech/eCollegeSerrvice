package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fadsan.dao.AssignClassDao;
import com.fadsan.model.AssignClass;

@Transactional
@Repository("assignClassDao")
public class AssignClassDaoImpl extends DAOImpl<Integer, AssignClass> implements
		AssignClassDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AssignClass> getAssignClassById(int employeeId) {
		return (List<AssignClass>) (sessionFactory.getCurrentSession()
				.createCriteria(AssignClass.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.eq(
				"employees.employeeId", employeeId))).list();
	}

	@Override
	public AssignClass checkAssignClassesForTecher(int sectionId, int classId) {
		return (AssignClass) (sessionFactory.getCurrentSession()
				.createCriteria(AssignClass.class)
				.add(Restrictions.eq("section.sectionId", sectionId))
				.add(Restrictions.eq("studentClasses.classId", classId))
				.add(Restrictions.eq("active", true))).uniqueResult();
	}

	@Override
	public AssignClass getAssignClassAndSection(int employeeId) {
		return (AssignClass) sessionFactory.getCurrentSession()
				.createCriteria(AssignClass.class)
				.add(Restrictions.eq("employees.employeeId", employeeId))
				.add(Restrictions.eq("active", true)).uniqueResult();
	}
}
