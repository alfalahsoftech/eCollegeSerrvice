package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fadsan.dao.LibraryDao;
import com.fadsan.model.Library;
import com.fadsan.model.StudentClasses;

@Repository("LibraryDao")
public class LibraryDaoImpl extends DAOImpl<Integer, Library> implements
		LibraryDao {

	@Override
	public Library getLastRecord() {

		Session session = sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("from Library order by libraryBookId DESC");
		query.setMaxResults(1);
		Library last = (Library) query.uniqueResult();
		return last;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getSubjectByClass(Integer classId) {

		return sessionFactory.getCurrentSession().createCriteria(Library.class)
				.add(Restrictions.eq("classId.classId", classId)).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Library> getSubjectDetails(Integer classId, String subjectName) {
		return sessionFactory.getCurrentSession().createCriteria(Library.class)
				.add(Restrictions.eq("subjectName", subjectName))
				.add(Restrictions.eq("classId.classId", classId)).list();
	}

}
