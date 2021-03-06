package com.fadsan.service;

import java.text.ParseException;
import java.util.List;

import com.fadsan.model.Expense;
import com.fadsan.models.dto.ExpenseDTO;

public interface ExpenseService extends CRUDService<Integer, Expense> {

	List<ExpenseDTO> findoverall();

	List<ExpenseDTO> findtodaysexpense() throws ParseException;

	List<ExpenseDTO> finddatewiseexpense(String from, String to)
			throws ParseException;

	List<ExpenseDTO> findyearlyexpense(int yearfrom, int yearto)
			throws ParseException;

	void addExpenses(ExpenseDTO dto) throws ParseException;

	List<ExpenseDTO> findoverallByPageNo(int pageNo);

	List<ExpenseDTO> getTodaysAllExpense(String date) throws Exception;

	List<String> findEmployeebyName(String role);
}
