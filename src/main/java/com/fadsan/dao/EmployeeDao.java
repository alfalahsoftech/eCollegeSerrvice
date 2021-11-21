package com.fadsan.dao;

import java.util.List;

import com.fadsan.model.Employees;

public interface EmployeeDao extends DAO<Integer, Employees> {

	Employees finddetailsbyUserId(Integer id);

	List<Employees> getEmployee(String firstName);

	List<Employees> getEmployee(Boolean Active);

}
