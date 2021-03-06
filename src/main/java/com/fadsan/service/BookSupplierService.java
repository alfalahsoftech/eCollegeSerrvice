package com.fadsan.service;

import java.text.ParseException;
import java.util.List;

import com.fadsan.model.BookSupplier;
import com.fadsan.models.dto.BookSupplierDTO;

public interface BookSupplierService extends CRUDService<Integer, BookSupplier> {

	List<String> getSupplierNames();

	List<BookSupplierDTO> getSupplierDetails(String supplierName)
			throws ParseException;

	BookSupplierDTO savePurchasedBook(BookSupplierDTO bookSupplierDTO)
			throws ParseException;

	BookSupplierDTO getBookBoughtReceipt(int receiptNo);

	List<BookSupplierDTO> getBookBoughtDetails() throws ParseException;

	void updateStatus(int id, String status) throws ParseException;

	List<BookSupplierDTO> getBookBoughtDetails(String stringDate)
			throws ParseException;

	List<BookSupplierDTO> findOverallByPageNo(int pageNo);

	List<BookSupplierDTO> findtodaysexpense() throws ParseException;

	List<BookSupplierDTO> findDatewiseExpense(String fromDate, String toDate)
			throws ParseException;

}
