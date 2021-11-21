package com.fadsan.commom.dtotoentityconvertor;

import java.util.Date;

import com.fadsan.model.Library;
import com.fadsan.models.dto.LibraryDTO;

public class LibraryDTOToEntity {

	public final static LibraryDTOToEntity libraryDTOToEntity = new LibraryDTOToEntity();

	public static LibraryDTOToEntity getInstance() {
		return libraryDTOToEntity;
	}

	public Library convertLibratyDTOToEntity(LibraryDTO libraryDTO) {

		Library library = new Library();
		library.setBookName(libraryDTO.getBookName());
		library.setQuantity(libraryDTO.getQuantity());
		library.setSubjectName(libraryDTO.getSubjectName());
		library.setRemainingQuantity(libraryDTO.getQuantity());
		library.setBookAuthor(libraryDTO.getBookAuthor());
		library.setBookCopyright(libraryDTO.getBookCopyright());
		library.setBookEditionNumber(libraryDTO.getBookEditionNumber());
		library.setBookPublisher(libraryDTO.getBookPublisher());
		library.setLibraryName(libraryDTO.getLibraryName());
		library.setShelfNo(libraryDTO.getShelfNo());
		library.setTotalBookPage(libraryDTO.getTotalBookPage());
		library.setDate(new Date());
		return library;

	}

}
