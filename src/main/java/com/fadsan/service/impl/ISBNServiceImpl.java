package com.fadsan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadsan.dao.IsbnDao;
import com.fadsan.model.ISBN;
import com.fadsan.service.ISBNService;

@Service("ISBNService")
public class ISBNServiceImpl extends CRUDServiceImpl<Integer, ISBN, IsbnDao> implements ISBNService{
	@Autowired
	public ISBNServiceImpl(IsbnDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateISBN(String isbnNo, int bookId) {
		ISBN isbn=dao.getISBNByBookIdAndISBNNO(isbnNo,bookId);
		isbn.setIssueStatus("TRUE");
		dao.update(isbn);
	}

}
