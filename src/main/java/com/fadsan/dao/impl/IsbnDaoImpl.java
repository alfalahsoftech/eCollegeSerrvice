package com.fadsan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fadsan.dao.IsbnDao;
import com.fadsan.dao.LibraryDao;
import com.fadsan.model.ISBN;
import com.fadsan.model.Library;
import com.fadsan.model.StudentClasses;

@Repository("IsbnDao")
public class IsbnDaoImpl extends DAOImpl<Integer, ISBN> implements IsbnDao {

	@Override
	public ISBN getISBNbyLibraryBookId(Integer libraryBookId) {

		return (ISBN) sessionFactory
				.getCurrentSession()
				.createCriteria(ISBN.class)
				.add(Restrictions.eq("libraryBookId.libraryBookId",
						libraryBookId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ISBN> getBooksISBN_No(int libraryBookId) {

		return sessionFactory
				.getCurrentSession()
				.createCriteria(ISBN.class)
				.add(Restrictions.eq("libraryBookId.libraryBookId",
						libraryBookId))
				.add(Restrictions.eq("issueStatus", "FALSE")).list();
	}

	@Override
	public ISBN getISBNByBookIdAndISBNNO(String isbnNo, int bookId) {
	
		return (ISBN) sessionFactory
				.getCurrentSession()
				.createCriteria(ISBN.class)
				.add(Restrictions.eq("libraryBookId.libraryBookId",
						bookId))
				.add(Restrictions.eq("isbnNo", isbnNo)).uniqueResult();
	}

}
