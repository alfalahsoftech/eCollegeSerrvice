package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.ISBN;
import com.fadsan.model.Library;

public interface IsbnDao  extends DAO<Integer, ISBN>{

	ISBN getISBNbyLibraryBookId(Integer libraryBookId);

	List<ISBN> getBooksISBN_No(int bookId);

	ISBN getISBNByBookIdAndISBNNO(String isbnNo, int bookId);
	
	
	

}
