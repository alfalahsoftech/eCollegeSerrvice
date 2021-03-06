package com.fadsan.service;

import java.text.ParseException;
import java.util.List;

import com.fadsan.model.UniformSupplier;
import com.fadsan.models.dto.UniformSupplierDTO;

public interface UniformSupplierService extends
		CRUDService<Integer, UniformSupplier> {

	List<String> getSupplierNames();

	List<UniformSupplierDTO> getSupplierDetails(String supplierName)
			throws ParseException;

	UniformSupplierDTO savePurchasedUniforms(
			UniformSupplierDTO uniformSupplierDTO) throws ParseException;

	UniformSupplierDTO getBoughtReceipt(int receiptNo);

	List<UniformSupplierDTO> getUniformsBoughtDetails() throws ParseException;

	void updateStatus(int id, String status) throws ParseException;

	List<UniformSupplierDTO> findOverallByPageNo(int pageNo);

	List<UniformSupplierDTO> findTodaysExpense() throws ParseException;

	List<UniformSupplierDTO> getUniformsBoughtDetails(String date)
			throws ParseException;

	List<UniformSupplierDTO> findDatewiseExpense(String from, String to)
			throws ParseException;

}
