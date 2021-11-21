package com.fadsan.service;

import com.fadsan.model.ISBN;

public interface ISBNService extends CRUDService<Integer, ISBN> {

	void updateISBN(String isbnNo, int bookId);
	

}
